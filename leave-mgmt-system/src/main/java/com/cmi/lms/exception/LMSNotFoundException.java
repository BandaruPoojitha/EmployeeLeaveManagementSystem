package com.cmi.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LMSNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LMSNotFoundException(String exception) {
		super(exception);
	}
}
