package com.ca.challenge.action;

import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.Direction;
import com.ca.challenge.model.MarcianTerrain;
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
	
	@Override
	public Boolean isValid(final Robot robot) {
		final Coordinate simulatedCoord = calculateNewCoordinate(robot);
		final MarcianTerrain marcianTerrain = new MarcianTerrain();
		
		return isValidMovementInAxisX(simulatedCoord, marcianTerrain) && isValidMovementInAxisY(simulatedCoord, marcianTerrain);
		
	}
	
	private Boolean isValidMovementInAxisX(final Coordinate simulatedCoord, final MarcianTerrain marcianTerrain) {
		return simulatedCoord.getPositionX() >= 0 && simulatedCoord.getPositionX() <= marcianTerrain.getMaxPositionX();
	}
	
	private Boolean isValidMovementInAxisY(final Coordinate simulatedCoord, final MarcianTerrain marcianTerrain) {
		return simulatedCoord.getPositionY() >= 0 && simulatedCoord.getPositionY() <= marcianTerrain.getMaxPositionY();
	}
}
