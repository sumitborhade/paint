package com.example.graphics.exception;

import com.example.graphics.constants.ExceptionCode;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public CustomException(ExceptionCode exceptionCode) {
		this.message = exceptionCode.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}
}