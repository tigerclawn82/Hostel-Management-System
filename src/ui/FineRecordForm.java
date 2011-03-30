package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

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

	public FineRecordForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJTextField0(), new Constraints(new Leading(152, 129, 10, 10), new Leading(26, 26, 10, 10)));
		add(getJTextField1(), new Constraints(new Leading(152, 129, 10, 10), new Leading(71, 26, 12, 12)));
		add(getJTextField2(), new Constraints(new Leading(152, 129, 10, 10), new Leading(201, 26, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(219, 10, 10), new Leading(250, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(60, 10, 10), new Leading(32, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(60, 58, 10, 10), new Leading(76, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(60, 58, 10, 10), new Leading(119, 12, 12)));
		add(getJLabel4(), new Constraints(new Leading(60, 58, 10, 10), new Leading(206, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(151, 130, 12, 12), new Leading(114, 80, 12, 12)));
		setSize(350, 300);
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

	public void studentIDCheck() {


		try {

			if (new StudentDAO().isStudentIDExist(jTextField0.getText())) {

				JOptionPane.showMessageDialog(null, "STUDENT ID EXIST!");

			} else {

				JOptionPane.showMessageDialog(null, "STUDENT ID DOESN'T EXIST!");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {
		
		studentIDCheck();
		
	}

}
