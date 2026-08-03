package com.expensewise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<String> handleEmailAlreadyExists(
			EmailAlreadyExistsException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
	}
}
