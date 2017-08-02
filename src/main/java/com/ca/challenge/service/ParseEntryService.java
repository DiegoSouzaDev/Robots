package com.ca.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.action.MoveRobotForward;
import com.ca.challenge.action.TurnRobotLeft;
import com.ca.challenge.action.TurnRobotRight;
import com.ca.challenge.exception.InvalidActionException;

@Service
public class ParseEntryService {

	public List<ActionInterface> parseParameter(final String parameters) {
		final List<ActionInterface> listOfActions = new ArrayList<ActionInterface>();
		for (final Character character : parameters.toCharArray()) {
			listOfActions.add(locateAction(character));
		}
		return listOfActions;
	}

	private ActionInterface locateAction(final Character parameterChar) {
		final ActionInterface action;

		switch (parameterChar) {
		case 'L':
			action = new TurnRobotLeft();
			break;
		case 'R':
			action = new TurnRobotRight();
			break;
		case 'M':
			action = new MoveRobotForward();
			break;
		default:
			 throw new InvalidActionException();
		}
		return action;
	}

}
