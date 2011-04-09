package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import msg.Error;
import msg.Success;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import utilities.Utilities;

import dao.ServiceDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ServiceForm extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField0;
	public JTextField jTextField1;
	public JComboBox jComboBox0;
	public JComboBox jComboBox1;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton0;
	public ServiceForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJTextField0(), new Constraints(new Leading(125, 111, 10, 10), new Leading(34, 24, 10, 10)));
		add(getJComboBox0(), new Constraints(new Leading(125, 110, 10, 10), new Leading(75, 12, 12)));
		add(getJComboBox1(), new Constraints(new Leading(125, 110, 10, 10), new Leading(118, 12, 12)));
		add(getJTextField1(), new Constraints(new Leading(125, 111, 12, 12), new Leading(161, 24, 12, 12)));
		add(getJLabel0(), new Constraints(new Leading(42, 33, 10, 10), new Leading(38, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(42, 33, 12, 12), new Leading(79, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(42, 73, 10, 10), new Leading(122, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(42, 73, 12, 12), new Leading(165, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(171, 12, 12), new Leading(199, 12, 12)));
		setSize(320, 240);
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("SAVE");
			jButton0.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Charges");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Charge Type");
		}
		return jLabel2;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Type");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Title");
		}
		return jLabel0;
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "Per Month", "Per Semester", "Per Annum"}));
			jComboBox1.setDoubleBuffered(false);
			jComboBox1.setBorder(null);
		}
		return jComboBox1;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "Optional","Mendatory" }));
			jComboBox0.setDoubleBuffered(false);
			jComboBox0.setBorder(null);
		}

		return jComboBox0;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
		}
		return jTextField1;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
		}
		return jTextField0;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		
		if(validateInputs()){
			
			try {

				if (new ServiceDAO().registerService(this)) {

					JOptionPane.showMessageDialog(null, Success.SERVICE_REGSISTRATION_SUCCESS);

				} else {

					JOptionPane.showMessageDialog(null, Error.SERVICE_REGISTRATION_FAILED);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		} else {
			
			// DO NOTHING
		}

	}

	public boolean validateInputs(){

		if(Utilities.isNotEmptyFields(jTextField0,jTextField1)){

			if(Utilities.invalidCharacters(jTextField0,jTextField1)){

				if(Utilities.checkCharacters(jTextField1)){

				} else {

					JOptionPane.showMessageDialog(null, "CHARACTERS NOT ALLOWED IN CHARGES FIELD!!");
					return false;
				}

			} else {

				JOptionPane.showMessageDialog(null, "INVALID CHARACTERS NOT ALLOWED!!");
				return false;
			}

		} else {

			JOptionPane.showMessageDialog(null, "REQUIRED FIEDLS CAN'T BE LEFT BLANK!!");
			return false;
		}

		return true;
	}

}
