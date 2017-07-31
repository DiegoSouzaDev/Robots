package com.ca.challenge.action;

import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class TurnRobotRight implements ActionInterface{

	@Override
	public void executeAction(Robot robot) {

		final Direction curDirection = robot.getCoordinate().getDirection();
		final Direction newDirection;
		
		switch (curDirection) {
		case NORTH:
			newDirection = Direction.EAST;
			break;
		case EAST:
			newDirection = Direction.SOUTH;
			break;
		case SOUTH:
			newDirection = Direction.WEST;
			break;
		case WEST:
			newDirection = Direction.NORTH;
			break;
		default:
			newDirection = curDirection;
			break;
		}

		robot.getCoordinate().setDirection(newDirection);
	}

}
