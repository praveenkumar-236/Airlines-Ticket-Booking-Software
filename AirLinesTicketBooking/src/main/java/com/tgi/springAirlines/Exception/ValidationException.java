package com.tgi.springAirlines.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class ValidationException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	  public ResponseEntity<Object> ResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		  response.put("Message",  ex.getMessage());
		  response.put("ErrorCode",HttpStatus.NOT_FOUND);
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@ExceptionHandler(value = { handleFoundException.class })
	  public ResponseEntity<Object> handleFoundException(handleFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		  response.put("Message",  ex.getMessage());
		  response.put("ErrorCode",HttpStatus.BAD_REQUEST);
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
