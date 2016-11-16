/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common;

import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import org.apache.thrift.server.TServer;

/**
 *
 * @author tanpt
 */
public class UARTServers {

	private static final Logger _Log = Logger.getLogger(UARTServers.class);

	public static class Config {

		public String portName;
		public int baudRate;
		public int dataBits;
		public int stopBits;
		public int parity;

		public Config() {

		}

	}

	protected class ServerRunner implements Runnable {

		private final AtomicBoolean _running;

		public ServerRunner(TServer server, AtomicBoolean running) {
			assert (server != null && running != null);
			_server = server;
			_running = running;
		}

		@Override
		public void run() {
			_Log.info("UARTServer is going to serve");
			try {
				_server.serve();
			} catch (Exception ex) {
				_Log.error(null, ex);
			}
			_Log.info("UARTServers stopped");
			_running.set(false);
		}
	}

	public UARTServers() {

	}

}
