package com.expensewise.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 

public class AppException  extends RuntimeException{
	
	private String message;
	private HttpStatus httpstatus;
	
	public HttpStatus gethttpstatus()
	{
		return httpstatus;
	}
	
	public AppException(String message, HttpStatus httpstatus) {
		super(message);
		this.httpstatus = httpstatus;
	}
	
	
	

}

	
