package com.ca.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.model.Robot;

@Service
public class RobotMoveService {

	private final ParseEntryService parseEntryService;
	private final MovementValidatorService movementValidatorService;

	@Autowired
	public RobotMoveService(ParseEntryService parseEntryService, MovementValidatorService movementValidatorService) {
		this.parseEntryService = parseEntryService;
		this.movementValidatorService = movementValidatorService;
	}

	public String move(final String params) {
		final Robot robot = new Robot();
		final List<ActionInterface> actions = parseEntryService.parseParameter(params);

		for (ActionInterface action : actions) {
			if (movementValidatorService.isValid(robot, action)) {
				action.executeAction(robot);
			} else {
				//TODO:throw exception here
			}
		}
		return robot.getCurrentPosition();

	}
}