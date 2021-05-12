package guiPaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtInnerRadius;
	private JTextField txtOuterRadius;
	private JButton btnOkDonut;
	private JButton btnCancelDonut;
	private Color color = Color.black;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut(new Point(0, 0));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut(Point pointClick) {
		setBounds(100, 100, 390, 250);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblInnerRadius = new JLabel("Enter inner radius:");
		JLabel lblOuterRadius = new JLabel("Enter outer radius:");
		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);
		txtOuterRadius = new JTextField();
		txtOuterRadius.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInnerRadius)
						.addComponent(lblOuterRadius))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOuterRadius)
						.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		JPanel buttonPane = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
		);
		btnOkDonut = new JButton("Ok");
		btnOkDonut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.parseInt(txtInnerRadius.getText()) > 0 && Integer.parseInt(txtOuterRadius.getText()) > 0) {
						if(Integer.parseInt(txtInnerRadius.getText()) < Integer.parseInt(txtOuterRadius.getText())) {
							PnlDrawing.tmpShape = new Donut(pointClick, Integer.parseInt(txtOuterRadius.getText()), Integer.parseInt(txtInnerRadius.getText()), FrmMain.shColorSide, FrmMain.shColorInside);
//							PnlDrawing.tmpShape.setColorSide(color);
							FrmMain.pnlDrawingMain.repaint();
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "InnerR must be less then OuterR.");
						}
//						PnlDrawing.tmpShape = new Donut(pointClick, Integer.parseInt(txtOuterRadius.getText()),
//								Integer.parseInt(txtInnerRadius.getText()), FrmMain.shColorSide, FrmMain.shColorInside);
//						FrmMain.pnlDrawingMain.repaint();
//						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Value must be positive number.");
					}
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Value must be whole number.");
				}
				
			}
		});
		btnOkDonut.setActionCommand("OK");
		buttonPane.add(btnOkDonut);
		
		
		btnCancelDonut = new JButton("Cancel");
		btnCancelDonut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
					.addContainerGap(212, Short.MAX_VALUE)
					.addComponent(btnOkDonut)
					.addGap(18)
					.addComponent(btnCancelDonut)
					.addContainerGap())
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelDonut)
						.addComponent(btnOkDonut))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		buttonPane.setLayout(gl_buttonPane);
		getContentPane().setLayout(groupLayout);
	}

}
