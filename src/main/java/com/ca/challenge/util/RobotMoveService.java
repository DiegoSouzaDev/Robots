package com.ca.challenge.util;

import java.util.List;

import com.ca.challenge.action.PossibleAction;
import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class RobotMoveService {
	
	public String move(final String params){
		
		Coordinate coordinate = new Coordinate(0, 0, Direction.NORTH);
    	Robot robot = new Robot("FirstOne", coordinate);
    	ParseEntry parseEntry = new ParseEntry();

    	final List<PossibleAction> actions = parseEntry.parseParameter(params);
    	
    	for (PossibleAction action : actions) {
			action.executeAction(robot);
		}
		return robot.getCurrentPosition();
 
	}

}
