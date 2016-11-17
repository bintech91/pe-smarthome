/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.servers;

import com.bin.peshdataserver.common.transport.SerialCommPort;
import com.bin.peshdataserver.common.transport.TransportException;
import gnu.io.SerialPort;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class SerialServers {

	private static final Logger LOGGER = Logger.getLogger(SerialServers.class);

	private final AtomicBoolean running_ = new AtomicBoolean(false);

	private SerialCommPort serialPort_;

	protected Config config_ = null;

	public static class Config {

		public String appName;
		public String portName;
		public int baudRate;
		public int dataBits;
		public int stopBits;
		public int parity;
		public SerialServersHandler handler;

		@Override
		public Config clone() {
			Config ret = new Config();
			ret.appName = appName;
			ret.portName = portName;
			ret.baudRate = baudRate;
			ret.dataBits = dataBits;
			ret.stopBits = stopBits;
			ret.parity = parity;
			ret.handler = handler;
			return ret;
		}

		public boolean isValid() {
			if (appName.isEmpty()) {
				return false;
			}

			if (portName.isEmpty()) {
				return false;
			}

			if (baudRate <= 0) {
				return false;
			}

			if ((dataBits != SerialPort.DATABITS_5)
					&& (dataBits != SerialPort.DATABITS_6)
					&& (dataBits != SerialPort.DATABITS_7)
					&& (dataBits != SerialPort.DATABITS_8)) {
				return false;
			}

			if ((stopBits != SerialPort.STOPBITS_1)
					&& (stopBits != SerialPort.STOPBITS_1_5)
					&& (stopBits != SerialPort.STOPBITS_2)) {
				return false;
			}

			if ((parity != SerialPort.PARITY_EVEN)
					&& (parity != SerialPort.PARITY_MARK)
					&& (parity != SerialPort.PARITY_NONE)
					&& (parity != SerialPort.PARITY_ODD)
					&& (parity != SerialPort.PARITY_SPACE)) {
				return false;
			}

			if (handler == null) {
				return false;
			}
			return true;
		}
	}

	protected class ServerRunner implements Runnable {

		private final AtomicBoolean running_;

		public ServerRunner(SerialCommPort serialPort, AtomicBoolean running) {
			assert (serialPort != null && running != null);
			serialPort_ = serialPort;
			running_ = running;
		}

		@Override
		public void run() {
			LOGGER.info("SerialServers is going to serve");
			while (serialPort_.isOpen()) {
				config_.handler.process(serialPort_);
			}
			LOGGER.info("SerialServers stopped");
			running_.set(false);
		}
	}

	public SerialServers(Config config) {
		config_ = config;
	}

	public boolean setup() throws TransportException {
		assert (config_.isValid());

		serialPort_ = new SerialCommPort(config_.appName,
				config_.portName,
				config_.baudRate,
				config_.dataBits,
				config_.stopBits,
				config_.parity);

		serialPort_.open();
		return true;
	}

	public boolean start() throws TransportException {
		if (serialPort_ == null) {
			setup();
		}
		if (!running_.compareAndSet(false, true)) {
			LOGGER.warn("Server is already running, dont need to start again");
			return true;
		}

		Thread thread = new Thread(new SerialServers.ServerRunner(serialPort_, running_), "SerialServers");
		thread.start();
		return true;
	}

	public void stop() {
		if (serialPort_ == null) {
			return;
		}
		if (running_.get()) {
			serialPort_.close();
			serialPort_ = null;
		}
	}

}
