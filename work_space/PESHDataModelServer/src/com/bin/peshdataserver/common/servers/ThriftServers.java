package com.bin.peshdataserver.common.servers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.server.TThreadedSelectorServer.Args.AcceptPolicy;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * server use Framed transport and Binary protocol
 *
 * @author tanpt
 *
 */
public class ThriftServers {

	////
	protected Class serverClass_ = null;

	protected ThreadPoolExecutor executor_ = null;
	// <-- for managing servers
	////////////////////////////////////////////////////////////////////////////

	private static final Logger LOGGER = Logger.getLogger(ThriftServers.class);
	protected String name_;
	protected TServer server_;
	protected Config config_ = null;
	private final AtomicBoolean running_ = new AtomicBoolean(false);

	public static class Config {

		public String host = "0.0.0.0";
		public int port = 1;
		public int ncoreThreads = 16;
		public int nmaxThreads = ncoreThreads * 2;
		public int maxWorkQueueSize = 0;
		//
		public boolean framed = true;
		public int maxFrameSize = 65536 /*64KiB*/;
		public int totalFrameSize = 1073741824 /*1GiB*/;
		//
		public AcceptPolicy acceptPolicy = AcceptPolicy.FAST_ACCEPT;
		public int acceptQueueSizePerThread = 64;
		public int nselectorThreads = 8;

		@Override
		public Config clone() {
			Config ret = new Config();
			ret.host = this.host;
			ret.port = this.port;
			ret.ncoreThreads = this.ncoreThreads;
			ret.nmaxThreads = this.nmaxThreads;
			ret.maxWorkQueueSize = this.maxWorkQueueSize;
			//
			ret.framed = this.framed;
			ret.maxFrameSize = this.maxFrameSize;
			ret.totalFrameSize = this.totalFrameSize;
			//
			ret.acceptPolicy = this.acceptPolicy;
			ret.acceptQueueSizePerThread = this.acceptQueueSizePerThread;
			ret.nselectorThreads = this.nselectorThreads;
			return ret;
		}

		public boolean isValid() {
			boolean valid = true;
			valid = valid && !host.isEmpty() && port > 0 && ncoreThreads > 0 && nmaxThreads >= ncoreThreads;

			valid = valid && acceptQueueSizePerThread > 0 && nselectorThreads > 0
					&& (acceptPolicy == AcceptPolicy.FAIR_ACCEPT || acceptPolicy == AcceptPolicy.FAST_ACCEPT);

			return valid;
		}
	}

	protected class ServerRunner implements Runnable {

		private final TServer server_;
		private final AtomicBoolean running_;

		public ServerRunner(TServer server, AtomicBoolean running) {
			assert (server != null && running != null);
			server_ = server;
			running_ = running;
		}

		@Override
		public void run() {
			LOGGER.info("Thrift server is going to serve");
			try {
				server_.serve();
			} catch (Exception ex) {
				LOGGER.error(null, ex);
			}
			LOGGER.info("Thrift server stopped");
			running_.set(false);
		}
	}

	public ThriftServers(Config config) {
		config_ = config;
	}

	public final String getName() {
		return name_;
	}

	public final TServer getServer() {
		return server_;
	}

	public final Config getConfig() {
		return config_.clone();
	}

	public final boolean isRunning() {
		return running_.get();
	}

	public final Class getServerClass() {
		return serverClass_;
	}

	public final ThreadPoolExecutor getExecutor() {
		return executor_;
	}

	public boolean setup(TProcessor processor) {
		if (server_ != null) {
			LOGGER.warn("Server was already setup, dont need to setup again");
			return true;
		}
		try {
			assert (processor != null);
			setupThreadedSelectorServer(processor);
			return true;
		} catch (Exception ex) {
			LOGGER.error(null, ex);
			return false;
		}
	}

	private void setupThreadedSelectorServer(TProcessor processor) throws TTransportException, UnknownHostException {
		assert (config_.isValid());

		//===== setup socket =====
		InetAddress inetAddr = InetAddress.getByName(config_.host); //may throw UnknownHostException
		TNonblockingServerSocket socket = new TNonblockingServerSocket(config_.port); //may throw TTransportException
		TThreadedSelectorServer.Args options = new TThreadedSelectorServer.Args(socket);

		//===== setup executor =====
		LinkedBlockingQueue<Runnable> workQueue;
		if (config_.maxWorkQueueSize > 0) {
			workQueue = new LinkedBlockingQueue<Runnable>(config_.maxWorkQueueSize);
		} else {
			workQueue = new LinkedBlockingQueue<Runnable>(); //unlimited size
		}
		int stopTimeoutVal = options.getStopTimeoutVal(); //use default: 60
		TimeUnit stopTimeoutUnit = options.getStopTimeoutUnit(); //use default: SECONDS
		executor_ = new ThreadPoolExecutor(
				config_.ncoreThreads,
				config_.nmaxThreads,
				stopTimeoutVal,
				stopTimeoutUnit,
				workQueue,
				new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				if (t.isDaemon()) {
					t.setDaemon(false);
				}
				if (t.getPriority() != Thread.NORM_PRIORITY) {
					t.setPriority(Thread.NORM_PRIORITY);
				}
				return t;
			}
		});

		//===== setup options =====
		options.executorService(executor_);
		options.processor(processor);
		options.maxReadBufferBytes = config_.maxFrameSize;
		options.transportFactory(new TFramedTransport.Factory(config_.maxFrameSize));
		options.protocolFactory(new TBinaryProtocol.Factory(false /*strictRead*/, true /*strictWrite*/));
		options.acceptPolicy(config_.acceptPolicy);
		options.acceptQueueSizePerThread(config_.acceptQueueSizePerThread);
		options.selectorThreads = config_.nselectorThreads;

		//===== setup server =====
		server_ = new TThreadedSelectorServer(options);
		LOGGER.info(String.format("Thrift server (TThreadedSelectorServer-%s) listens on %s:%s", name_, inetAddr.getHostAddress(), config_.port));
	}

	public boolean start() {
		if (server_ == null) {
			return false;
		}
		if (!running_.compareAndSet(false, true)) {
			LOGGER.warn("Server is already running, dont need to start again");
			return true;
		}
		Thread thread = new Thread(new ServerRunner(server_, running_), "ThriftServers");
		thread.start();
		return true;
	}

	public void stop() {
		if (server_ == null) {
			return;
		}
		if (running_.get()) {
			server_.stop();
		}
	}
}
