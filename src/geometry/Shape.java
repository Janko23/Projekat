package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{
	protected boolean selected;
	private String strColor = "black";
	protected Color colorSide;

	

	public Shape() {

	}

	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
//	public abstract void drawInner(Graphics g, int InnerR);
	public abstract void selected(Graphics g);

	public boolean isSelected() {
		return selected;
	}
	
	public String getColor() {
		return strColor;
	}

	public void setColor(String color) {
		this.strColor = color;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Color getColorSide() {
		return colorSide;
	}

	public void setColorSide(Color color) {
		this.colorSide = color;
	}
}
