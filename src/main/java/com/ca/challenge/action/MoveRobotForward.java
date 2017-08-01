package com.ca.challenge.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;
import com.ca.challenge.service.MovementValidatorService;

public class MoveRobotForward implements ActionInterface {
	
	private MovementValidatorService movementValidatorService;

		
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
		Coordinate newCoord = new Coordinate();

		if (movementValidatorService.isValid(curCoord, posX, posY)) {
			newCoord = new Coordinate(curCoord.getPositionX() + posX, curCoord.getPositionY() + posY,
					curCoord.getDirection());
		}
		return newCoord;
	}
	
	@Autowired
	public void setMovementValidatorService(MovementValidatorService movementValidatorService){
		this.movementValidatorService = movementValidatorService;
	}

}
