/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.common.transport;

/**
 *
 * @author tanpt
 */
public class TransportException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final int UNKNOWN = 0;
	public static final int NOT_OPEN = 1;
	public static final int ALREADY_OPEN = 2;
	public static final int TIMED_OUT = 3;
	public static final int END_OF_FILE = 4;

	protected int type_ = UNKNOWN;

	public TransportException() {
		super();
	}

	public TransportException(int type) {
		super();
		type_ = type;
	}

	public TransportException(int type, String message) {
		super(message);
		type_ = type;
	}

	public TransportException(String message) {
		super(message);
	}

	public TransportException(int type, Throwable cause) {
		super(cause);
		type_ = type;
	}

	public TransportException(Throwable cause) {
		super(cause);
	}

	public TransportException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransportException(int type, String message, Throwable cause) {
		super(message, cause);
		type_ = type;
	}

	public int getType() {
		return type_;
	}

}
