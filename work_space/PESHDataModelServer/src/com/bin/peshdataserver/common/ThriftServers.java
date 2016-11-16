package com.bin.peshdataserver.common;

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
 * @author namnq
 *
 */
public class ThriftServers {

	////
	protected Class _serverClass = null;

	protected ThreadPoolExecutor _executor = null;
	// <-- for managing servers
	////////////////////////////////////////////////////////////////////////////

	private static final Logger _Log = Logger.getLogger(ThriftServers.class);
	protected String _name;
	protected TServer _server;
	protected Config _config = null;
	private final AtomicBoolean _running = new AtomicBoolean(false);

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

		private final TServer _server;
		private final AtomicBoolean _running;

		public ServerRunner(TServer server, AtomicBoolean running) {
			assert (server != null && running != null);
			_server = server;
			_running = running;
		}

		@Override
		public void run() {
			_Log.info("Thrift server is going to serve");
			try {
				_server.serve();
			} catch (Exception ex) {
				_Log.error(null, ex);
			}
			_Log.info("Thrift server stopped");
			_running.set(false);
		}
	}

	public ThriftServers(Config config) {
		_config = config;
	}

	public final String getName() {
		return _name;
	}

	public final TServer getServer() {
		return _server;
	}

	public final Config getConfig() {
		return _config.clone();
	}

	public final boolean isRunning() {
		return _running.get();
	}

	public final Class getServerClass() {
		return _serverClass;
	}

	public final ThreadPoolExecutor getExecutor() {
		return _executor;
	}

	public boolean setup(TProcessor processor) {
		if (_server != null) {
			_Log.warn("Server was already setup, dont need to setup again");
			return true;
		}
		try {
			assert (processor != null);
			setupThreadedSelectorServer(processor);
			return true;
		} catch (Exception ex) {
			_Log.error(null, ex);
			return false;
		}
	}

	private void setupThreadedSelectorServer(TProcessor processor) throws TTransportException, UnknownHostException {
		assert (_config.isValid());

		//===== setup socket =====
		InetAddress inetAddr = InetAddress.getByName(_config.host); //may throw UnknownHostException
		TNonblockingServerSocket socket = new TNonblockingServerSocket(_config.port); //may throw TTransportException
		TThreadedSelectorServer.Args options = new TThreadedSelectorServer.Args(socket);

		//===== setup executor =====
		LinkedBlockingQueue<Runnable> workQueue;
		if (_config.maxWorkQueueSize > 0) {
			workQueue = new LinkedBlockingQueue<Runnable>(_config.maxWorkQueueSize);
		} else {
			workQueue = new LinkedBlockingQueue<Runnable>(); //unlimited size
		}
		int stopTimeoutVal = options.getStopTimeoutVal(); //use default: 60
		TimeUnit stopTimeoutUnit = options.getStopTimeoutUnit(); //use default: SECONDS
		_executor = new ThreadPoolExecutor(
				_config.ncoreThreads,
				_config.nmaxThreads,
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
		options.executorService(_executor);
		options.processor(processor);
		options.maxReadBufferBytes = _config.maxFrameSize;
		options.transportFactory(new TFramedTransport.Factory(_config.maxFrameSize));
		options.protocolFactory(new TBinaryProtocol.Factory(false /*strictRead*/, true /*strictWrite*/));
		options.acceptPolicy(_config.acceptPolicy);
		options.acceptQueueSizePerThread(_config.acceptQueueSizePerThread);
		options.selectorThreads = _config.nselectorThreads;

		//===== setup server =====
		_server = new TThreadedSelectorServer(options);
		_Log.info(String.format("Thrift server (TThreadedSelectorServer-%s) listens on %s:%s", _name, inetAddr.getHostAddress(), _config.port));
	}

	public boolean start() {
		if (_server == null) {
			return false;
		}
		if (!_running.compareAndSet(false, true)) {
			_Log.warn("Server is already running, dont need to start again");
			return true;
		}
		Thread thread = new Thread(new ServerRunner(_server, _running), "ThriftServers");
		thread.start();
		return true;
	}

	public void stop() {
		if (_server == null) {
			return;
		}
		if (_running.get()) {
			_server.stop();
		}
	}
}
