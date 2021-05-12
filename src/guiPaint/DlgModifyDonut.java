package guiPaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import geometry.*;
import guiPaint.ColorChooserButton.ColorChangedListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgModifyDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color cColorSide;
	private Color cColorInside;
	private JTextField txtForX;
	private JTextField txtForY;
	private JTextField txtToX;
	private JTextField txtToY;
	private JTextField txtInnerR;
	private JTextField txtR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyDonut dialog = new DlgModifyDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyDonut() {
		setTitle("Donut modify:");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtForX = new JTextField();
		txtForX.setColumns(10);
		txtForY = new JTextField();
		txtForY.setColumns(10);
		txtToX = new JTextField();
		txtToX.setColumns(10);
		txtToY = new JTextField();
		txtToY.setColumns(10);
		txtInnerR = new JTextField();
		txtInnerR.setColumns(10);
		txtR = new JTextField();
		txtR.setColumns(10);
//		JButton btnInsideColor = new JButton("New button");
//		btnInsideColor.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		ColorChooserButton btnInsideColor = new ColorChooserButton(((Donut)FrmMain.getSelectedShape()).getClrColorInside());
		btnInsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cColorInside = ((Donut)FrmMain.getSelectedShape()).getClrColorInside();
		btnInsideColor.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				cColorInside = newColor;
				
			}
		});
		
//		JButton btnSideColor = new JButton("New button");
//		btnSideColor.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		ColorChooserButton btnSideColor = new ColorChooserButton(((Donut)FrmMain.getSelectedShape()).getColorSide());
		btnSideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cColorSide = ((Donut)FrmMain.getSelectedShape()).getColorSide();
		btnSideColor.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				cColorSide = newColor;
				
			}
		});
		
		JLabel lblMoveFor = new JLabel("Move for(x, y):");
		JLabel lblMoveTo = new JLabel("Move to(x, y):");
		JLabel lblInnerR = new JLabel("Inner radius:");
		JLabel lblR = new JLabel("Outer radius:");
		JLabel lblInsideColor = new JLabel("Inside color:");
		JLabel lblSideColor = new JLabel("Side color:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMoveFor)
								.addComponent(lblMoveTo)
								.addComponent(lblInnerR)
								.addComponent(lblR))
							.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
								.addComponent(txtInnerR, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblSideColor)
							.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
							.addComponent(btnSideColor))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblInsideColor)
							.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
							.addComponent(btnInsideColor)))
					.addGap(89))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnSideColor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInsideColor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblSideColor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblInsideColor)
							.addGap(18)
							.addComponent(lblR)))
					.addGap(9)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtInnerR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInnerR))
					.addGap(15)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoveTo))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoveFor))
					.addGap(22))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							if(Integer.parseInt(txtR.getText()) > 0 && Integer.parseInt(txtInnerR.getText()) > 0) {
								for(Shape o: FrmMain.pnlDrawingMain.stackShape)
									if(o == FrmMain.getSelectedShape()) {
										((Donut)o).setInnerR(Integer.parseInt(txtInnerR.getText()));
										((Donut)o).setR(Integer.parseInt(txtR.getText()));
										((Donut)o).setColorSide(cColorSide);
										((Donut)o).setClrColorInside(cColorInside);
										((Donut)o).moveBy(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
										((Donut)o).moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
									}
							FrmMain.pnlDrawingMain.repaint();
							dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Must be positive number.");
							}
						} catch (NumberFormatException e2) {
							
							JOptionPane.showMessageDialog(null, "Must be integer number.");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
