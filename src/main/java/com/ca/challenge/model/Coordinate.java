package com.ca.challenge.model;

import lombok.Data;

@Data
public class Coordinate {
	private Integer positionX;
	private Integer positionY;
	private Direction direction;

	public Coordinate(final Integer posX, final Integer posY, final Direction direction){
		this.positionX = posX;
		this.positionY = posY;
		this.direction = direction;
	}
	
	private void rotate(){
		
	}
	
	
}
