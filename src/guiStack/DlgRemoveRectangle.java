package guiStack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import geometry.*;

public class DlgRemoveRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblConfirmQuestion;
	private JTextField txtUpperLeftXRemove;
	private JTextField txtUpperLeftYRemove;
	private JTextField txtWidthRemove;
	private JTextField txtHeightRemove;
	private JButton btnCancel;
	private JButton btnRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRemoveRectangle dialog = new DlgRemoveRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRemoveRectangle() {
		initialize();
		
		if(!DlgAddRectangle.stackRect.isEmpty()) {
			Rectangle rectTemp = DlgAddRectangle.stackRect.peek();
			txtUpperLeftXRemove.setText(Integer.toString(rectTemp.getUpperLeft().getX()));
			txtUpperLeftYRemove.setText(Integer.toString(rectTemp.getUpperLeft().getY()));
			txtWidthRemove.setText(Integer.toString(rectTemp.getWidth()));
			txtHeightRemove.setText(Integer.toString(rectTemp.getHeight()));
		}
		events();
	}
	
	public void initialize(){
		setTitle("Pop Rectangle From Stack");
		setBounds(100, 100, 405, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		{
			lblConfirmQuestion = new JLabel("Are you sure you want to remove rectangle from stack?");
		}
		txtUpperLeftXRemove = new JTextField();
		txtUpperLeftXRemove.setEditable(false);
		txtUpperLeftXRemove.setColumns(10);
		txtUpperLeftYRemove = new JTextField();
		txtUpperLeftYRemove.setEditable(false);
		txtUpperLeftYRemove.setColumns(10);
		txtWidthRemove = new JTextField();
		txtWidthRemove.setEditable(false);
		txtWidthRemove.setColumns(10);
		txtHeightRemove = new JTextField();
		txtHeightRemove.setEditable(false);
		txtHeightRemove.setColumns(10);
		JLabel lblUpperLeftXRemove = new JLabel("Upper Left X");
		JLabel lblUpperLeftYRemove = new JLabel("Upper Left Y");
		JLabel lblWidthRemove = new JLabel("Width");
		JLabel lblHeightRemove = new JLabel("Height");
		btnCancel = new JButton("Cancel");
		btnRemove = new JButton("Remove");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblHeightRemove)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtHeightRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblWidthRemove)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtWidthRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblUpperLeftYRemove)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtUpperLeftYRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblUpperLeftXRemove)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtUpperLeftXRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblConfirmQuestion))
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(173, Short.MAX_VALUE)
					.addComponent(btnRemove)
					.addGap(18)
					.addComponent(btnCancel)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblConfirmQuestion, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUpperLeftXRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpperLeftXRemove))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUpperLeftYRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpperLeftYRemove))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtWidthRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWidthRemove))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHeightRemove, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeightRemove))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnRemove))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}
	
	public void events() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DlgAddRectangle.stackRect.pop();
				
				FrmStack.txtRectangle.setText("");
				for(Rectangle rect : DlgAddRectangle.stackRect)
					FrmStack.txtRectangle.append(rect.toString() + "\n");
				
				JOptionPane.showMessageDialog(null, "Rectangle is removed.");
				dispose();
			}
		});
	}

}
