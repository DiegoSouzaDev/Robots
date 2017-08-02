package com.ca.challenge.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ca.challenge.exception.InvalidActionException;
import com.ca.challenge.exception.InvalidMoveException;

@ControllerAdvice
@RestController
public class RequestExceptionHandler {
	
	@ExceptionHandler(InvalidActionException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String invalidActionHandle(InvalidActionException e) {
		return "400 Bad Request: Invalid Action Instruction";
		
	}
	
	@ExceptionHandler(InvalidMoveException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String invalidMovementException(InvalidMoveException e) {
		return "400 Bad Request: Invalid Movement";
		
	}
	
}
