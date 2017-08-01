package com.ca.challenge.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ca.challenge.action.ActionInterface;
import com.ca.challenge.model.Robot;

public class ParseEntryServiceTest {
	@Test
	public void parseParameterTest(){
		Robot robot = new Robot();
		ParseEntryService parseEntry = new ParseEntryService();
		
		List<ActionInterface> ret = parseEntry.parseParameter("MMRMMRMM");		
		
		for (ActionInterface possibleAction : ret) {
			possibleAction.executeAction(robot);
		}
		Assert.assertEquals("(2,0,S)", robot.getCoordinate().toString());
	}
}
