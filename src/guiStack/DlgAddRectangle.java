package guiStack;

import geometry.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

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

public class DlgAddRectangle extends JDialog {

	
	// components
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUpperLeftX;
	private JTextField txtUpperLeftY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JButton btnAdd;
	
	public static Stack<Rectangle> stackRect = new Stack<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAddRectangle dialog = new DlgAddRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddRectangle() {
		initialize();
		events();
	}
	
	// init components
	
	public void initialize() {
		setBounds(100, 100, 405, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		txtUpperLeftX = new JTextField();
		txtUpperLeftX.setColumns(10);
		
		txtUpperLeftY = new JTextField();
		txtUpperLeftY.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		
		JLabel lblUpperLeftX = new JLabel("Upper Left X");
		
		JLabel lblUpperLeftY = new JLabel("Upper Left Y");
		
		JLabel lblWidth = new JLabel("Width");
		
		JLabel lblHeight = new JLabel("Height");
		
		btnAdd = new JButton("Add");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUpperLeftY)
								.addComponent(lblUpperLeftX)
								.addComponent(lblWidth)
								.addComponent(lblHeight))
							.addGap(47)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUpperLeftY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUpperLeftX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(103))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(50))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUpperLeftX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpperLeftX))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUpperLeftY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpperLeftY))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWidth))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeight))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnAdd))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	// declaration of events
	public void events() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if((Integer.parseInt(txtHeight.getText())) > 0 & (Integer.parseInt(txtWidth.getText())) > 0) {
						
						stackRect.push(new Rectangle(new Point(Integer.parseInt(txtUpperLeftX.getText()),
								Integer.parseInt(txtUpperLeftY.getText())),
								Integer.parseInt(txtWidth.getText()),
								Integer.parseInt(txtHeight.getText()) ));
						
						FrmStack.txtRectangle.setText("");
						
						for(Rectangle rect : stackRect)
							FrmStack.txtRectangle.append(rect.toString() + "\n");
						
						JOptionPane.showMessageDialog(null, "Rectangle is added.");
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Value must be greater than 0.");
					
				} catch(NumberFormatException ce) {
					JOptionPane.showMessageDialog(null, "Input values must be whole numbers!");
				} catch (Exception ce) {
					JOptionPane.showMessageDialog(null, "Error!");
					dispose();
				}
				
			}
		});
	}
}
