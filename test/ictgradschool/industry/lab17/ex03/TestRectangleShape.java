package ictgradschool.industry.lab17.ex03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases to test classes {@link Shape} / {@link RectangleShape}.
 * 
 * @author Ian Warren, Andrew Meads
 */
public class TestRectangleShape {
	private MockPainter painter;

	@Before
	public void setUp() {
		painter = new MockPainter();
	}

	/** Tests whether the {@link RectangleShape}'s default constructor functions as expected. */
	@Test
    public void testDefaultConstructor() {
	    RectangleShape shape = new RectangleShape();

	    assertEquals(0, shape.getX());
        assertEquals(0, shape.getY());
        assertEquals(5, shape.getDeltaX());
        assertEquals(5, shape.getDeltaY());
        assertEquals(25, shape.getWidth());
        assertEquals(35, shape.getHeight());

        // Check that the paint method caused a rectangle at position (0, 0), with size (25, 35), to be drawn.
	    shape.paint(painter);
	    assertEquals("(rectangle 0,0,25,35)", painter.toString());
    }

    /** Tests whether the {@link RectangleShape}'s constructor which takes speed arguments functions as expected. */
    @Test
    public void testConstructorWithSpeedValues() {
        RectangleShape shape = new RectangleShape(1, 2, 3, 4);

        assertEquals(1, shape.getX());
        assertEquals(2, shape.getY());
        assertEquals(3, shape.getDeltaX());
        assertEquals(4, shape.getDeltaY());
        assertEquals(25, shape.getWidth());
        assertEquals(35, shape.getHeight());

        shape.paint(painter);
        assertEquals("(rectangle 1,2,25,35)", painter.toString());
    }

    /** Tests whether the {@link RectangleShape}'s constructor which takes all arguments functions as expected. */
    @Test
    public void testConstructorWithAllValues() {
        RectangleShape shape = new RectangleShape(1, 2, 3, 4, 5, 6);

        assertEquals(1, shape.getX());
        assertEquals(2, shape.getY());
        assertEquals(3, shape.getDeltaX());
        assertEquals(4, shape.getDeltaY());
        assertEquals(5, shape.getWidth());
        assertEquals(6, shape.getHeight());

        shape.paint(painter);
        assertEquals("(rectangle 1,2,5,6)", painter.toString());
    }

	/** Tests whether just moving a {@link RectangleShape} works, with no bouncing involved. */
	@Test
	public void testSimpleMove() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(painter);
		shape.move(500, 500);
		shape.paint(painter);

		// Checks that two rectangles were drawn (one for each call to "paint").
        // The first one should be at the initial position (100, 20), and the second one should be at
        // position (112, 35) (i.e. x + deltaX, y + deltaY). The width and height should be (25, 35) in both cases.
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)",
				painter.toString());
	}

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the right wall. */
    @Test
	public void testShapeMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(painter);
		shape.move(135, 10000);
		shape.paint(painter);
		shape.move(135, 10000);
		shape.paint(painter);

		// Checks that three rectangles were drawn (one for each call to "paint").
        // The first one should be at the initial position (100, 20). The second one should be at position (110, 35)
        // because it hit the right wall (110 is the largest possible x value since the width of the space the shape
        // is moving in is 135, and 135 (the area's width) - 25 (the shape's width) = 110).
        // The third rectangle should be at position (98, 50) because the deltaX should have reversed as the shape bounced,
        // and it should have moved 12 pixels to the left.
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", painter.toString());
	}

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the left wall. */
    @Test
	public void testShapeMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.paint(painter);
		shape.move(10000, 10000);
		shape.paint(painter);
		shape.move(10000, 10000);
		shape.paint(painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", painter.toString());
	}


    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the top wall. */
    @Test
    public void testShapeMoveWithBounceOffTop() {
        RectangleShape shape = new RectangleShape(10, 10, 0, -15);
        shape.paint(painter);
        shape.move(10000, 10000);
        shape.paint(painter);
        shape.move(10000, 10000);
        shape.paint(painter);
        assertEquals("(rectangle 10,10,25,35)(rectangle 10,0,25,35)(rectangle 10,15,25,35)", painter.toString());
    }

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the bottom wall. */
    @Test
    public void testShapeMoveWithBounceOffBottom() {
        RectangleShape shape = new RectangleShape(10, 20, 0, 15);
        shape.paint(painter);
        shape.move(10000, 60);
        shape.paint(painter);
        shape.move(10000, 60);
        shape.paint(painter);
        assertEquals("(rectangle 10,20,25,35)(rectangle 10,25,25,35)(rectangle 10,10,25,35)", painter.toString());
    }

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the bottom-left corner. */
    @Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		shape.paint(painter);
		shape.move(125, 135);
		shape.paint(painter);
		shape.move(125, 135);
		shape.paint(painter);
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)", painter.toString());
	}

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the bottom-right corner. */
    @Test
    public void testShapeMoveWithBounceOffBottomAndRight() {
        RectangleShape shape = new RectangleShape(70, 60, 10, 10);
        shape.paint(painter);
        shape.move(100, 100);
        shape.paint(painter);
        shape.move(100, 100);
        shape.paint(painter);
        assertEquals("(rectangle 70,60,25,35)(rectangle 75,65,25,35)(rectangle 65,55,25,35)", painter.toString());
    }

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the top-right corner. */
    @Test
    public void testShapeMoveWithBounceOffTopAndRight() {
        RectangleShape shape = new RectangleShape(70, 5, 10, -10);
        shape.paint(painter);
        shape.move(100, 100);
        shape.paint(painter);
        shape.move(100, 100);
        shape.paint(painter);
        assertEquals("(rectangle 70,5,25,35)(rectangle 75,0,25,35)(rectangle 65,10,25,35)", painter.toString());
    }

    /** Tests whether moving a {@link RectangleShape} works, when it bounces off the top-left corner. */
    @Test
    public void testShapeMoveWithBounceOffTopAndLeft() {
        RectangleShape shape = new RectangleShape(5, 5, -10, -10);
        shape.paint(painter);
        shape.move(100, 100);
        shape.paint(painter);
        shape.move(100, 100);
        shape.paint(painter);
        assertEquals("(rectangle 5,5,25,35)(rectangle 0,0,25,35)(rectangle 10,10,25,35)", painter.toString());
    }
}
