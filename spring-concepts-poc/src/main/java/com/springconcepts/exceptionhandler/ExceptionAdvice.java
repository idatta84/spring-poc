package com.springconcepts.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="DataIntegrityViolationException")
	@ResponseBody
	public String dataIntegrityViolationException(final DataIntegrityViolationException exception,
			final HttpServletRequest request) {
				return "data integ error";

	}
	
	/*
	 * This will return only the custom message returned by the method in response body in text format
	 * 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	//@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="SomeException")
	@ResponseBody
	public ResponseEntity<Object> methodArgumentNotValidException(final Exception ex,
			final HttpServletRequest request) {
		
		logger.info("Inside methodArgumentNotValidException");
		return new ResponseEntity<>(
				ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="SomeException")
	@ResponseBody
	public void methodArgumentNotValidException(final MethodArgumentNotValidException ex,
			final HttpServletRequest request) {
		
		logger.info("Inside someException");
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="SomeException")
	@ResponseBody
	public void someException(final Exception ex,
			final HttpServletRequest request) {
		
		logger.info("Inside someException");
	}

}
