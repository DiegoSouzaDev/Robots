package com.ca.challenge.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ca.challenge.model.Coordinate;
import com.ca.challenge.model.Direction;
import com.ca.challenge.model.Robot;

public class MoveRobotForwardTest {
	
	private MoveRobotForward moveRobotForward;
	
	@Before
	public void initialize() {
		moveRobotForward = new MoveRobotForward();
	}
	
	@Test
	public void calculateMoveNorthCoordinate() {
		final Robot robot = createRobot(Direction.NORTH);
		final Coordinate coord = moveRobotForward.calculateNewCoordinate(robot);
		robot.setCoordinate(coord);
		Assert.assertEquals("(3,4,N)", robot.getCurrentPosition());
	}
	
	@Test
	public void calculateMoveWestCoordinate() {
		final Robot robot = createRobot(Direction.WEST);
		final Coordinate coord = moveRobotForward.calculateNewCoordinate(robot);
		robot.setCoordinate(coord);
		Assert.assertEquals("(2,3,W)", robot.getCurrentPosition());
	}
	
	@Test
	public void calculateMoveSouthCoordinate() {
		final Robot robot = createRobot(Direction.SOUTH);
		final Coordinate coord = moveRobotForward.calculateNewCoordinate(robot);
		robot.setCoordinate(coord);
		Assert.assertEquals("(3,2,S)", robot.getCurrentPosition());
	}
	
	@Test
	public void calculateMoveEastCoordinate() {
		final Robot robot = createRobot(Direction.EAST);
		final Coordinate coord = moveRobotForward.calculateNewCoordinate(robot);
		robot.setCoordinate(coord);
		Assert.assertEquals("(4,3,E)", robot.getCurrentPosition());
	}
	
	@Test
	public void isValidToMove() {
		final Robot validRobot = new Robot();
		validRobot.setCoordinate(new Coordinate(0, 0, Direction.NORTH));
		Assert.assertTrue(moveRobotForward.isValid(validRobot));
	}
	
	@Test
	public void isInvalidToMove() {
		final Robot invalidRobot = new Robot();
		invalidRobot.setCoordinate(new Coordinate(0, 0, Direction.SOUTH));
		Assert.assertFalse(moveRobotForward.isValid(invalidRobot));
	}
	
	private Robot createRobot(final Direction direction) {
		final Robot robot = new Robot();
		robot.setCoordinate(new Coordinate(3, 3, direction));
		return robot;
	}
	
}
