package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape implements Moveable{
	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		// setX(x);
		this.y = y;
	}
	
	public Point(int x, int y, Color col) {
		this(x, y);
		// this.x = x;
		// this.y = y;
		setColorSide(col);
	}
	
	public Point(int x, int y, String color) {
		this(x, y);
		setColor(color);
	}

	public Point(int x, int y, Color col, boolean selected) {
		this(x, y);
		// this.x = x;
		// this.y = y;
		setColorSide(col);
		this.selected = selected;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) 
			return (int) (this.distance(0, 0) - ((Point) o).distance(0,0));
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		x += byX;
		y += byY;
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(getColorSide());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2, x, y-2);
		
		if(isSelected()) {
			selected(g);
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	public String toString() {
		// (x,y)
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if (x == temp.x && y == temp.y)
				return true;
			// else
			// return false;
		}
		return false;
	}

	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX * dX + dY * dY);
		return d;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x - 3, y - 3, 6, 6);
		
	}

}
