package com.ca.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
	private Coordinate coordinate;
	
	public Robot() {
		this.coordinate = new Coordinate();
	}
	
	public String getCurrentPosition() {
		return coordinate.toString();
	}
}
