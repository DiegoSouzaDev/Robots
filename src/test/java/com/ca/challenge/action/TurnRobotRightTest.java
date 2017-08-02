package com.ca.challenge.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class TurnRobotRightTest {

	
	private TurnRobotRight turnRobotRight;
	
	@Before
	public void initialize(){
		turnRobotRight = new TurnRobotRight();
	}
	
	@Test
	public void turnRightFromNorth(){
		final Robot robot = createRobot(Direction.NORTH);
		turnRobotRight.executeAction(robot);
		Assert.assertEquals(Direction.EAST, robot.getCoordinate().getDirection());
	}
	
	@Test
	public void turnRightFromEast(){
		final Robot robot = createRobot(Direction.EAST);
		turnRobotRight.executeAction(robot);
		Assert.assertEquals(Direction.SOUTH, robot.getCoordinate().getDirection());
	}

	@Test
	public void turnRightFromSouth(){
		final Robot robot = createRobot(Direction.SOUTH);
		turnRobotRight.executeAction(robot);
		Assert.assertEquals(Direction.WEST, robot.getCoordinate().getDirection());
	}

	
	@Test
	public void turnRightFromWest(){
		final Robot robot = createRobot(Direction.WEST);
		turnRobotRight.executeAction(robot);
		Assert.assertEquals(Direction.NORTH, robot.getCoordinate().getDirection());
	}
	
	
	@Test
	public void isValidToTurnRight(){
		final Robot robot = new Robot();
		Assert.assertTrue(turnRobotRight.isValid(robot));
	}
	
	private Robot createRobot(final Direction direction) {
		final Robot robot = new Robot();
		robot.getCoordinate().setDirection(direction);
		return robot;
	}

}
