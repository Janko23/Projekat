package guiPaint;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private JButton btnOkRectangle;
	private JButton btnCancelRectangle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle(new Point(0, 0));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle(Point pointClick) {
		setBounds(100, 100, 400, 200);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnOkRectangle = new JButton("Ok");
		btnOkRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Integer.parseInt(txtHeight.getText()) > 0 && Integer.parseInt(txtWidth.getText()) > 0) {
						PnlDrawing.tmpShape = new Rectangle(pointClick, Integer.parseInt(txtWidth.getText()),
								Integer.parseInt(txtHeight.getText()),
								FrmMain.shColorSide, FrmMain.shColorInside);
						FrmMain.pnlDrawingMain.repaint();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Width and height must be pozitive number.");
					}
						
				} 
				catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Width and height must be whole number.");
				}
			}
		});
		
		btnOkRectangle.setActionCommand("OK");
		buttonPane.add(btnOkRectangle);
		
		btnCancelRectangle = new JButton("Cancel");
		btnCancelRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		btnCancelRectangle.setActionCommand("Cancel");
		buttonPane.add(btnCancelRectangle);
		
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
					.addContainerGap(190, Short.MAX_VALUE)
					.addComponent(btnOkRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelRectangle)
					.addContainerGap())
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOkRectangle)
						.addComponent(btnCancelRectangle))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		buttonPane.setLayout(gl_buttonPane);
		
		JLabel lblHeight = new JLabel("Enter heigt of rectangle:");
		
		JLabel lblWidth = new JLabel("Enter width of rectangle:");
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeight)
						.addComponent(lblWidth))
					.addGap(41)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

}
