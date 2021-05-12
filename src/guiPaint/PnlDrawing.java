package guiPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import geometry.Shape;

public class PnlDrawing extends JPanel {
	protected static Color shColorSide;
	
	Stack<Shape> stackShape = new Stack<Shape>();
	public static Shape tmpShape;
	
	public PnlDrawing() {
		
		setBorder(new LineBorder(Color.BLACK, 2));
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
//	public void paint(Graphics g) {
//		super.paint(g);
//		Iterator<Shape> it = shapes.iterator();
//		while(it.hasNext()) {
//			Shape temp = it.next();
//			g.setColor(temp.getColor());
//			temp.draw(g);
//		}	
//	}
	
	public void paint(Graphics arg0) {
		super.paint(arg0);
		if(tmpShape != null) {
			stackShape.push(tmpShape);
			tmpShape = null;
		}
		for(Shape sh : stackShape) {
			sh.draw(arg0);
		}
	}
	
//	public void paint(Graphics g) {
//		super.paint(g);
//		if(tmpShape != null) {
//			stackShape.push(tmpShape);
//			tmpShape = null;
//		}
//		for(Shape o : stackShape) {
//			o.draw(g);
//		}
//	}
	
	public Shape getTmpShape() {
		return tmpShape;
	}
	
	public void setTmpShape(Shape o) {
		tmpShape = o;
	}
}
