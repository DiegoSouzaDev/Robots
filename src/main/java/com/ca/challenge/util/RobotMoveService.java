package com.ca.challenge.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.challenge.action.PossibleAction;
import com.ca.challenge.model.Robot;

@Service
public class RobotMoveService {

	ParseEntryService parseEntryService;
	
	@Autowired
	 public RobotMoveService(ParseEntryService parseEntryService) {
		this.parseEntryService = parseEntryService;	
	}
	
	public String move(final String params){
    	final Robot robot = new Robot("FirstOne");

    	final List<PossibleAction> actions = parseEntryService.parseParameter(params);
    	
    	for (PossibleAction action : actions) {
			action.executeAction(robot);
		}
		return robot.getCurrentPosition();
 
	}

}
