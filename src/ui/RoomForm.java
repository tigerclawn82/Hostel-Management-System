package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import dao.RoomDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class RoomForm extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField0;
	public JTextField jTextField1;
	private JLabel jLabel0;
	private JLabel jLabel1;
	public JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	private JLabel jLabel2;
	public JButton jButton0;

	public RoomForm() {
		initComponents();
	}

	public void initComponents() {
		setLayout(new GroupLayout());
		add(getJTextField0(), new Constraints(new Leading(118, 116, 10, 10), new Leading(37, 24, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(41, 10, 10), new Leading(41, 12, 12)));
		add(getJTextField1(), new Constraints(new Leading(118, 116, 12, 12), new Leading(75, 24, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(41, 54, 12, 12), new Leading(79, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(117, 115, 10, 10), new Leading(118, 49, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(41, 54, 12, 12), new Leading(125, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(170, 12, 12), new Leading(185, 24, 12, 12)));
		setSize(320, 240);
	}

	public JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Save");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	protected JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
		}
		return jTextField1;
	}

	protected JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
		}
		return jTextField0;
	}

	protected JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Location");
		}
		return jLabel2;
	}

	protected JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTextArea0());
		}
		return jScrollPane0;
	}

	private JTextArea getJTextArea0() {
		if (jTextArea0 == null) {
			jTextArea0 = new JTextArea();
		}
		return jTextArea0;
	}

	protected JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Capacity");
		}
		return jLabel1;
	}

	protected JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Room No.");
		}
		return jLabel0;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		
		try {
			
			if (new RoomDAO().registerRoom(this)) {
				
				JOptionPane.showMessageDialog(null, "ROOM ADDED!");
				
			} else {

				JOptionPane.showMessageDialog(null, "FAILED! CHECK THE FORM AGAIN!");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
