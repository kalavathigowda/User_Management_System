package com.jsp.ums.exception;

public class UserNotFoundByIdException extends RuntimeException {
	private String Message;

	public  UserNotFoundByIdException(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}
	
	
}
