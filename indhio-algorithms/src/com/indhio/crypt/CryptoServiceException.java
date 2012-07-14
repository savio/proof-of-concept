package com.indhio.crypt;

public class CryptoServiceException extends Exception {
	private static final long serialVersionUID = 3256718477053210674L;

	public CryptoServiceException() {
		super();
	}

	public CryptoServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CryptoServiceException(String arg0) {
		super(arg0);
	}

	public CryptoServiceException(Throwable arg0) {
		super(arg0);
	}
}
