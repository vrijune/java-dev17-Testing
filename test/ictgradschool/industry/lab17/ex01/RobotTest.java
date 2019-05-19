package ictgradschool.industry.lab17.ex01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RobotTest {

    private Robot myRobot;

    @Before
    public void setUp() {
        myRobot = new Robot();
    }

    @Test
    public void testRobotConstruction() {
        assertEquals(Robot.Direction.North, myRobot.getDirection());
        assertEquals(10, myRobot.row());
        assertEquals(1, myRobot.column());
    }

    @Test
    public void testIllegalMoveNorth() {
        boolean atTop = false;
        try {
            // Move the robot to the top row.
            for (int i = 0; i < Robot.GRID_SIZE - 1; i++)
                myRobot.move();

            // Check that robot has reached the top.
            atTop = myRobot.currentState().row == 1;
            assertTrue(atTop);
        } catch (IllegalMoveException e) {
            fail();
        }

        try {
            // Now try to continue to move North.
            myRobot.move();
            fail();
        } catch (IllegalMoveException e) {
            // Ensure the move didn’t change the robot state
            assertEquals(1, myRobot.currentState().row);
        }
    }
}
