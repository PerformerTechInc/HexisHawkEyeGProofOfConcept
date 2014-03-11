package com.mlb.qa.exception;

/**
 * Base test exception
 */
public class CommonTestRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -2426526034452686671L;

	public CommonTestRuntimeException() {
		super();
	}

	public CommonTestRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommonTestRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonTestRuntimeException(String message) {
		super(message);
	}

	public CommonTestRuntimeException(Throwable cause) {
		super(cause);
	}

}
