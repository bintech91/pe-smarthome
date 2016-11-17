/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class IOStreamTransport extends AbstractTransport {

	private static final Logger LOGGER = Logger.getLogger(IOStreamTransport.class);

	/**
	 * Underlying inputStream
	 */
	protected InputStream inputStream_ = null;

	/**
	 * Underlying outputStream
	 */
	protected OutputStream outputStream_ = null;

	/**
	 * Subclasses can invoke the default constructor and then assign the input
	 * streams in the open method.
	 */
	protected IOStreamTransport() {
	}

	/**
	 * Input stream constructor.
	 *
	 * @param is Input stream to read from
	 */
	public IOStreamTransport(InputStream is) {
		inputStream_ = is;
	}

	/**
	 * Output stream constructor.
	 *
	 * @param os Output stream to read from
	 */
	public IOStreamTransport(OutputStream os) {
		outputStream_ = os;
	}

	/**
	 * Two-way stream constructor.
	 *
	 * @param is Input stream to read from
	 * @param os Output stream to read from
	 */
	public IOStreamTransport(InputStream is, OutputStream os) {
		inputStream_ = is;
		outputStream_ = os;
	}

	/**
	 * The streams must already be open at construction time, so this should
	 * always return true.
	 *
	 * @return true
	 */
	@Override
	public boolean isOpen() {
		return true;
	}

	/**
	 * The streams must already be open. This method does nothing.
	 *
	 * @throws com.bin.peshdataserver.common.transport.TransportException
	 */
	@Override
	public void open() throws TransportException {
	}

	/**
	 * Closes both the input and output streams.
	 */
	@Override
	public void close() {
		if (inputStream_ != null) {
			try {
				inputStream_.close();
			} catch (IOException iox) {
				LOGGER.warn("Error closing input stream.", iox);
			}
			inputStream_ = null;
		}
		if (outputStream_ != null) {
			try {
				outputStream_.close();
			} catch (IOException iox) {
				LOGGER.warn("Error closing output stream.", iox);
			}
			outputStream_ = null;
		}
	}

	/**
	 * Reads from the underlying input stream if not null.
	 *
	 * @return number of bytes read
	 * @throws com.bin.peshdataserver.common.transport.TransportException
	 */
	@Override
	public int read(byte[] buf, int off, int len) throws TransportException {
		if (inputStream_ == null) {
			throw new TransportException(TransportException.NOT_OPEN, "Cannot read from null inputStream");
		}
		int bytesRead;
		try {
			bytesRead = inputStream_.read(buf, off, len);
		} catch (IOException iox) {
			throw new TransportException(TransportException.UNKNOWN, iox);
		}
		if (bytesRead < 0) {
			throw new TransportException(TransportException.END_OF_FILE);
		}
		return bytesRead;
	}

	/**
	 * Writes to the underlying output stream if not null.
	 *
	 * @throws com.bin.peshdataserver.common.transport.TransportException
	 */
	@Override
	public void write(byte[] buf, int off, int len) throws TransportException {
		if (outputStream_ == null) {
			throw new TransportException(TransportException.NOT_OPEN, "Cannot write to null outputStream");
		}
		try {
			outputStream_.write(buf, off, len);
		} catch (IOException iox) {
			throw new TransportException(TransportException.UNKNOWN, iox);
		}
	}

	/**
	 * Flushes the underlying output stream if not null.
	 *
	 * @throws com.bin.peshdataserver.common.transport.TransportException
	 */
	@Override
	public void flush() throws TransportException {
		if (outputStream_ == null) {
			throw new TransportException(TransportException.NOT_OPEN, "Cannot flush null outputStream");
		}
		try {
			outputStream_.flush();
		} catch (IOException iox) {
			throw new TransportException(TransportException.UNKNOWN, iox);
		}
	}
}
