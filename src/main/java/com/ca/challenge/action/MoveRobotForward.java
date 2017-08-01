package com.ca.challenge.action;

import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class MoveRobotForward implements ActionInterface {

	@Override
	public void executeAction(Robot robot) {
		final Coordinate newCoord = calculateNewCoordinate(robot);
		robot.setCoordinate(newCoord);
	}

	private Coordinate pointToAPosition(final Coordinate curCoord, final Integer posX, final Integer posY) {
		return new Coordinate(curCoord.getPositionX() + posX, curCoord.getPositionY() + posY, curCoord.getDirection());
	}

	public Coordinate calculateNewCoordinate(Robot robot) {
		final Coordinate curCoord = robot.getCoordinate();
		final Direction curDirection = curCoord.getDirection();

		final Coordinate newCoord;

		switch (curDirection) {
		case NORTH:
			newCoord = pointToAPosition(curCoord, 0, 1);
			break;
		case WEST:
			newCoord = pointToAPosition(curCoord, -1, 0);
			break;
		case SOUTH:
			newCoord = pointToAPosition(curCoord, 0, -1);
			break;
		case EAST:
			newCoord = pointToAPosition(curCoord, 1, 0);
			break;
		default:
			newCoord = curCoord;
			break;
		}
		return newCoord;
	}
}
