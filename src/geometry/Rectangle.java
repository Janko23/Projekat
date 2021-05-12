package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AreaColor{
	private Point upperLeft;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeft, int width, int height, String color) {
		this(upperLeft, width, height);
		setColor(color);
	}
	
	public Rectangle(Point upperLeft, int width, int height, Color colorSide, Color colorInside) {
		this(upperLeft, width, height);
		setColorSide(colorSide);
		setClrColorInside(colorInside);
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		upperLeft.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		upperLeft.moveTo(x, y);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle)
			return (int) (this.area() - ((Rectangle)o).area());
		return 0;
	}

	@Override
	public void selected(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX() + width, getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY() + height)).selected(g);
		new Line(new Point(getUpperLeft().getX() + width, getUpperLeft().getY()), diagonal().getEndPoint()).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY() + height), diagonal().getEndPoint()).selected(g);
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getClrColorInside());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, width - 1, height - 1);
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(getColorSide());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		this.fill(g);
		if(isSelected()) {
			selected(g);
		}
		
//		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
//		if (selected) {
//			g.setColor(Color.blue);
//			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
//			g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
//			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() + height - 2, 4, 4);
//			g.drawRect(upperLeft.getX() + width  - 2, upperLeft.getY() + height - 2, 4, 4);
//		}
	}

	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && x < upperLeft.getX() + width && upperLeft.getY() < y
				&& y < upperLeft.getY() + height);
	}
	
	public Line diagonal() {
		return new Line(upperLeft, new Point(upperLeft.getX() + width, upperLeft.getY() + height));
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	// Upper left point:(xUpperLeft,yUpperLeft), width = <width>, height = <height>
	public String toString() {
		return "Upper left point: " + upperLeft + ", width = " + width + ", height = " + height;
	}

	public int area() {
		return width * height;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	

}
