package guiSort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private JButton btnAddRect;
	private JButton btnRemoveRect;
	private JList<Rectangle> listRect;
	private static DefaultListModel<Rectangle> dlm = new DefaultListModel<>();
	private Rectangle selected = new Rectangle();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		initialize();
		events();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollRect = new JScrollPane();
		
		btnAddRect = new JButton("Add Rectangle");
		
		btnRemoveRect = new JButton("Remove Rectangle");
		
		btnRemoveRect.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollRect, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAddRect, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
							.addComponent(btnRemoveRect)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollRect, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddRect)
						.addComponent(btnRemoveRect))
					.addContainerGap())
		);
		
		listRect = new JList<Rectangle>();
		scrollRect.setViewportView(listRect);
		listRect.setModel(dlm);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void events() {
		btnAddRect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DlgAddRectangleSort addRect = new DlgAddRectangleSort();
				addRect.setModal(true);
				addRect.setVisible(true);
			}
		});
		
		listRect.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnRemoveRect.setVisible(true);
				selected = listRect.getSelectedValue();
				
			}
		});
		
		btnRemoveRect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DlgAddRectangleSort.rectList.remove(selected);
				showList();
				btnRemoveRect.setVisible(false);
				
			}
		});
	}
	
	public static void showList() {
		if(!DlgAddRectangleSort.rectList.isEmpty()) {
			Collections.sort(DlgAddRectangleSort.rectList, new Comparator<Rectangle>() {
				
				@Override
				public int compare(Rectangle r1, Rectangle r2) {
					return r1.area() - r2.area();
				}
				
			});
			
			dlm.removeAllElements();
			Iterator<Rectangle> it = DlgAddRectangleSort.rectList.iterator();
			while(it.hasNext()) {
				dlm.addElement(it.next());
			}
		}
		else {
			dlm.removeAllElements();
		}
	}
}
