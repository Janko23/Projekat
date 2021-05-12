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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import guiPaint.ColorChooserButton.ColorChangedListener;
import geometry.*;
import geometry.Shape;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgModifyPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color cColorSide;
	private JTextField txtToX;
	private JTextField txtToY;
	private JTextField txtForX;
	private JTextField txtForY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyPoint dialog = new DlgModifyPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyPoint() {
		setTitle("Point Modify");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblMoveTo = new JLabel("Move to (x, y):");
		
		JLabel lblMoveFor = new JLabel("Move for (x, y):");
		
		txtToX = new JTextField();
		txtToX.setColumns(10);
		
		txtToY = new JTextField();
		txtToY.setColumns(10);
		
		txtForX = new JTextField();
		txtForX.setColumns(10);
		
		txtForY = new JTextField();
		txtForY.setColumns(10);
		
//		JButton btnSideColor = new JButton("Color:");
		ColorChooserButton btnSideColor = new ColorChooserButton(((Point)FrmMain.getSelectedShape()).getColorSide());
		btnSideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cColorSide = ((Point)FrmMain.getSelectedShape()).getColorSide();
		btnSideColor.addColorChangedListener(new ColorChangedListener() {
			public void colorChanged(Color newColor) {
				cColorSide = newColor;
			}
		});
		
		JLabel lblColor = new JLabel("Color:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMoveTo)
						.addComponent(lblMoveFor)
						.addComponent(lblColor))
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSideColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtForX, 0, 0, Short.MAX_VALUE)
								.addComponent(txtToX, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtForY, 0, 0, Short.MAX_VALUE)
								.addComponent(txtToY, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSideColor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMoveTo)
						.addComponent(txtToX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtToY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMoveFor)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtForX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtForY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(84, Short.MAX_VALUE))
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
							for(Shape o: FrmMain.pnlDrawingMain.stackShape)
								if(o == FrmMain.getSelectedShape()) {
									((Point)o).setColorSide(cColorSide);
									((Point)o).moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
									((Point)o).moveBy(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
									o.setSelected(false);
								}
							FrmMain.pnlDrawingMain.repaint();
							dispose();
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Values must be integers.");
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
