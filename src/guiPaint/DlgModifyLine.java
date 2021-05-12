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

public class DlgModifyLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color cColorSide;
	private JTextField txtPointStartX;
	private JTextField txtPointStartY;
	private JTextField txtPointEndX;
	private JTextField txtPointEndY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyLine dialog = new DlgModifyLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyLine() {
		setTitle("Line Modify:");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtPointStartX = new JTextField();
		txtPointStartX.setColumns(10);
		txtPointStartY = new JTextField();
		txtPointStartY.setColumns(10);
		JLabel lblPointStart = new JLabel("Point Start(x, y):");
		txtPointEndX = new JTextField();
		txtPointEndX.setColumns(10);
		txtPointEndY = new JTextField();
		txtPointEndY.setColumns(10);
		JLabel lblPointEnd = new JLabel("Point End(x, y):");
		ColorChooserButton btnSideColor = new ColorChooserButton(((Line)FrmMain.getSelectedShape()).getColorSide());
		btnSideColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cColorSide = ((Line)FrmMain.getSelectedShape()).getColorSide();
		btnSideColor.addColorChangedListener(new ColorChangedListener() {
			public void colorChanged(Color newColor) {
				cColorSide = newColor;
			}
		});
		JLabel lblColor = new JLabel("Color:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPointStart)
						.addComponent(lblPointEnd)
						.addComponent(lblColor))
					.addGap(64)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSideColor, 0, 0, Short.MAX_VALUE)
						.addComponent(txtPointEndX, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(txtPointStartX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtPointEndY, 0, 0, Short.MAX_VALUE)
						.addComponent(txtPointStartY, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(121))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblColor)
						.addComponent(btnSideColor))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPointStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPointStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPointStart))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPointEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPointEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPointEnd))
					.addContainerGap(74, Short.MAX_VALUE))
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
							for(Shape o: FrmMain.pnlDrawingMain.stackShape) {
								if(o == FrmMain.getSelectedShape()) {
									
									((Line)o).setColorSide(cColorSide);
									((Line)o).setStartPoint(new Point(Integer.parseInt(txtPointStartX.getText()), Integer.parseInt(txtPointStartY.getText())));
									((Line)o).setEndPoint(new Point(Integer.parseInt(txtPointEndX.getText()), Integer.parseInt(txtPointEndY.getText())));
									o.setSelected(false);
								}
							FrmMain.pnlDrawingMain.repaint();
							dispose();
							}
						} catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Values must be integer.");
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
