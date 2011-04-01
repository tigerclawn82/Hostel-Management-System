package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.jdesktop.swingx.JXDatePicker;

import utilities.Utilities;

import dao.MessRecordDAO;
import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MessRecordForm extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField0;
	public JTextField jTextField1;
	public JComboBox jComboBox0;
	public JComboBox jComboBox1;
	public JTextField jTextField2;
	private JButton jButton0;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	public JXDatePicker datePicker;

	public MessRecordForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJTextField0(), new Constraints(new Leading(152, 129, 10, 10), new Leading(26, 26, 10, 10)));
		add(getDatePicker(), new Constraints(new Leading(152, 129, 10, 10), new Leading(71, 26, 12, 12)));
		add(getJComboBox0(), new Constraints(new Leading(152, 128, 10, 10), new Leading(115, 12, 12)));
		add(getJComboBox1(), new Constraints(new Leading(152, 128, 10, 10), new Leading(158, 12, 12)));
		add(getJTextField2(), new Constraints(new Leading(152, 129, 10, 10), new Leading(201, 26, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(219, 10, 10), new Leading(250, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(60, 10, 10), new Leading(32, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(60, 58, 10, 10), new Leading(76, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(60, 58, 10, 10), new Leading(119, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(60, 58, 10, 10), new Leading(162, 12, 12)));
		add(getJLabel4(), new Constraints(new Leading(60, 58, 10, 10), new Leading(206, 12, 12)));
		setSize(350, 300);
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

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Status");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Type");
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
			jTextField2 = new JFormattedTextField(NumberFormat.getInstance());
		}
		
		return jTextField2;
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "Open", "Close",}));
			jComboBox1.setDoubleBuffered(false);
			jComboBox1.setBorder(null);
		}
		return jComboBox1;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "Breakfast", "Lunch", "Dinner", }));
			jComboBox0.setDoubleBuffered(false);
			jComboBox0.setBorder(null);
		}
		return jComboBox0;
	}

	private JXDatePicker getDatePicker() {
		if (datePicker == null) {
			datePicker = new JXDatePicker(new Date());
		}
		return datePicker;
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

		jTextField1.setVisible(false);

		return jTextField1;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		if(Utilities.isNotEmptyFields(jTextField0,jTextField2)){

			try {

				if (new MessRecordDAO().addMessRecord(this)) {

					JOptionPane.showMessageDialog(null, "MESS RECORED ADDED!");

				} else {

					JOptionPane.showMessageDialog(null, "FAILED! CHECK THE FORM AGAIN!");

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {

			JOptionPane.showMessageDialog(null, "Required Fields Cannot Be Left Blank!!");

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
