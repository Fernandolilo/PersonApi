package com.systempro.service.exception;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	// sobre carga com uma outra excessão para uma causa do possivel erro.
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
