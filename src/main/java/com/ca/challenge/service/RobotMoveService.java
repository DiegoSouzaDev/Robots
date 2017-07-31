package com.ca.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.model.Robot;
import com.ca.challenge.validator.MovementValidator;

@Service
public class RobotMoveService {

	private final ParseEntryService parseEntryService;
	private final MovementValidator movementValidatorService;
	
	@Autowired
	 public RobotMoveService(ParseEntryService parseEntryService, MovementValidator movementValidatorService) {
		this.parseEntryService = parseEntryService;	
		this.movementValidatorService = movementValidatorService;
	}
	
	public String move(final String params){
    	final Robot robot = new Robot();
    	final List<ActionInterface> actions = parseEntryService.parseParameter(params);
    	
    	for (ActionInterface action : actions) {
    		if(movementValidatorService.isValid(action, robot)){
    			action.executeAction(robot);
    			
    		}
		}
		return robot.getCurrentPosition();
 
	}

}
