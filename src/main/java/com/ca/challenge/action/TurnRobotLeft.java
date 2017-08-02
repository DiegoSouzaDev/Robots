package com.ca.challenge.action;

import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class TurnRobotLeft implements ActionInterface {
	
	@Override
	public void executeAction(Robot robot) {
		
		final Direction curDirection = robot.getCoordinate().getDirection();
		final Direction newDirection;
		
		switch (curDirection) {
			case NORTH:
				newDirection = Direction.WEST;
				break;
			case WEST:
				newDirection = Direction.SOUTH;
				break;
			case SOUTH:
				newDirection = Direction.EAST;
				break;
			case EAST:
				newDirection = Direction.NORTH;
				break;
			default:
				newDirection = curDirection;
				break;
		}
		
		robot.getCoordinate().setDirection(newDirection);
	}
	
}
