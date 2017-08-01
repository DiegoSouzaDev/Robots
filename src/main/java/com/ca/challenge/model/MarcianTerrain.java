package com.ca.challenge.model;

import lombok.Getter;

@Getter
public class MarcianTerrain {
	private Integer maxPositionX;
	private Integer maxPositionY;
	
	public MarcianTerrain(){
		maxPositionX = 5;
		maxPositionY = 5;
	}

}
