package com.ca.challenge.model;

import lombok.Data;

@Data
public class Robot {
	private String name;
	private Coordinate coordinate;
	
	public Robot(String name, Coordinate coordinate){
		this.name = name;
		this.coordinate = coordinate;
	}
}
