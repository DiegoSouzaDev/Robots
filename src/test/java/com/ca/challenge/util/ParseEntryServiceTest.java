package com.ca.challenge.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ca.challenge.action.PossibleAction;
import com.ca.challenge.model.Robot;

public class ParseEntryServiceTest {
	@Test
	public void parseParameterTest(){
		Robot robot = new Robot("First");
		ParseEntryService parseEntry = new ParseEntryService();
		
		List<PossibleAction> ret = parseEntry.parseParameter("MMRMMRMM");		
		
		for (PossibleAction possibleAction : ret) {
			possibleAction.executeAction(robot);
		}
		Assert.assertEquals("(2,0,S)", robot.getCoordinate().toString());
	}
}
