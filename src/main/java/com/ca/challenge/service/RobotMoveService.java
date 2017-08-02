package com.ca.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.exception.InvalidMoveException;
import com.ca.challenge.model.Robot;

@Service
public class RobotMoveService {

	private final ParseEntryService parseEntryService;

	@Autowired
	public RobotMoveService(ParseEntryService parseEntryService) {
		this.parseEntryService = parseEntryService;
	}

	public String move(final String params) {
		final Robot robot = new Robot();
		final List<ActionInterface> actions = parseEntryService.parseParameter(params);

		for (ActionInterface action : actions) {
			if (action.isValid(robot)) {
				action.executeAction(robot);
			} else {
				throw new InvalidMoveException();
			}
		}
		return robot.getCurrentPosition();

	}
}