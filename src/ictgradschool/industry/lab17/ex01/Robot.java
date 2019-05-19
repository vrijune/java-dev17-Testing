package ictgradschool.industry.lab17.ex01;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    /** Enumerates different directions a robot can travel */
    public enum Direction {
        North, East, South, West
    }

    public static final int GRID_SIZE = 10;

    /** Collection of RobotState objects */
    List<RobotState> states;

    /** Creates a Robot in the bottom left corner facing North. */
    public Robot() {
        states = new ArrayList<RobotState>();
        states.add(new RobotState(Direction.North, 10, 1));
    }

    /** Turns a Robot 90 degrees to the right. */
    public void turn() {
        RobotState currentState = states.get(states.size() - 1);
        Direction newDirection = currentState.direction;
        switch (currentState.direction) {
            case North:
                newDirection = Direction.East;
                break;
            case East:
                newDirection = Direction.South;
                break;
            case South:
                newDirection = Direction.West;
                break;
            case West:
                newDirection = Direction.North;
                break;
        }
        states.add(new RobotState(newDirection, currentState.row, currentState.column));
    }

    /** Advances a Robot 1 cell in the direction it's facing. */
    public void move() throws IllegalMoveException {
        RobotState currentState = states.get(states.size() - 1);
        int newRow = currentState.row;
        int newColumn = currentState.column;
        switch (currentState.direction) {
            case North:
                newRow = newRow - 1;
                break;
            case East:
                newColumn = newColumn + 1;
                break;
            case South:
                newRow = newRow + 1;
                break;
            case West:
                newColumn = newColumn - 1;
                break;
        }
        if (newRow < 1 || newColumn < 1 || newRow > GRID_SIZE || newColumn > GRID_SIZE)
            throw new IllegalMoveException();

        states.add(new RobotState(currentState.direction, newRow, newColumn));
    }

    /** Reverses the Robot's last move/turn action. */
    public void backTrack() {
        states.remove((states.size() - 1));
    }

    /** Returns the current direction of the robot */
    public Direction getDirection() {
        RobotState currentState = states.get(states.size() - 1);
        return currentState.direction;
    }

    /** Returns the current row of the robot */
    public int row() {
        RobotState currentState = states.get(states.size() - 1);
        return currentState.row;
    }

    /** Returns the current column of the robot */
    public int column() {
        RobotState currentState = states.get(states.size() - 1);
        return currentState.column;
    }

    /** Returns the current state of the robot */
    public RobotState currentState() {
        return states.get(states.size() - 1);
    }

    /** Represents the state of a robot. */
    public class RobotState {
        public final Direction direction;
        public final int row;
        public final int column;

        public RobotState(Direction direction, int row, int column) {
            this.direction = direction;
            this.row = row;
            this.column = column;
        }
    }

}