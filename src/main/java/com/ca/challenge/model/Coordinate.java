package com.ca.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinate {
	private Integer positionX;
	private Integer positionY;
	private Direction direction;
	
	public Coordinate() {
		setInitialCoordinate();
	}
	
	public Coordinate(final Integer posX, final Integer posY, final Direction direction) {
		this.positionX = posX;
		this.positionY = posY;
		this.direction = direction;
	}
	
	private void setInitialCoordinate() {
		positionX = 0;
		positionY = 0;
		direction = Direction.NORTH;
	}
	
	public String toString() {
		final StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("(").append(positionX).append(",").append(positionY).append(",").append(direction.getValue()).append(")");
		return strBuilder.toString();
	}
	
}
