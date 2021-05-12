package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AreaColor extends Shape {
	private String strColorInside = "white";
	private Color clrColorInside = Color.WHITE;
	
	public abstract void fill(Graphics g);
	
	public String getStrColorInside() {
		return strColorInside;
	}
	
	public void setStrColorInside(String strColorInside) {
		this.strColorInside = strColorInside;
	}
	
	public Color getClrColorInside() {
		return clrColorInside;
	}
	
	public void setClrColorInside(Color clrColorInside) {
		this.clrColorInside = clrColorInside;
	}
}
