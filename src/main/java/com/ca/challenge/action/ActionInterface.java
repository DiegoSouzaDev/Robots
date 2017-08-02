package com.ca.challenge.action;

import com.ca.challenge.model.Robot;

public interface ActionInterface {
	
	default Boolean isValid(final Robot robot) {
		return Boolean.TRUE;
	}
	
	void executeAction(final Robot robot);
}