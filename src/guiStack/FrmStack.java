package guiStack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrmStack extends JFrame {

	private JPanel pnlForStackText;
	
	public static JTextArea txtRectangle;
	private JButton btnPushStack;
	private JButton btnPopStack;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		initialize();
		events();
	}
	
	// init of components
	
	public void initialize() {
		setTitle("Rectangle Stack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlForStackText = new JPanel();
		pnlForStackText.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlForStackText);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnPushStack = new JButton("Add To Stack");
		
		btnPopStack = new JButton("Remove From Stack");
		
		JLabel lblPush = new JLabel("Push");
		
		JLabel lblPop = new JLabel("Pop");
		GroupLayout gl_pnlForStackText = new GroupLayout(pnlForStackText);
		gl_pnlForStackText.setHorizontalGroup(
			gl_pnlForStackText.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlForStackText.createSequentialGroup()
					.addGroup(gl_pnlForStackText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlForStackText.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlForStackText.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_pnlForStackText.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnPushStack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnPopStack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(6))
							.addGroup(Alignment.TRAILING, gl_pnlForStackText.createSequentialGroup()
								.addGap(57)
								.addComponent(lblPop, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addGap(40)))
						.addGroup(gl_pnlForStackText.createSequentialGroup()
							.addGap(58)
							.addComponent(lblPush)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		gl_pnlForStackText.setVerticalGroup(
			gl_pnlForStackText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlForStackText.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlForStackText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlForStackText.createSequentialGroup()
							.addComponent(lblPush)
							.addGap(2)
							.addComponent(btnPushStack, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addComponent(lblPop)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPopStack, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(25))
						.addGroup(gl_pnlForStackText.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
		txtRectangle = new JTextArea();
		txtRectangle.setEditable(false);
		scrollPane.setViewportView(txtRectangle);
		pnlForStackText.setLayout(gl_pnlForStackText);
	}
	
	// declaration of events
	public void events() {
		btnPushStack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DlgAddRectangle add = new DlgAddRectangle();
				add.setModal(true);
				add.setVisible(true);
			}
		});
		
		btnPopStack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!DlgAddRectangle.stackRect.isEmpty()) {
					DlgRemoveRectangle remove = new DlgRemoveRectangle();
					remove.setModal(true);
					remove.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Stack is empty.");
				
			}
		});
	}
}
