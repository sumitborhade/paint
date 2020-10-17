package com.cs.paint.exception;

/**
 * Single Responsibility purpose: Change when Custom Exception behavior needs changes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public CustomException(ApplicationExceptionCode applicationWarningCode) {
		this.message = applicationWarningCode.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}
}