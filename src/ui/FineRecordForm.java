package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import dao.FineRecordDAO;
import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class FineRecordForm extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField0;
	public JTextField jTextField1;
	public JTextField jTextField2;
	private JButton jButton0;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	public JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	private JPanel jPanel0;
	private JButton jButton1;
	private JLabel jLabel3;
	private boolean studentExist = true;

	public FineRecordForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Bilateral(12, 12, 287), new Leading(75, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(20, 10, 10), new Leading(29, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(269, 10, 10), new Leading(326, 12, 12)));
		add(getJButton1(), new Constraints(new Trailing(12, 120, 120), new Leading(24, 10, 321)));
		add(getJTextField0(), new Constraints(new Leading(99, 129, 10, 10), new Leading(24, 26, 10, 321)));
		add(getJLabel3(), new Constraints(new Leading(237, 58, 10, 10), new Leading(29, 12, 12)));
		setSize(350, 371);
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
		}
		return jLabel3;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Check");
			jButton1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Fine Detail", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJTextField1(), new Constraints(new Leading(136, 129, 10, 10), new Leading(13, 26, 10, 148)));
			jPanel0.add(getJLabel2(), new Constraints(new Leading(30, 58, 10, 10), new Leading(90, 16, 10, 101)));
			jPanel0.add(getJLabel1(), new Constraints(new Leading(28, 58, 10, 10), new Leading(18, 12, 12)));
			jPanel0.add(getJLabel4(), new Constraints(new Leading(30, 58, 10, 10), new Leading(161, 16, 10, 30)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Leading(135, 130, 10, 51), new Leading(58, 80, 10, 10)));
			jPanel0.add(getJTextField2(), new Constraints(new Leading(136, 129, 12, 12), new Leading(156, 26, 12, 12)));
		}
		return jPanel0;
	}

	private JScrollPane getJScrollPane0() {
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

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jTextField0ActionActionPerformed(event);
				}
			});
		}
		return jTextField0;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Charges");
		}
		return jLabel4;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Reason");
		}
		return jLabel2;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Date");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Student ID");
		}
		return jLabel0;
	}

	private JButton getJButton0() {
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

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
		}
		return jTextField2;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			try {

				jTextField1 = new JFormattedTextField(new MaskFormatter("##/##/####"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return jTextField1;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		try {

			if (new FineRecordDAO().addFineRecord(this)) {

				JOptionPane.showMessageDialog(null, "FINE RECORED ADDED!");

			} else {

				JOptionPane.showMessageDialog(null, "FAILED! CHECK THE FORM AGAIN!");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public boolean studentIDCheck() {

		studentExist = StudentDAO.isStudentIDExist(jTextField0.getText());

		try {

			if (studentExist) {

				JOptionPane.showMessageDialog(null, "STUDENT ID EXIST!");
				jLabel3.setIcon(new ImageIcon(getClass().getResource("/images/tick.png")));
				return true;

			} else {

				JOptionPane.showMessageDialog(null, "STUDENT ID DOESN'T EXIST!");
				jLabel3.setIcon(new ImageIcon(getClass().getResource("/images/cross.png")));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return false;
	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {
		
		studentIDCheck();
		
	}

	private void jButton1MouseMouseClicked(MouseEvent event) {
		
		studentIDCheck();
		
	}

}
