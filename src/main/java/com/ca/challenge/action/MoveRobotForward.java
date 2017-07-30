package com.ca.challenge.action;

import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class MoveRobotForward implements PossibleAction {

	@Override
	public void executeAction(Robot robot) {
		final Coordinate curCoord = robot.getCoordinate();
		final Direction curDirection = curCoord.getDirection();

		final Coordinate newCoord;

		switch (curDirection) {
		case NORTH:
			newCoord = changeposition(curCoord, 0, 1);
			break;
		case WEST:
			newCoord = changeposition(curCoord, -1, 0);
			break;
		case SOUTH:
			newCoord = changeposition(curCoord, 0, -1);
			break;
		case EAST:
			newCoord = changeposition(curCoord, 1, 0);
			break;
		default:
			newCoord = curCoord;
			break;
		}
		robot.setCoordinate(newCoord);
	}

	private Coordinate changeposition(final Coordinate curCoord, final Integer posX, final Integer posY) {
		return new Coordinate(curCoord.getPositionX() + posX, curCoord.getPositionY() + posY, curCoord.getDirection());
	}

}
