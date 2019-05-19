package ictgradschool.industry.lab17.ex03;

import java.awt.*;
import java.util.Arrays;

/**
 * Implementation of the {@link Painter} interface that does not actually do any painting. {@link MockPainter}
 * implementation responds to {@link Painter} requests by logging the request in a buffer. The contents of a
 * {@link MockPainter} object's log can be retrieved by a call to {@link #toString()} on the {@link MockPainter}.
 * 
 * @author Ian Warren
 */
public class MockPainter implements Painter {

	/** Internal log. */
	private StringBuffer log = new StringBuffer();

	/** Stores a color so that the {@link #getColor()} method can actually function. */
	private Color color = Color.black;

	/** Gets the contents of this {@link MockPainter}'s log. */
    @Override
	public String toString() {
		return log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
    @Override
	public void drawRect(int x, int y, int width, int height) {
		log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
    @Override
	public void drawOval(int x, int y, int width, int height) {
		log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
    @Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

    /**
     * Logs the setColor call.
     *
     * @param color
     */
	@Override
	public void setColor(Color color) {
		this.color = color;
		log.append("(setColor " + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")");
	}

    /**
     * Logs the getColor call.
     */
	@Override
	public Color getColor() {
	    if (color != null) {
            log.append("(getColor " + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")");
        } else {
	        log.append("(getColor null)");
        }
		return this.color;
	}

    /**
     * Logs the drawPolygon call.
     */
    @Override
    public void drawPolygon(Polygon polygon) {
        log.append("(polygon xpoints: " + Arrays.toString(polygon.xpoints) + ", ypoints: " + Arrays.toString(polygon.ypoints) + ")");
    }

    /**
     * Logs the fillRect call.
     */
    @Override
    public void fillRect(int x, int y, int width, int height) {
        log.append("(fillRect " + x + "," + y + "," + width + "," + height + ")");
    }

    /**
     * Logs the drawImage call.
     */
    @Override
    public void drawImage(Image img, int x, int y, int width, int height) {
		log.append("(image " + x + "," + y + "," + width + "," + height + ")");
    }

    /**
     * Logs the translate call.
     */
	@Override
	public void translate(int x, int y) {
		log.append("(translate " + x + "," + y + ")");
	}
}