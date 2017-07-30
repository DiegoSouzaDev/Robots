package com.ca.challenge.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ca.challenge.action.InvalidAction;
import com.ca.challenge.action.MoveRobotForward;
import com.ca.challenge.action.PossibleAction;
import com.ca.challenge.action.TurnRobotLeft;
import com.ca.challenge.action.TurnRobotRight;

@Service
public class ParseEntryService {
	
	public List<PossibleAction> parseParameter(final String parameters){
		final List<PossibleAction> listOfActions = new ArrayList<PossibleAction>();
		for (int i=0; i < parameters.length(); i++) {
			listOfActions.add(locateAction(parameters.charAt(i)));
		}
		return listOfActions;
		
	}

	private PossibleAction locateAction(Character parameterChar){
		final PossibleAction action;
		
		switch (parameterChar){
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
			action = new InvalidAction();
		}
		
		return action;
	}
	
}