package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.management.InstanceAlreadyExistsException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Drawing extends JPanel {
	public Drawing() {
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent tooltipKoordinate) {
				ToolTipManager.sharedInstance().setInitialDelay(0);
				setToolTipText("(" + tooltipKoordinate.getX() + "," + tooltipKoordinate.getY() + ")");
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				Point point = new Point(me.getX(), me.getY());
				shapes.add(point);
				repaint();
			}
		});
	}
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();

	public static void main(String[] args) {

		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			temp.draw(g);
		}	
	}

}
