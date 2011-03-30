package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class LoginForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextField0;
	private JLabel jLabel0;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JButton jButton0;

	public LoginForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJTextField0(), new Constraints(new Leading(161, 161, 10, 10), new Leading(205, 36, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(68, 10, 10), new Leading(215, 10, 10)));
		add(getJTextField1(), new Constraints(new Leading(161, 161, 10, 10), new Leading(259, 36, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(68, 59, 10, 10), new Leading(269, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(257, 10, 10), new Leading(326, 10, 10)));
		setSize(400, 400);
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setBorder(new LineBorder(new Color(128, 128, 0), 2, true));
		}
		return jTextField0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Login");
		}
		return jButton0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Password");
		}
		return jLabel1;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBorder(new LineBorder(new Color(128, 128, 0), 5, true));
		}
		return jTextField1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Username");
		}
		return jLabel0;
	}

}
