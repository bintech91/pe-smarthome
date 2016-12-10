/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.common.servers;

import java.net.BindException;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 *
 * @author tanpt
 */
public class WebServers {

	////////////////////////////////////////////////////////////////////////////
	// for managing servers -->
	////
	protected Class serverClass_ = null;
	protected String info_ = null;
	protected QueuedThreadPool threadPool_ = null;
	// <-- for managing servers
	////////////////////////////////////////////////////////////////////////////

	private static final Logger LOGGER = Logger.getLogger(WebServers.class);
	
	protected Server server_;
	protected Config config_ = new Config();
	private final AtomicBoolean running_ = new AtomicBoolean(false);
	private Thread thread_ = null;

	public static class Config {

		public String name = "WebServers";
		public String host = "0.0.0.0";
		public int port = 19000;
		public int nconnectors = 1;
		public int nacceptors = 2;
		public int nselectors = 4;
		public int acceptQueueSize = 500;
		public int nminThreads = 100;
		public int nmaxThreads = nminThreads * 2;
		public int maxIdleTime = 5000;
		public int connMaxIdleTime = maxIdleTime;
		public int threadMaxIdleTime = maxIdleTime;

		@Override
		public Config clone() {
			Config ret = new Config();
			ret.host = this.host;
			ret.port = this.port;
			ret.nconnectors = this.nconnectors;
			ret.nacceptors = this.nacceptors;
			ret.nselectors = this.nselectors;
			ret.acceptQueueSize = this.acceptQueueSize;
			ret.nminThreads = this.nminThreads;
			ret.nmaxThreads = this.nmaxThreads;
			ret.maxIdleTime = this.maxIdleTime;
			ret.connMaxIdleTime = this.connMaxIdleTime;
			ret.threadMaxIdleTime = this.threadMaxIdleTime;
			return ret;
		}

		public boolean isValid() {
			return !host.isEmpty() && port > 0 && nconnectors > 0 && nacceptors > 0 && nselectors > 0 && acceptQueueSize > 0
					&& nminThreads > 0 && nmaxThreads >= nminThreads
					&& connMaxIdleTime > 0 && threadMaxIdleTime > 0;
			//maxIdleTime is just a default value for connMaxIdleTime and threadMaxIdleTime
		}
	}

	protected class ServerRunner implements Runnable {

		private final Server server_;
		private final AtomicBoolean running_;

		public ServerRunner(Server server, AtomicBoolean running) {
			assert (server != null && running != null);
			server_ = server;
			running_ = running;
		}

		@Override
		public void run() {
			LOGGER.info("Web server is going to serve");
			try {
				//_server.start();
				server_.join();
			} catch (Exception ex) {
				LOGGER.error(null, ex);
			}
			LOGGER.info("Web server stopped");
			running_.set(false);
		}
	}

	public WebServers(Config config) {
		config_ = config;
	}

	public final Server getServer() {
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

	public final QueuedThreadPool getThreadPool() {
		return threadPool_;
	}

	public final int getNWaitingJob() {
		return threadPool_.getQueueSize();
	}

	public final String getInfo() {
		return info_;
	}

	public boolean setup(Handler handlers) {
		if (server_ != null) {
			LOGGER.warn("Server was already setup, dont need to setup again");
			return true;
		}
		try {
			assert (config_.isValid());

			//===== setup threadPool =====
			threadPool_ = new QueuedThreadPool();
			threadPool_.setName(config_.name);
			threadPool_.setMinThreads(config_.nminThreads);
			threadPool_.setMaxThreads(config_.nmaxThreads);
			threadPool_.setIdleTimeout(config_.threadMaxIdleTime);

			//create server
			Server server = new Server(threadPool_);

			//===== setup connector[] =====
			StringBuilder portsBuilder = new StringBuilder(config_.nconnectors * 6);
			ServerConnector[] connectors = new ServerConnector[config_.nconnectors];
			for (int i = 0; i < config_.nconnectors; ++i) {
				ServerConnector connector1 = new ServerConnector(server, config_.nacceptors, config_.nselectors);
				connector1.setHost(config_.host);
				connector1.setPort(config_.port + i);
				connector1.setIdleTimeout(config_.connMaxIdleTime);
				connector1.setAcceptQueueSize(config_.acceptQueueSize);
				connectors[i] = connector1;
				//
				if (i != 0) {
					portsBuilder.append(",");
				}
				portsBuilder.append(config_.port + i);
			}
			server.setConnectors(connectors);
			String ports = portsBuilder.toString();

			//===== setup server =====
			server.setStopAtShutdown(true);
			if (handlers != null) {
				server.setHandler(handlers);
			}
			//almost done
			server_ = server;
			String hostAddr = InetAddress.getByName(config_.host).getHostAddress(); //may throw UnknownHostException
			LOGGER.info(String.format("Web server (%s) listens on %s:%s", config_.name, hostAddr, ports));

			//===== add info =====
			serverClass_ = server_.getClass();
			info_ = "host=" + hostAddr + ", port=" + ports
					+ ", " + threadPool_.getClass().getName()
					+ "{maxIdleTime=" + threadPool_.getIdleTimeout()
					+ "}, " + connectors[0].getClass().getName()
					+ "{acceptQueueSize=" + connectors[0].getAcceptQueueSize()
					+ ", nacceptors=" + config_.nacceptors
					+ ", nselectors=" + config_.nselectors
					+ ", maxIdleTime=" + connectors[0].getIdleTimeout()
					+ "}";
			return true;
		} catch (Exception ex) {
			LOGGER.error(null, ex);
			return false;
		}
	}

	public boolean start() {
		if (server_ == null) {
			return false;
		}
		if (!running_.compareAndSet(false, true)) {
			LOGGER.warn("Server is already running, dont need to start again");
			return true;
		}
		boolean result = false;
		try {
			server_.start(); //non-blocked here, de o day de neu co loi thi bat duoc exception
			thread_ = new Thread(new ServerRunner(server_, running_),
					config_.name);
			thread_.start();
			result = true;
		} catch (BindException ex) {
			LOGGER.error(null, ex);
			stop();
		} catch (Exception ex) {
			LOGGER.error(null, ex);
			stop();
		}
		return result;
	}

	public void stop() {
		if (server_ == null) {
			return;
		}
		if (running_.get()) {
			try {
				server_.stop();
				if (thread_ != null) {
					thread_.join();
					thread_ = null;
				} else {
					running_.set(false);
				}
			} catch (Exception ex) {
				LOGGER.error(null, ex);
			}
		}
	}

	public int join() {
		if (server_ == null) {
			return 0;
		}
		try {
			server_.join();
		} catch (InterruptedException ex) {
			return -1;
		}
		return 0;
	}

	public void destroy() {
		if (server_ == null) {
			return;
		}
		stop();
		server_.destroy();
		server_ = null;
	}
}
