package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends AreaColor {
	protected Point center;
	protected int r;

	public Circle() {

	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}
	
	public Circle(Point center, int r, Color colorSide, Color colorInside) {
		this(center, r);
		setColorSide(colorSide);
		setClrColorInside(colorInside);
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Circle)
			return (int) (this.area() - ((Circle)o).area());
		return 0;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		center.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		center.moveTo(x, y);
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(getColorSide());
		g.drawOval(center.getX() - r - 1, center.getY() - r - 1, 2 * r + 1, 2 * r + 1);
		this.fill(g);
		if(isSelected()) {
			selected(g);
		}
		
//		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, r + r);
//		if (selected) {
//			g.setColor(Color.blue);
//			g.drawRect(center.getX() - r - 2, center.getY() - 2, 4, 4);
//			g.drawRect(center.getX() + r - 2, center.getY() - 2, 4, 4);
//			g.drawRect(center.getX() - 2, center.getY() - r - 2, 4, 4);
//			g.drawRect(center.getX() - 2, center.getY() + r - 2, 4, 4);
//			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
//		}
	}
	
	public void setR(int r) throws Exception{
		if(r < 0)
			throw new Exception("Radius can't be less than 0");
		this.r = r;
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(new Point(center.getX(), center.getY() - r), new Point(center.getX(), center.getY() + r)).selected(g);
		new Line(new Point(center.getX() - r, center.getY()), new Point(center.getX() + r, center.getY())).selected(g);
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getClrColorInside());
		g.fillOval(center.getX() - r, center.getY() - r, 2 * r, 2 * r);
	}

	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	// Center:(xCenter,yCenter), radius = <radius>
	public String toString() {
		return "Center: " + center + ", radius = " + r;
	}

	public double area() {
		return r * r * Math.PI;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}


}
