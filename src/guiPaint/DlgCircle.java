package guiPaint;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import geometry.Circle;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DlgCircle extends JDialog {
	private JTextField txtRadius;
	private JButton btnOkCircle;
	private JButton btnCancelCircle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCircle dialog = new DlgCircle(new Point(0, 0));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle(Point pointClick) {
		setBounds(100, 100, 350, 170);
		
		JPanel contentPane = new JPanel();
		
		JPanel buttonPane = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
						.addComponent(contentPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPane, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
		);
		
		JLabel lblRadius = new JLabel("Enter radius of circle");
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRadius)
					.addGap(33)
					.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnOkCircle = new JButton("Ok");
		btnOkCircle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Integer.parseInt(txtRadius.getText()) > 0) {
						PnlDrawing.tmpShape = new Circle(pointClick, Integer.parseInt(txtRadius.getText()), FrmMain.shColorSide, FrmMain.shColorInside);
						FrmMain.pnlDrawingMain.repaint();
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "The length of the radius must be a positive number.");
					
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "The length of the radius must be a whole number.");
				}
			}
		});
		btnOkCircle.setActionCommand("Ok");
		buttonPane.add(btnOkCircle);
		

		
		btnCancelCircle = new JButton("Cancel");
		btnCancelCircle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		btnCancelCircle.setActionCommand("Cancel");
		buttonPane.add(btnCancelCircle);
		
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
					.addContainerGap(173, Short.MAX_VALUE)
					.addComponent(btnOkCircle, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancelCircle))
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelCircle)
						.addComponent(btnOkCircle))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		buttonPane.setLayout(gl_buttonPane);
		getContentPane().setLayout(groupLayout);

	}
}
