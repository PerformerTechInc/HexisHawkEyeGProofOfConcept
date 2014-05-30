package com.mlb.qa.common.utils.marshaller.exception;

public class ParserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2740305459532726278L;

	public ParserException(String message) {
		super(message);
	}

	public ParserException(String message, Throwable e) {
		super(message, e);
	}

}
