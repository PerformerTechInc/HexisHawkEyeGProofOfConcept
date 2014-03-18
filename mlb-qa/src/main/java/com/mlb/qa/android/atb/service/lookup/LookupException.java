package com.mlb.qa.android.atb.service.lookup;

import org.testng.TestException;

public class LookupException extends TestException {

	private static final long serialVersionUID = -7485153751259633148L;

	public LookupException(String s) {
		super(s);
	}

	public LookupException(String message, Throwable t) {
		super(message, t);
	}
}
