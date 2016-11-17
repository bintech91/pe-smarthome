/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.transport;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class SerialCommPort extends IOStreamTransport {

	private static final Logger LOGGER = Logger.getLogger(SerialCommPort.class);

	private String appName_ = "";
	private String portName_ = "";
	private int baudRate_ = 0;
	private int dataBits_ = 0;
	private int stopBits_ = 0;
	private int parity_ = 0;
	private CommPortIdentifier commPortIdentifier_ = null;
	private SerialPort serialPort_ = null;

	public SerialCommPort(String appName, String portName, int baudRate, int dataBits, int stopBits, int parity) throws TransportException {
		appName_ = appName;
		portName_ = portName;
		baudRate_ = baudRate;
		dataBits_ = dataBits;
		stopBits_ = stopBits;
		parity_ = parity;
		initPort();
	}

	private void initPort() throws TransportException {
		try {
			commPortIdentifier_ = CommPortIdentifier.getPortIdentifier(portName_);
			if (commPortIdentifier_.isCurrentlyOwned()) {
				LOGGER.error("SerialCommPort::" + portName_ + " is currently in used.");
				throw new TransportException(TransportException.ALREADY_OPEN, "SerialCommPort::" + portName_ + " is currently in used.");
			}

			serialPort_ = (SerialPort) commPortIdentifier_.open(appName_, 2000);

		} catch (NoSuchPortException ex) {
			LOGGER.error("Could not find the port: " + portName_);
			throw new TransportException(TransportException.NOT_OPEN, ex);
		} catch (PortInUseException ex) {
			LOGGER.error("SerialCommPort::" + portName_ + " is currently in used.");
			throw new TransportException(TransportException.NOT_OPEN, ex);
		}
	}

	@Override
	public boolean isOpen() {
		return !((commPortIdentifier_ == null) || (serialPort_ == null));
	}

	@Override
	public void open() throws TransportException {

		if (isOpen()) {
			throw new TransportException(TransportException.ALREADY_OPEN, "SerialCommPort already opened.");
		}

		if (commPortIdentifier_ == null) {
			initPort();
		}

		try {
			serialPort_.setSerialPortParams(baudRate_, dataBits_, stopBits_, parity_);
			inputStream_ = new BufferedInputStream(serialPort_.getInputStream(), 1024);
			outputStream_ = new BufferedOutputStream(serialPort_.getOutputStream(), 1024);
		} catch (IOException | UnsupportedCommOperationException ex) {
			close();
			throw new TransportException(TransportException.NOT_OPEN, ex);
		}
	}

	@Override
	public void close() {
		super.close();

		// Close the socket
		if (serialPort_ != null) {
			serialPort_.close();
			serialPort_ = null;
		}

		if (commPortIdentifier_ != null) {
			commPortIdentifier_ = null;
		}
	}
}
