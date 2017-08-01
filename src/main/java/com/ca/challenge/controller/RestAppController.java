package com.ca.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ca.challenge.service.RobotMoveService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/rest/mars")
public class RestAppController {

	private final RobotMoveService robotMoveService;

	@Autowired
	public RestAppController(RobotMoveService robotMoveService) {
		this.robotMoveService = robotMoveService;
	}

	@RequestMapping(value = "/move/{params}", method = RequestMethod.POST)
	public String move(@PathVariable String params) {
		return robotMoveService.move(params);
	}

	@RequestMapping("/Hi")
	public String home() {
		return "Hello World!";
	}

}