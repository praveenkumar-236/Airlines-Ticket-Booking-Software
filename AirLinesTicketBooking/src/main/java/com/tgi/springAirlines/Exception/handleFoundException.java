package com.tgi.springAirlines.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class handleFoundException extends RuntimeException {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public handleFoundException(String message) {
		super();
		this.message = message;
	}

}
