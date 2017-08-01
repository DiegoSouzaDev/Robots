package com.ca.challenge.model;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class MarcianTerrain {
	private Integer minPositionX;
	private Integer maxPositionX;
	private Integer minPositionY;
	private Integer maxPositionY;
	
	public MarcianTerrain(){
		minPositionX = 0;
		minPositionY = 0;
		maxPositionX = 5;
		maxPositionY = 5;
	}

}
