package com.jsp.rentify.exception;

import lombok.Data;

@Data
public class PasswordWrongException extends RuntimeException{
	
	private String msg="password id not found";

	public PasswordWrongException(String msg) {
		super();
		this.msg = msg;
	}

	public PasswordWrongException() {
		super();
	}
}
