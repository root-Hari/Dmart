package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	 @ExceptionHandler(IdNotFoundException.class)
	    public ResponseEntity<String> handleIdNotFound(IdNotFoundException ex) {
	        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

}
	 public ResponseEntity<String>handle(IdNotFound inf)
	 {
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(inf.getMessage());
	 }
}
