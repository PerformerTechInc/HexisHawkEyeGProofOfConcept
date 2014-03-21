package com.mlb.qa.exception;

/**
 * Base test exception
 */
public class TestRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -2426526034452686671L;

	public TestRuntimeException() {
		super();
	}

	public TestRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TestRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestRuntimeException(String message) {
		super(message);
	}

	public TestRuntimeException(Throwable cause) {
		super(cause);
	}

}