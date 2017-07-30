package com.ca.challenge.model;

import lombok.Data;

@Data
public class Robot {
	private String name;
	private Coordinate coordinate;
	
	public Robot(String name){
		this.name = name;
		this.coordinate = new Coordinate();
	}
	
	public String getCurrentPosition(){
		return coordinate.toString();
	}
}
