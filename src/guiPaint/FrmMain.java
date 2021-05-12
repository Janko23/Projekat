package guiPaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import geometry.Drawing;
//import geometry.Line;
//import geometry.Point;
//import geometry.Shape;
import geometry.*;
import guiPaint.ColorChooserButton.ColorChangedListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class FrmMain extends JFrame {

	private JPanel contentPane;
 
	private JComboBox<String> cmdChooseShape;
	static PnlDrawing pnlDrawingMain = new PnlDrawing();
	private JLabel lblChooseColorOfSide;
	private ColorChooserButton btnChooseColorOfSide;
	private ColorChooserButton btnChooseColorInside;
	private JToggleButton tglbtnSelect;
	private JButton btnModify;
	private JButton btnRemove;
	private JButton btnRemoveAll;
//	static PnlDrawing pnlDrawing = new PnlDrawing();
	private static Shape selectedShape;
	public static Color shColorSide = Color.BLACK;
	public static Color shColorInside = Color.WHITE;
	private boolean isLine = false;
	private Point startPointLine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMain() {
		initiliaze();
		events();
	}
	
	public void initiliaze() {
		setTitle("MH 33/2016 Janko Tovilovic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// combobox for choosing shape which we want to paint
		JLabel lblChooseShape = new JLabel("Choose Shape");
		cmdChooseShape = new JComboBox<String>();
		cmdChooseShape.setModel(new DefaultComboBoxModel<String>(new String[] {"Point", "Line", "Circle", "Rectangle", "Donut"}));
		
		
		
		btnChooseColorOfSide = new ColorChooserButton(Color.BLACK);
		btnChooseColorOfSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblChooseColorOfSide = new JLabel("Choose color of side");
		
		btnChooseColorInside = new ColorChooserButton(Color.BLACK);
		
		JLabel lblChooseColorInside = new JLabel("Choose inside color");
		
		tglbtnSelect = new JToggleButton("Select");
		
		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		
		btnModify.setEnabled(false);
		
		btnRemove = new JButton("Remove");
		btnRemove.setEnabled(false);
		
		btnRemoveAll = new JButton("Remove All");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tglbtnSelect, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblChooseShape)
							.addGap(18)
							.addComponent(cmdChooseShape, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(100)
							.addComponent(lblChooseColorOfSide, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnChooseColorOfSide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(lblChooseColorInside)
							.addGap(18)
							.addComponent(btnChooseColorInside, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(87))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnModify, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(btnRemove, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(btnRemoveAll, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlDrawingMain, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblChooseShape)
							.addComponent(cmdChooseShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblChooseColorInside)
						.addComponent(btnChooseColorInside, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseColorOfSide)
						.addComponent(btnChooseColorOfSide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tglbtnSelect)
							.addGap(185)
							.addComponent(btnModify)
							.addGap(18)
							.addComponent(btnRemove)
							.addGap(18)
							.addComponent(btnRemoveAll))
						.addComponent(pnlDrawingMain, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void events() {
		/////////////////////////////
		tglbtnSelect.addItemListener(new ItemListener() {
		
			@Override
			public void itemStateChanged(ItemEvent ie) {
			// TODO Auto-generated method stub
				if(ie.getStateChange() == ItemEvent.SELECTED) {
					
				btnRemoveAll.setEnabled(false);
					pnlDrawingMain.addMouseListener(new MouseAdapter() {
						
						public void mousePressed(MouseEvent arg0) {
							if(pnlDrawingMain.stackShape.isEmpty() && tglbtnSelect.isSelected()) {
								JOptionPane.showMessageDialog(null, "There's no element for selection!");
								tglbtnSelect.setSelected(false);
							}
							else {
								deselection();
								for(int i = pnlDrawingMain.stackShape.size() - 1; i >= 0; i--) {
									if(pnlDrawingMain.stackShape.get(i).contains(arg0.getX(), arg0.getY()) && tglbtnSelect.isSelected()) {
										pnlDrawingMain.stackShape.get(i).setSelected(true);
										setSelectedShape(pnlDrawingMain.stackShape.get(i));
										btnModify.setEnabled(true);
										btnRemove.setEnabled(true);
										repaint();
										break;
										}
									}
								}
							}
						});
				}
				else if(ie.getStateChange() == ItemEvent.DESELECTED) {
					btnRemoveAll.setEnabled(true);
					deselection();
					btnModify.setEnabled(false);
					btnRemove.setEnabled(false);
					repaint();
				}
			}
		});
		
		/////////////////////////////
		
		////////////////////////////
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = pnlDrawingMain.stackShape.size() - 1; i >= 0; i--) {
					if(pnlDrawingMain.stackShape.get(i).equals(selectedShape)) {
						
						if(selectedShape instanceof Point) {
							DlgModifyPoint modify = new DlgModifyPoint();
							modify.setVisible(true);
						}
						else if(selectedShape instanceof Line) {
							DlgModifyLine modify = new DlgModifyLine();
							modify.setVisible(true);
						}
						else if(selectedShape instanceof Circle) {
							DlgModifyCircle modify = new DlgModifyCircle();
							modify.setVisible(true);
						}
						else if(selectedShape instanceof Rectangle) {
							DlgModifyRectangle modify = new DlgModifyRectangle();
							modify.setVisible(true);
						}
						else if(selectedShape instanceof Donut) {
							DlgModifyDonut modify = new DlgModifyDonut();
							modify.setVisible(true);
						}
						
						btnModify.setEnabled(false);
						btnRemove.setEnabled(false);
						break;
					}
				}
			}
		});
		////////////////////////////
		
		////////////////////////////
		btnRemove.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDrawingMain.stackShape.remove(selectedShape);
				btnModify.setEnabled(false);
				btnRemove.setEnabled(false);
				repaint();
			}
		});
		////////////////////////////
		
		////////////////////////////
		btnRemoveAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDrawingMain.stackShape.removeAllElements();
				repaint();
			}
		});
		////////////////////////////
		
		////////////////////////////
		cmdChooseShape.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cmdChooseShape.getSelectedItem().toString() == "Point" || cmdChooseShape.getSelectedItem().toString() == "Line") {
					btnChooseColorInside.setEnabled(false);
				}
				else {
					btnChooseColorInside.setEnabled(true);
				}
				
			}
		});
		////////////////////////////
		
		btnChooseColorOfSide.addColorChangedListener(new ColorChangedListener() {
			@Override
			public void colorChanged(Color newColor) {
				shColorSide = newColor;
				
			}
		});
		
		
		btnChooseColorInside.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				shColorInside = newColor;
				
			}
		});
		/////////////////////////////
		pnlDrawingMain.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				// drawing
				
				if(!tglbtnSelect.isSelected()) {
					switch(cmdChooseShape.getSelectedItem().toString()) {
					case "Point":{
						
						pnlDrawingMain.setTmpShape(new Point(arg0.getX(), arg0.getY(), shColorSide));
						repaint();
						break;
						
					}
					case "Line":{
						if(!isLine) {
							JOptionPane.showMessageDialog(null, "Starting point of line.");
							startPointLine = new Point(arg0.getX(), arg0.getY());
							isLine = true;
						}
						else if(isLine) {
							pnlDrawingMain.setTmpShape(new Line(startPointLine, new Point(arg0.getX(), arg0.getY()), shColorSide));
							repaint();
							isLine = false;
						}
						break;
					}
					case "Circle":{
						DlgCircle drawCircleMain = new DlgCircle(new Point(arg0.getX(), arg0.getY()));
						drawCircleMain.setVisible(true);
						
						break;
					}
					case "Rectangle":{
						DlgRectangle drawRectangleMain = new DlgRectangle(new Point(arg0.getX(), arg0.getY()));
						drawRectangleMain.setVisible(true);
						
						break;
					}
					case "Donut":{
						DlgDonut drawDonutMain = new DlgDonut(new Point(arg0.getX(), arg0.getY()));
						drawDonutMain.setVisible(true);
						
						break;
					}
					}
				}
			}
		});
		/////////////////////////////
		
		
		
	}
	
	public static void deselection() {
		for(Shape sh : pnlDrawingMain.stackShape) {
			if(sh.isSelected()) sh.setSelected(false);
		}
	}
	
	public static Shape getSelectedShape() {
		return selectedShape;
	}
	
	public static void setSelectedShape(Shape selectedShape) {
		FrmMain.selectedShape = selectedShape;
	}
}
