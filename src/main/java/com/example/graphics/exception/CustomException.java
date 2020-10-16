package com.example.graphics.exception;

import com.example.graphics.constants.ApplicationWarningCode;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public CustomException(ApplicationWarningCode exceptionCode) {
		this.message = exceptionCode.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}
}