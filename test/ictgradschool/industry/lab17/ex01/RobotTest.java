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
        boolean atTop;
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


    @Test
    public void testTurn() {
        boolean isTurn;

        try {

            for (int i = 0; i < Robot.GRID_SIZE - 1; i++)
                myRobot.turn();
            // Check that robot has turn.
            isTurn = myRobot.currentState().direction == Robot.Direction.East;

            assertTrue(isTurn);

        } catch (IllegalStateException e) {
            fail();
        }
        // Now try to continue to move South.
        try {
            myRobot.turn();
            isTurn = myRobot.currentState().direction == Robot.Direction.South;
            assertTrue(isTurn);
        } catch (IllegalStateException e) {
//            assertEquals(Robot.Direction.South, myRobot.currentState().direction);
            fail();
        }
        try {
            myRobot.turn();
            isTurn = myRobot.getDirection() == Robot.Direction.West;
            assertTrue(isTurn);
        } catch (IllegalStateException e) {
//            assertEquals(Robot.Direction.West, myRobot.currentState().direction);
            fail();
        }

        try {
            myRobot.turn();
            isTurn = myRobot.getDirection() == Robot.Direction.North;
            assertTrue(isTurn);
        } catch (IllegalStateException e) {
//            assertEquals(Robot.Direction.North, myRobot.currentState().direction);
            fail();
        }

    }

@Test
    public void testMove(){
    boolean atMove;
    boolean isTurn;
    try {
        // Move the robot to the top row.
        for (int i = 0; i < Robot.GRID_SIZE - 1; i++)
            myRobot.move();
        // Check that robot has reached the top.
        atMove = myRobot.currentState().row == 1;
        assertTrue(atMove);
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

    try {
        // Now try to continue to turn east
        myRobot.turn();
        isTurn = myRobot.currentState().direction == Robot.Direction.East;

        assertTrue(isTurn);

    } catch (IllegalStateException e) {
        fail();
    }

    try {
        // Now try to continue to move East.
        myRobot.move();
        assertEquals(2, myRobot.currentState().column);
    } catch (IllegalMoveException e) {
        // Ensure the move didn’t change the robot state
      fail();
    }

    try {
        // Now try to continue to turn south
        myRobot.turn();
        isTurn = myRobot.currentState().direction == Robot.Direction.South;

        assertTrue(isTurn);

    } catch (IllegalStateException e) {
        fail();
    }

    try {
        // Now try to continue to move South.
        myRobot.move();
        assertEquals(2, myRobot.currentState().row);
    } catch (IllegalMoveException e) {
        // Ensure the move didn’t change the robot state
        fail();
    }

    try {
        // Now try to continue to turn west
        myRobot.turn();
        isTurn = myRobot.currentState().direction == Robot.Direction.West;

        assertTrue(isTurn);

    } catch (IllegalStateException e) {
        fail();
    }

    try {
        // Now try to continue to move West.
        myRobot.move();
        assertEquals(1, myRobot.currentState().column);
    } catch (IllegalMoveException e) {
        // Ensure the move didn’t change the robot state
        fail();
    }





}


//public void testBackTrack(){
//    boolean atTop = false;
//    try {
//        // Move the robot to the top row.
//        for (int i = 0; i < Robot.GRID_SIZE - 1; i++)
//            myRobot.move();
//
//        // Check that robot has reached the top.
//        atTop = myRobot.currentState().row == 1;
//        assertTrue(atTop);
//    } catch (IllegalMoveException e) {
//        fail();
//    }
//
//    try {
//
//        myRobot.move();
//        fail();
//    } catch (IllegalMoveException e) {
//        assertEquals(4, myRobot.currentState().row);
//    }
//
//}


}

