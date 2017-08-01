package com.ca.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.action.MoveRobotForward;
import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.MarcianTerrain;
import com.ca.challenge.model.Robot;

@Service
public class MovementValidatorService {

	private final MarcianTerrain marcianTerrain;

	@Autowired
	public MovementValidatorService(final MarcianTerrain marcianTerrain) {
		this.marcianTerrain = marcianTerrain;
	}

	public Boolean isValid(final Robot robot, final ActionInterface action) {
		final Boolean currentValidation;

		if (action instanceof MoveRobotForward) {
			final Coordinate simulatedCoord = ((MoveRobotForward) action).calculateNewCoordinate(robot);
			currentValidation = isValidMovementInAxisX(simulatedCoord) && isValidMovementInAxisY(simulatedCoord);

		} else {
			currentValidation = true;
		}
		return currentValidation;
	}

	private Boolean isValidMovementInAxisX(final Coordinate simulatedCoord) {
		return simulatedCoord.getPositionX() >= marcianTerrain.getMinPositionX()
				&& simulatedCoord.getPositionX() <= marcianTerrain.getMaxPositionX();
	}

	private Boolean isValidMovementInAxisY(final Coordinate simulatedCoord) {
		return simulatedCoord.getPositionY() >= marcianTerrain.getMinPositionY()
				&& simulatedCoord.getPositionY() <= marcianTerrain.getMaxPositionY();
	}

}