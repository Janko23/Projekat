package guiSort;

import geometry.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

public class DlgAddRectangleSort extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUpperLeftXSort;
	private JTextField txtUpperLeftYSort;
	private JTextField txtWidthSort;
	private JTextField txtHeightSort;
	private JButton btnAddRectangleSort;
	
	public static List<Rectangle> rectList = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAddRectangleSort dialog = new DlgAddRectangleSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAddRectangleSort() {
		initialize();
		events();
	}
	
	public void initialize() {
		setBounds(100, 100, 405, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		txtUpperLeftXSort = new JTextField();
		txtUpperLeftXSort.setColumns(10);
		
		txtUpperLeftYSort = new JTextField();
		txtUpperLeftYSort.setColumns(10);
		
		txtWidthSort = new JTextField();
		txtWidthSort.setColumns(10);
		
		txtHeightSort = new JTextField();
		txtHeightSort.setColumns(10);
		
		JLabel lblUpperLeftXSort = new JLabel("Upper Left X");
		
		JLabel lblUpperLeftYSort = new JLabel("Upper Left Y");
		
		JLabel lblWidthSort = new JLabel("Width");
		
		JLabel lblHeightSort = new JLabel("Height");
		
		btnAddRectangleSort = new JButton("Add");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUpperLeftXSort)
						.addComponent(lblUpperLeftYSort)
						.addComponent(lblWidthSort)
						.addComponent(lblHeightSort))
					.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtHeightSort)
						.addComponent(txtWidthSort)
						.addComponent(txtUpperLeftYSort)
						.addComponent(txtUpperLeftXSort)
						.addComponent(btnAddRectangleSort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(58))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUpperLeftXSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpperLeftXSort))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUpperLeftYSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpperLeftYSort))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtWidthSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWidthSort))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHeightSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeightSort))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnAddRectangleSort))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	public void events() {
		btnAddRectangleSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if((Integer.parseInt(txtHeightSort.getText())) > 0 & (Integer.parseInt(txtWidthSort.getText())) > 0){
						rectList.add(new Rectangle(new Point(Integer.parseInt(txtUpperLeftXSort.getText()), 
								Integer.parseInt(txtUpperLeftYSort.getText())),
								Integer.parseInt(txtWidthSort.getText()),
								Integer.parseInt(txtHeightSort.getText()) ));
						
						FrmSort.showList();
						dispose();
						
					}
					else
						JOptionPane.showMessageDialog(null, "Values of height and width must be greater than 0.");
				} catch(NumberFormatException ne) {
					JOptionPane.showMessageDialog(null, "Values must be whole numbers.");
				} catch(Exception ne) {
					JOptionPane.showMessageDialog(null, "Error!");
					dispose();
				}
				
			}
		});
	}
}
