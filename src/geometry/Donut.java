package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerR;

	public Donut() {

	}

	public Donut(Point center, int r, int innerR) {
		super(center, r);
		this.innerR = innerR;
	}
	
	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
//		super(center, r, selected);
//		this.innerR = innerR;
	}
	
	public Donut(Point center, int r, int innerR, Color colorSide, Color colorInside) {
		this(center, r, innerR);
		setColorSide(colorSide);
		setClrColorInside(colorInside);
	}
	
	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(new Point(center.getX(), center.getY() - r), new Point(center.getX(), center.getY() + r)).selected(g);
		new Line(new Point(center.getX() - r, center.getY()), new Point(center.getX() + r, center.getY())).selected(g);
	}

	
//	public void draw(Graphics g) {
//			
//			g.setColor(getColorSide());
//			g.drawOval(center.getX() - r, center.getY() - r, 2 * r, 2 * r);
//			this.fill(g);
//			if(isSelected()) {
//				selected(g);
//			}
	
	@Override
	public void draw(Graphics g) {
//		g.setColor(getColorSide());
//		g.drawOval(center.getX()-innerR, center.getY()-innerR, 2*innerR, 2*innerR);
//		this.fill(g);
//		if(isSelected()) {
//			selected(g);
//		}
		super.draw(g);
		g.setColor(getColorSide());
		g.drawOval(center.getX() - innerR, center.getY() - innerR, 2*innerR, 2*innerR);
//		g.setColor(getColorSide());
//		g.setColor(getColorSide());
//		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, 2 * r);
//		g.setColor(getColorSide());
//		this.fill(g);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getCenter().getX() - innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - innerR - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + innerR - 2, 4, 4);
		}
	}

	@Override
	public double area() {
		return super.area() - innerR * innerR * Math.PI;
	}
	
	@Override
	public void fill(Graphics g) {
//		g.setColor(Color.WHITE);
		g.fillOval(center.getX() - innerR + 1, center.getY() - innerR + 1, 2 * innerR - 2, 2 * innerR - 2);
		g.setColor(getClrColorInside());
		g.fillOval(center.getX() - r + 1, center.getY() - r + 1, 2 * r - 2, 2 * r - 2);
		g.setColor(Color.WHITE);
		g.fillOval(center.getX() - innerR + 1, center.getY() - innerR + 1, 2 * innerR - 2, 2 * innerR - 2);
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) >= innerR;
	}

	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	// Center:(xCenter,yCenter), radius = <radius>, inner radius = <radius>
	public String toString() {
		return super.toString()+", inner radius = "+innerR;
	}
	
	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}


}
