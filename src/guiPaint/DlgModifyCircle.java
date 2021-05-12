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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import geometry.*;
import geometry.Shape;
import guiPaint.ColorChooserButton.ColorChangedListener;

public class DlgModifyCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color cColorSide;
	private Color cColorInside;
	private JTextField txtToX;
	private JTextField txtToY;
	private JTextField txtForX;
	private JTextField txtForY;
	private JTextField txtRadiusCircle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyCircle dialog = new DlgModifyCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyCircle() {
		setTitle("Circle modify:");
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
		
		ColorChooserButton btnInsideColor = new ColorChooserButton(((Circle)FrmMain.getSelectedShape()).getClrColorInside());
		btnInsideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cColorInside = ((Circle)FrmMain.getSelectedShape()).getClrColorInside();
		btnInsideColor.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				cColorInside = newColor;
				
			}
		});
		
		ColorChooserButton btnSideColor = new ColorChooserButton(((Circle)FrmMain.getSelectedShape()).getColorSide());
		btnSideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cColorSide = ((Circle)FrmMain.getSelectedShape()).getColorSide();
		btnSideColor.addColorChangedListener(new ColorChangedListener() {
			
			@Override
			public void colorChanged(Color newColor) {
				cColorSide = newColor;
				
			}
		});
		JLabel lblInsideColor = new JLabel("Color of inside:");
		JLabel lblSideColor = new JLabel("Color Side:");
		txtRadiusCircle = new JTextField();
		txtRadiusCircle.setColumns(10);
		JLabel lblRadius = new JLabel("Radius:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMoveTo)
						.addComponent(lblMoveFor)
						.addComponent(lblInsideColor)
						.addComponent(lblSideColor)
						.addComponent(lblRadius))
					.addGap(52)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRadiusCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSideColor, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnInsideColor, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtToX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSideColor)
						.addComponent(lblSideColor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInsideColor)
						.addComponent(lblInsideColor))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoveTo))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoveFor))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRadiusCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							if(Integer.parseInt(txtRadiusCircle.getText()) > 0) {
								for(Shape o: FrmMain.pnlDrawingMain.stackShape) {
									if(o == FrmMain.getSelectedShape()) {
										((Circle)o).setR(Integer.parseInt(txtRadiusCircle.getText()));
										((Circle)o).setColorSide(cColorSide);
										((Circle)o).setClrColorInside(cColorInside);
										((Circle)o).moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
										((Circle)o).moveBy(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
										o.setSelected(false);
									}
								}
							FrmMain.pnlDrawingMain.repaint();
							dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Radius must be positive number.");
							}
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Radius must be integer.");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
