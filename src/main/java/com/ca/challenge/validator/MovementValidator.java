package com.ca.challenge.validator;

import org.springframework.stereotype.Component;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.model.Robot;

@Component
public class MovementValidator {
	
	public Boolean isValid(final ActionInterface action, final Robot robot){
		
		
		return true;
	}

}
