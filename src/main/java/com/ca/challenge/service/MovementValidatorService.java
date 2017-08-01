package com.ca.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.MarcianTerrain;

@Service
public class MovementValidatorService {

	private MarcianTerrain marcianTerrain;

	@Autowired
	public MovementValidatorService(MarcianTerrain marcianTerrain) {
		this.marcianTerrain = marcianTerrain;
	}

	public Boolean isValid(final Coordinate robotCoord, final Integer posX, final Integer posY) {
//		 return Boolean.TRUE;
		return isValidMovementInAxisX(robotCoord, posX) && isValidMovementInAxisY(robotCoord, posY);
	}

	private Boolean isValidMovementInAxisX(final Coordinate robotCoord, final Integer posX) {
		return robotCoord.getPositionX() + posX >= marcianTerrain.getMinPositionX()
				&& robotCoord.getPositionX() + posX <= marcianTerrain.getMaxPositionX();
	}

	private Boolean isValidMovementInAxisY(final Coordinate robotCoord, final Integer posY) {
		return robotCoord.getPositionY() + posY >= marcianTerrain.getMinPositionY()
				&& robotCoord.getPositionY() + posY <= marcianTerrain.getMaxPositionY();
	}

}
