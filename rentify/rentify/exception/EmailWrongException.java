package com.jsp.rentify.exception;

import lombok.Data;

@Data
public class EmailWrongException extends RuntimeException{
	
	private String msg="email id not found";

	public EmailWrongException(String msg) {
		super();
		this.msg = msg;
	}

	public EmailWrongException() {
		super();
	}
}
