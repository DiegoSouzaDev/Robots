package com.ca.challenge.model;

import lombok.Getter;

public enum Direction {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	@Getter
	public String value;
	
	Direction(String value) {
		this.value = value;
	}
	
}
