package com.example.usuario.api.exceptionahandler;

public class DataIntegratedViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegratedViolationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DataIntegratedViolationException(String message) {
		super(message);
	}

}
