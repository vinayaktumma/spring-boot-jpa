package com.moviereviewsite.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	/*
	 * @ExceptionHandler(ResourceNotFoundException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.NOT_FOUND) public @ResponseBody
	 * ExceptionResponse handleResourceNotFound(final ResourceNotFoundException
	 * exception, final HttpServletRequest request) {
	 * 
	 * ExceptionResponse error = new ExceptionResponse(); error.setResult("error");
	 * error.setMessage(exception.getMessage());
	 * 
	 * return error; }
	 */
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setResult("error");
		error.setMessage(exception.getMessage());

		return error;
	}

}
