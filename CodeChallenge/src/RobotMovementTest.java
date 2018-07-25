import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
// Unit Testing for functions
public class RobotMovementTest {
	private RobotMovement rm;

	@Before
	public void intialiseRmClass() {
		rm = new RobotMovement();
		
	}
	
	@Test
	public void testRobotPlaced() {
		rm.placeRobot(0, 0, "NORTH");
		assertTrue(rm.robotPlaced==true);
	}
	@Test
	public void testRobotPlaced2() {
		rm.placeRobot(5, 5, "NORTH");
		assertTrue(rm.robotPlaced == false );
	}
	
	@Test
	public void testMoveRobot() {
		rm.placeRobot(0, 0, "NORTH");
		rm.moveRobot();
		assertTrue(rm.yValue == 1);
	}
	
	@Test
	public void testTurnRobotRight() {
		rm.placeRobot(0, 0, "NORTH");
		rm.turnRobot("RIGHT");
		assertTrue(rm.direction == 1);
	}
	
	@Test
	public void testTurnRobotLEFT() {
		rm.placeRobot(0, 0, "NORTH");
		rm.turnRobot("LEFT");
		assertTrue(rm.direction == 3);
	}


}
