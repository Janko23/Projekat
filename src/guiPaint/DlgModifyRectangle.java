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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import geometry.*;
import guiPaint.ColorChooserButton.ColorChangedListener;

public class DlgModifyRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color cColorSide;
	private Color cColorInside;
	private JTextField txtToX;
	private JTextField txtToY;
	private JTextField txtForX;
	private JTextField txtForY;
	private JTextField txtWidth;
	private JTextField txtHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyRectangle dialog = new DlgModifyRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyRectangle() {
		setTitle("Rectangle modify:");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtToX = new JTextField();
		txtToX.setColumns(10);
		txtToY = new JTextField();
		txtToY.setColumns(10);
		txtForX = new JTextField();
		txtForX.setColumns(10);
		txtForY = new JTextField();
		txtForY.setColumns(10);
		JLabel lblMoveTo = new JLabel("Move to(x, y):");
		JLabel lblMoveFor = new JLabel("Move for(x, y):");
//		JButton btnInsideColor = new JButton("New button");
//		JButton btnSideColor = new JButton("New button");
//		btnSideColor.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		ColorChooserButton btnInsideColor = new ColorChooserButton(((Rectangle)FrmMain.getSelectedShape()).getClrColorInside());
		btnInsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cColorInside = ((Rectangle)FrmMain.getSelectedShape()).getClrColorInside();
		btnInsideColor.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				cColorInside = newColor;
				
			}
		});
		
		ColorChooserButton btnSideColor = new ColorChooserButton(((Rectangle)FrmMain.getSelectedShape()).getColorSide());
		btnSideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cColorSide = ((Rectangle)FrmMain.getSelectedShape()).getColorSide();
		btnSideColor.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				cColorSide = newColor;
				
			}
		});
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		JLabel lblColorInside = new JLabel("Color Inside:");
		JLabel lblColorSide = new JLabel("Color Side:");
		JLabel lblWidth = new JLabel("Width:");
		JLabel lblHeight = new JLabel("Height:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMoveTo)
						.addComponent(lblMoveFor)
						.addComponent(lblColorInside)
						.addComponent(lblColorSide)
						.addComponent(lblWidth)
						.addComponent(lblHeight))
					.addGap(81)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSideColor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnInsideColor, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtToX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(117))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHeight))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWidth))
							.addGap(18)
							.addComponent(btnSideColor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInsideColor))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblColorSide)
							.addGap(18)
							.addComponent(lblColorInside)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoveTo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoveFor))
					.addContainerGap(23, Short.MAX_VALUE))
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
							if(Integer.parseInt(txtWidth.getText()) > 0 && Integer.parseInt(txtHeight.getText()) > 0) {
								for(Shape o: FrmMain.pnlDrawingMain.stackShape) {
									((Rectangle)o).setWidth(Integer.parseInt(txtWidth.getText()));
									((Rectangle)o).setHeight(Integer.parseInt(txtHeight.getText()));
									((Rectangle)o).setClrColorInside(cColorInside);
									((Rectangle)o).setColorSide(cColorSide);
									((Rectangle)o).moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
									((Rectangle)o).moveBy(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
									o.setSelected(false);
									
								}
							FrmMain.pnlDrawingMain.repaint();
							dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Must be positive number.");
							}
						} catch (NumberFormatException e2) {
							
							JOptionPane.showMessageDialog(null, "Must be integer.");
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
