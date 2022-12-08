package com.lcwd.store.exceptions;

public class BadRequestException extends RuntimeException {
	
	public BadRequestException() {
		super("bad request exception");
	}

	public BadRequestException(String message) {
		super(message);
	}
}
