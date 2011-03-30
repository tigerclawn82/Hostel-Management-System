package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import utilities.ServiceUtilities;
import dao.BillingRecordDAO;
import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class BillingRecordForm extends JPanel {

	Object[][] data = null;

	private static final long serialVersionUID = 1L;
	public JTextField jTextField0;
	public JTextField jTextField1;
	public JTextField jTextField2;
	private JButton jButton0;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JTable jTable0;
	private JScrollPane jScrollPane0;
	public JCheckBox jCheckBox0;
	private JPanel jPanel0;
	public JTextField jTextField3;
	private JLabel jLabel3;
	public JTextArea jTextArea0;
	private JScrollPane jScrollPane1;
	private JLabel jLabel5;

	private JTextField jTextField4;

	private JLabel jLabel6;

	public BillingRecordForm() {
		initComponents();
		jPanel0.setVisible(false);
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJTextField0(), new Constraints(new Leading(152, 129, 10, 10), new Leading(26, 26, 10, 10)));
		add(getJTextField1(), new Constraints(new Leading(152, 129, 10, 10), new Leading(71, 26, 12, 12)));
		add(getJLabel0(), new Constraints(new Leading(60, 10, 10), new Leading(32, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(60, 58, 10, 10), new Leading(76, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(12, 327, 12, 12), new Leading(136, 108, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(135, 93, 12, 12), new Leading(112, 10, 10)));
		add(getJCheckBox0(), new Constraints(new Leading(125, 10, 10), new Leading(254, 8, 8)));
		add(getJPanel0(), new Constraints(new Leading(39, 272, 12, 12), new Leading(280, 129, 10, 10)));
		add(getJTextField2(), new Constraints(new Leading(160, 129, 10, 10), new Leading(448, 26, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(66, 78, 10, 10), new Leading(455, 10, 10)));
		add(getJTextField4(), new Constraints(new Leading(160, 129, 12, 12), new Leading(415, 26, 50, 50)));
		add(getJLabel6(), new Constraints(new Leading(66, 78, 12, 12), new Leading(420, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(249, 12, 12), new Leading(489, 12, 12)));
		setSize(350, 528);
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("Total Fine");
		}
		return jLabel6;
	}

	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
		}
		return jTextField4;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Description");
		}
		return jLabel5;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTextArea0());
		}
		return jScrollPane1;
	}

	private JTextArea getJTextArea0() {
		if (jTextArea0 == null) {
			jTextArea0 = new JTextArea();
		}
		return jTextArea0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Amount");
		}
		return jLabel3;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					jTextField3FocusFocusLost(event);
				}
			});
		}
		return jTextField3;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Additional Charges", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJScrollPane1(), new Constraints(new Leading(11, 236, 10, 10), new Leading(46, 52, 10, 10)));
			jPanel0.add(getJTextField3(), new Constraints(new Leading(118, 129, 12, 12), new Leading(0, 26, 12, 12)));
			jPanel0.add(getJLabel3(), new Constraints(new Leading(15, 78, 10, 10), new Leading(5, 12, 12)));
			jPanel0.add(getJLabel5(), new Constraints(new Leading(15, 78, 12, 12), new Leading(27, 12, 12)));
		}
		return jPanel0;
	}

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setSelected(false);
			jCheckBox0.setText("Additional");
			jCheckBox0.addItemListener(new ItemListener() {
	
				public void itemStateChanged(ItemEvent event) {
					jCheckBox0ItemItemStateChanged(event);
				}
			});
		}
		return jCheckBox0;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTable0());
		}
		return jScrollPane0;
	}

	private JTable getJTable0() {
		if (jTable0 == null) {
			jTable0 = new JTable();
			jTable0.setModel(new DefaultTableModel(new Object[][] { { "", "", }, { "", "", }, }, new String[] { "Service", "Amount", }) {
				
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
				
			});
		}
		return jTable0;
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
			jLabel4.setText("Total Amount");
		}
		return jLabel4;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Amount Detail");
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
			jTextField2.setEditable(false);
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

			if (new BillingRecordDAO().addBillingRecord(this)) {

				JOptionPane.showMessageDialog(null, "BILLING RECORED ADDED!");

			} else {

				JOptionPane.showMessageDialog(null, "FAILED! CHECK THE FORM AGAIN!");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void studentRecordSearch() {

		try {

			if (new StudentDAO().isStudentIDExist(jTextField0.getText())) {

				JOptionPane.showMessageDialog(null, "STUDENT ID EXIST!");
				data = ServiceUtilities.servicesWithAmount(jTextField0.getText());
				jTextField4.setText(String.valueOf(ServiceUtilities.getFineOfStudent(jTextField0.getText())));
				
				jTextField2.setText(String.valueOf(getTotalAmount()));
				
				jTable0.setModel(new DefaultTableModel(data, new String[] { "Service", "Amount", }) {
					
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
										
				});

			} else {

				JOptionPane.showMessageDialog(null, "STUDENT ID DOESN'T EXIST!");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void jCheckBox0ItemItemStateChanged(ItemEvent event) {

		if (jCheckBox0.isSelected()) {

			jPanel0.setVisible(true);
			
			if (!jTextField3.getText().equals("")) {
				
				jTextField2.setText(String.valueOf((Integer.parseInt(jTextField3.getText()) + getTotalAmount())));
				
			} else {
				
				jTextField3.setText(String.valueOf(0));
				
			}
			

		} else {

			jPanel0.setVisible(false);
			jTextField2.setText(String.valueOf(getTotalAmount()));

		}

	}

	private void jTextField3FocusFocusLost(FocusEvent event) {

		if (jTextField3.getText().equals("")) {

			jTextField3.setText(String.valueOf(0));
			jTextField2.setText(String.valueOf(getTotalAmount()));

		} else {

			jTextField2.setText(String.valueOf((Integer.parseInt(jTextField3.getText()) + getTotalAmount())));

		}

	}

	public int getTotalAmount() {

		int totalAmount = 0;

		if (data!=null) {
			
			if (data.length>0) {
				
				for (int i = 0; i < data.length; i++) {

					totalAmount += Double.parseDouble(data[i][1].toString());

				}
				
			}
			
		}

		totalAmount += Integer.parseInt(jTextField4.getText());
		return totalAmount;
	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {
		
		studentRecordSearch();
		
	}

}
