package ictgradschool.industry.lab17.ex03;

import java.util.ArrayList;
import java.util.List;

public class NestingShape extends Shape {

	private List<Shape> children = new ArrayList<>();

	public NestingShape() {
	}

	public NestingShape(int x, int y) {
		super(x, y);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	@Override
	public void move(int width, int height) {
		super.move(width, height);
		for (Shape s : children) {
			s.move(fWidth, fHeight);
		}
	}

	@Override
	public void paint(Painter painter) {
		painter.drawRect(fX, fY, fWidth, fHeight);
		painter.translate(fX, fY);
		for (Shape s : children) {
			s.paint(painter);
		}
		painter.translate(-fX, -fY);
	}

	public void add(Shape child) throws IllegalArgumentException {
		if (child.fParent != null) {
			throw new IllegalArgumentException("Child already has a parent.");
		}

		if (child.fX + child.fWidth >= fWidth || child.fY + child.fHeight >= fHeight || child.fX < 0 || child.fY < 0) {
			throw new IllegalArgumentException("Child shape doesn't fit!");
		}

		children.add(child);
		child.fParent = this;
	}

	public void remove(Shape child) {
		if (children.remove(child)) {
			child.fParent = null;
		}
	}

	public int shapeCount() {
		return children.size();
	}

	public int indexOf(Shape child) {
		return children.indexOf(child);
	}

	public boolean contains(Shape child) {
		return children.contains(child);
	}

	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		return children.get(index);
	}

}
