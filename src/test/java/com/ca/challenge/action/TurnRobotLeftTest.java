package com.ca.challenge.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class TurnRobotLeftTest {

	
	private TurnRobotLeft turnRobotLeft;
	
	@Before
	public void initialize(){
		turnRobotLeft = new TurnRobotLeft();
	}
	
	@Test
	public void turnLeftFromNorth(){
		final Robot robot = createRobot(Direction.NORTH);
		turnRobotLeft.executeAction(robot);
		Assert.assertEquals(Direction.WEST, robot.getCoordinate().getDirection());
	}
	
	@Test
	public void turnLeftFromWest(){
		final Robot robot = createRobot(Direction.WEST);
		turnRobotLeft.executeAction(robot);
		Assert.assertEquals(Direction.SOUTH, robot.getCoordinate().getDirection());
	}
	
	@Test
	public void turnLeftFromSouth(){
		final Robot robot = createRobot(Direction.SOUTH);
		turnRobotLeft.executeAction(robot);
		Assert.assertEquals(Direction.EAST, robot.getCoordinate().getDirection());
	}
	
	@Test
	public void turnLeftFromEast(){
		final Robot robot = createRobot(Direction.EAST);
		turnRobotLeft.executeAction(robot);
		Assert.assertEquals(Direction.NORTH, robot.getCoordinate().getDirection());
	}
	
	@Test
	public void isValidToTurnLeft(){
		final Robot robot = new Robot();
		Assert.assertTrue(turnRobotLeft.isValid(robot));
	}
	
	private Robot createRobot(final Direction direction) {
		final Robot robot = new Robot();
		robot.getCoordinate().setDirection(direction);
		return robot;
	}
}
