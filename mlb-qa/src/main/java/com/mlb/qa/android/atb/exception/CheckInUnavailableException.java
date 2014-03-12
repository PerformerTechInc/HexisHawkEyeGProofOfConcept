package com.mlb.qa.android.atb.exception;

import com.mlb.qa.exception.TestRuntimeException;

public class CheckInUnavailableException extends TestRuntimeException {
	private static final long serialVersionUID = -7424237863625081777L;

	public CheckInUnavailableException(String message) {
		super(message);
	}

}
