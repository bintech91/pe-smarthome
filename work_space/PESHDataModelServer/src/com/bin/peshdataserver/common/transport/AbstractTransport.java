/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.transport;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author tanpt
 */
public abstract class AbstractTransport implements Closeable {

	/**
	 * Queries whether the transport is open.
	 *
	 * @return True if the transport is open.
	 */
	public abstract boolean isOpen();

	/**
	 * Is there more data to be read?
	 *
	 * @return True if the remote side is still alive and feeding us
	 */
	public boolean peek() {
		return isOpen();
	}

	/**
	 * Opens the transport for reading/writing.
	 *
	 * @throws TransportException if the transport could not be opened
	 */
	public abstract void open()
			throws TransportException;

	/**
	 * Closes the transport.
	 */
	public abstract void close();

	/**
	 * Reads up to len bytes into buffer buf, starting at offset off.
	 *
	 * @param buf Array to read into
	 * @param off Index to start reading at
	 * @param len Maximum number of bytes to read
	 * @return The number of bytes actually read
	 * @throws TransportException if there was an error reading data
	 */
	public abstract int read(byte[] buf, int off, int len)
			throws TransportException;

	/**
	 * Guarantees that all of len bytes are actually read off the transport.
	 *
	 * @param buf Array to read into
	 * @param off Index to start reading at
	 * @param len Maximum number of bytes to read
	 * @return The number of bytes actually read, which must be equal to len
	 * @throws TransportException if there was an error reading data
	 */
	public int readAll(byte[] buf, int off, int len)
			throws TransportException {
		int got = 0;
		int ret = 0;
		while (got < len) {
			ret = read(buf, off + got, len - got);
			if (ret <= 0) {
				throw new TransportException(
						"Cannot read. Remote side has closed. Tried to read "
						+ len
						+ " bytes, but only got "
						+ got
						+ " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
			}
			got += ret;
		}
		return got;
	}

	/**
	 * Writes the buffer to the output
	 *
	 * @param buf The output data buffer
	 * @throws TransportException if an error occurs writing data
	 */
	public void write(byte[] buf) throws TransportException {
		write(buf, 0, buf.length);
	}

	/**
	 * Writes up to len bytes from the buffer.
	 *
	 * @param buf The output data buffer
	 * @param off The offset to start writing from
	 * @param len The number of bytes to write
	 * @throws TransportException if there was an error writing data
	 */
	public abstract void write(byte[] buf, int off, int len)
			throws TransportException;

	/**
	 * Flush any pending data out of a transport buffer.
	 *
	 * @throws TransportException if there was an error writing out data.
	 */
	public void flush()
			throws TransportException {
	}

	/**
	 * Access the protocol's underlying buffer directly. If this is not a
	 * buffered transport, return null.
	 *
	 * @return protocol's Underlying buffer
	 */
	public byte[] getBuffer() {
		return null;
	}

	/**
	 * Return the index within the underlying buffer that specifies the next
	 * spot that should be read from.
	 *
	 * @return index within the underlying buffer that specifies the next spot
	 * that should be read from
	 */
	public int getBufferPosition() {
		return 0;
	}

	/**
	 * Get the number of bytes remaining in the underlying buffer. Returns -1 if
	 * this is a non-buffered transport.
	 *
	 * @return the number of bytes remaining in the underlying buffer. <br>
	 * Returns -1 if this is a non-buffered transport.
	 */
	public int getBytesRemainingInBuffer() {
		return -1;
	}

	/**
	 * Consume len bytes from the underlying buffer.
	 *
	 * @param len
	 */
	public void consumeBuffer(int len) {
	}

}
