package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;
import org.jdesktop.swingx.JXDatePicker;

import utilities.StudentSearchUtilities;
import utilities.Utilities;
import bean.Qualification;
import bean.Student;
import dao.RoomDAO;
import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class UpdateStudentForm extends JPanel {

	/*
	 * FOR STUDENT INFORMATION
	 */
	
	public Student student = null;
	public List<Qualification> qualificationData = null;
	public String[] serviceTitle = null;

	/*
	 * MULTIPLE ID'S IF SEARCH BY NAME OR FATHER NAME
	 */
	public Object[] studentID = null;

	/*
	 * INDEX OF THE VALUE TO UPDATE FOR QUALIFICATION
	 */
	int updateIndex = 0;

	public final String[] QUALIFICATION_COLUMN = { "TITLE", "INSTITUTE","YEAR OF PASSING","PERCENTAGE" };

	/*
	 * SWING COMPONENTS
	 */

	private static final long serialVersionUID = 1L;
	private JPanel jPanel0;
	public JTextField jTextField0;
	public JTextField jTextField1;
	public JTextField jTextField2;
	public JTextField jTextField3;
	public JTextField jTextField5;
	public JTextField jTextField6;
	public JTextField jTextField8;
	public JTextField jTextField9;
	public JTextField jTextField10;
	public JTextField jTextField11;
	public JTextField jTextField12;
	public JTextField jTextField13;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;
	public JComboBox jComboBox0;
	public JComboBox jComboBox1;
	private JButton jButton0;
	private JPanel jPanel1;
	public JTextField jTextField4;
	public JTextField jTextField7;
	public JTextField jTextField14;
	public JTextField jTextField15;
	public JTextField jTextField16;
	public JTextField jTextField17;
	private JTable jTable0;
	private JScrollPane jScrollPane0;
	private JLabel jLabel14;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel17;
	private JLabel jLabel18;
	private JLabel jLabel19;
	private JPanel jPanel2;
	public JCheckBox jCheckBox0;
	public JCheckBox jCheckBox1;
	private JLabel jLabel20;
	public JCheckBox jCheckBox2;
	public JCheckBox jCheckBox3;
	private JLabel jLabel21;
	private JCheckBox jCheckBox4;
	private JCheckBox jCheckBox5;
	private ButtonGroup buttonGroup1;
	private JLabel jLabel22;
	private JTextField jTextField18;
	private JTextField jTextField19;
	private JButton jButton1;
	private JCheckBox jCheckBox6;
	private JCheckBox jCheckBox7;
	private JPanel jPanel3;
	private JSpinner jSpinner0;
	private JLabel jLabel23;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	public JXDatePicker datePicker;
	public JComboBox jComboBox2;

	public UpdateStudentForm() {

		qualificationData = new ArrayList<Qualification>();
		initComponents();

		if (jCheckBox6.isSelected() || jCheckBox7.isSelected()) {

			showPager();

		} else {

			hidePager();

		}

	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel2(), new Constraints(new Leading(12, 12, 12), new Leading(797, 100, 12, 12)));
		add(getJPanel1(), new Constraints(new Leading(12, 576, 12, 12), new Leading(432, 347, 12, 12)));
		add(getJPanel0(), new Constraints(new Leading(14, 576, 10, 10), new Leading(88, 332, 12, 12)));
		add(getJPanel3(), new Constraints(new Leading(15, 574, 12, 12), new Leading(14, 62, 12, 12)));
		add(getJButton1(), new Constraints(new Leading(255, 10, 10), new Leading(907, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(373, 10, 10), new Leading(907, 10, 10)));
		add(getJButton4(), new Constraints(new Leading(466, 10, 10), new Leading(907, 10, 10)));
		initButtonGroup1();
		setSize(600, 950);
	}

	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			Object[] availableRoomNOS = null;

			try {

				availableRoomNOS = new RoomDAO().availableRoomNOS();
				jComboBox2.setModel(new DefaultComboBoxModel(availableRoomNOS));

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			jComboBox2.setDoubleBuffered(false);
			jComboBox2.setBorder(null);
		}
		return jComboBox2;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("Update Record");
			jButton4.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton4MouseMouseClicked(event);
				}
			});
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Update");
			jButton3.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton3MouseMouseClicked(event);
				}
			});
		}
		return jButton3;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Add New");
			jButton2.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton2MouseMouseClicked(event);
				}
			});
		}
		return jButton2;
	}

	private JLabel getJLabel23() {
		if (jLabel23 == null) {
			jLabel23 = new JLabel();
			jLabel23.setText("Goto");
		}
		return jLabel23;
	}

	private JSpinner getJSpinner0() {
		if (jSpinner0 == null) {
			jSpinner0 = new JSpinner();
			jSpinner0.setModel(new SpinnerNumberModel(1, 1, 10, 1));
			jSpinner0.addChangeListener(new ChangeListener() {

				public void stateChanged(ChangeEvent event) {
					jSpinner0ChangeStateChanged(event);
				}
			});
		}
		return jSpinner0;
	}

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Search By", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel3.setLayout(new GroupLayout());
			jPanel3.add(getJSpinner0(), new Constraints(new Trailing(12, 41, 423, 448), new Leading(7, 20, 10, 9)));
			jPanel3.add(getJCheckBox4(), new Constraints(new Leading(36, 93, 10, 10), new Leading(5, 8, 8)));
			jPanel3.add(getJCheckBox5(), new Constraints(new Leading(140, 93, 10, 10), new Leading(5, 8, 8)));
			jPanel3.add(getJCheckBox6(), new Constraints(new Leading(230, 62, 10, 10), new Leading(5, 8, 8)));
			jPanel3.add(getJCheckBox7(), new Constraints(new Leading(323, 122, 10, 10), new Leading(5, 8, 8)));
			jPanel3.add(getJLabel23(), new Constraints(new Trailing(20, 26, 10, 518), new Leading(-11, 10, 10)));
		}
		return jPanel3;
	}

	private JCheckBox getJCheckBox7() {
		if (jCheckBox7 == null) {
			jCheckBox7 = new JCheckBox();
			jCheckBox7.setSelected(true);
			jCheckBox7.setText("Father Name");
			jCheckBox7.addItemListener(new ItemListener() {
	
				public void itemStateChanged(ItemEvent event) {
					jCheckBox7ItemItemStateChanged(event);
				}
			});
		}
		return jCheckBox7;
	}

	private JCheckBox getJCheckBox6() {
		if (jCheckBox6 == null) {
			jCheckBox6 = new JCheckBox();
			jCheckBox6.setText("Name");
			jCheckBox6.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent event) {
					jCheckBox6ItemItemStateChanged(event);
				}
			});
		}
		return jCheckBox6;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Clear Fields");
			jButton1.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}

	private JTextField getJTextField19() {
		if (jTextField19 == null) {
			jTextField19 = new JTextField();
		}
		return jTextField19;
	}

	private JTextField getJTextField18() {
		if (jTextField18 == null) {
			jTextField18 = new JTextField();
		}
		return jTextField18;
	}

	private JLabel getJLabel22() {
		if (jLabel22 == null) {
			jLabel22 = new JLabel();
			jLabel22.setText("* Click the row and update value in the above Fields !");
		}
		return jLabel22;
	}

	private void initButtonGroup1() {
		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(getJCheckBox4());
		buttonGroup1.add(getJCheckBox5());
		buttonGroup1.add(getJCheckBox6());
		buttonGroup1.add(getJCheckBox7());
	}

	private JCheckBox getJCheckBox5() {
		if (jCheckBox5 == null) {
			jCheckBox5 = new JCheckBox();
			jCheckBox5.setText("NIC No.");
		}
		return jCheckBox5;
	}

	private JCheckBox getJCheckBox4() {
		if (jCheckBox4 == null) {
			jCheckBox4 = new JCheckBox();
			jCheckBox4.setText("Student ID");
		}
		return jCheckBox4;
	}

	private JLabel getJLabel21() {
		if (jLabel21 == null) {
			jLabel21 = new JLabel();
			jLabel21.setText("Room No.");
		}
		return jLabel21;
	}

	private JCheckBox getJCheckBox3() {
		if (jCheckBox3 == null) {
			jCheckBox3 = new JCheckBox();
			jCheckBox3.setSelected(true);
			jCheckBox3.setText("Electricity");
			jCheckBox3.addChangeListener(new ChangeListener() {

				public void stateChanged(ChangeEvent event) {
					jCheckBox3ChangeStateChanged(event);
				}
			});
		}
		return jCheckBox3;
	}

	private JCheckBox getJCheckBox2() {
		if (jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			jCheckBox2.setSelected(true);
			jCheckBox2.setText("Gas");
			jCheckBox2.addChangeListener(new ChangeListener() {

				public void stateChanged(ChangeEvent event) {
					jCheckBox2ChangeStateChanged(event);
				}
			});
		}
		return jCheckBox2;
	}

	private JLabel getJLabel20() {
		if (jLabel20 == null) {
			jLabel20 = new JLabel();
			jLabel20.setText("Pre-Selected");
		}
		return jLabel20;
	}

	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setText("Internet");
		}
		return jCheckBox1;
	}

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setSelected(true);
			jCheckBox0.setText("Mess");
		}
		return jCheckBox0;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Register Services", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel2.setEnabled(false);
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getJCheckBox0(), new Constraints(new Leading(17, 10, 10), new Leading(21, 10, 10)));
			jPanel2.add(getJCheckBox1(), new Constraints(new Leading(118, 78, 10, 10), new Leading(21, 8, 8)));
			jPanel2.add(getJLabel20(), new Constraints(new Leading(400, 12, 12), new Leading(-6, 40, 40)));
			jPanel2.add(getJCheckBox2(), new Constraints(new Leading(413, 56, 10, 10), new Leading(21, 36, 36)));
			jPanel2.add(getJCheckBox3(), new Constraints(new Leading(413, 84, 8, 8), new Trailing(8, 49, 49)));
			jPanel2.add(getJLabel21(), new Constraints(new Leading(235, 12, 12), new Leading(-6, 12, 12)));
			jPanel2.add(getJComboBox2(), new Constraints(new Leading(232, 60, 10, 274), new Leading(22, 12, 12)));
		}
		return jPanel2;
	}

	private JLabel getJLabel19() {
		if (jLabel19 == null) {
			jLabel19 = new JLabel();
			jLabel19.setText("Obt. Marks");
		}
		return jLabel19;
	}

	private JLabel getJLabel18() {
		if (jLabel18 == null) {
			jLabel18 = new JLabel();
			jLabel18.setText("Total Marks");
		}
		return jLabel18;
	}

	private JLabel getJLabel17() {
		if (jLabel17 == null) {
			jLabel17 = new JLabel();
			jLabel17.setText("Passing Year");
		}
		return jLabel17;
	}

	private JLabel getJLabel16() {
		if (jLabel16 == null) {
			jLabel16 = new JLabel();
			jLabel16.setText("Duration");
		}
		return jLabel16;
	}

	private JLabel getJLabel15() {
		if (jLabel15 == null) {
			jLabel15 = new JLabel();
			jLabel15.setText("Institute");
		}
		return jLabel15;
	}

	private JLabel getJLabel14() {
		if (jLabel14 == null) {
			jLabel14 = new JLabel();
			jLabel14.setText("Title");
		}
		return jLabel14;
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
			jTable0.setModel(new DefaultTableModel(new Object[][] { { "", "", null, null, }, { "", "", null, null, }, }, new String[] { "TITLE",
					"INSTITUTE", "YEAR OF PASSING", "PERCENTAGE", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, Object.class, Object.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}

				@Override
				public boolean isCellEditable(int arg0, int arg1) {
					// TODO Auto-generated method stub
					return false;
				}

			});
			jTable0.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTable0MouseMouseClicked(event);
				}
			});
		}
		return jTable0;
	}

	private JTextField getJTextField17() {
		if (jTextField17 == null) {
			jTextField17 = new JTextField();
		}
		return jTextField17;
	}

	private JTextField getJTextField16() {
		if (jTextField16 == null) {
			jTextField16 = new JTextField();
		}
		return jTextField16;
	}

	private JTextField getJTextField15() {
		if (jTextField15 == null) {
			jTextField15 = new JTextField();
		}
		return jTextField15;
	}

	private JTextField getJTextField14() {
		if (jTextField14 == null) {

			try {

				jTextField14 = new JFormattedTextField(new MaskFormatter("#"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return jTextField14;
	}

	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
		}
		return jTextField7;
	}

	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
		}
		return jTextField4;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Educational Information", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font(
					"Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJTextField4(), new Constraints(new Leading(117, 134, 10, 10), new Leading(12, 23, 12, 12)));
			jPanel1.add(getJTextField7(), new Constraints(new Leading(117, 134, 12, 12), new Leading(52, 23, 12, 12)));
			jPanel1.add(getJTextField14(), new Constraints(new Leading(117, 134, 12, 12), new Leading(93, 23, 12, 12)));
			jPanel1.add(getJTextField15(), new Constraints(new Leading(398, 134, 10, 10), new Leading(12, 23, 12, 12)));
			jPanel1.add(getJTextField16(), new Constraints(new Leading(398, 134, 12, 12), new Leading(53, 23, 12, 12)));
			jPanel1.add(getJTextField17(), new Constraints(new Leading(398, 134, 12, 12), new Leading(93, 23, 12, 12)));
			jPanel1.add(getJScrollPane0(), new Constraints(new Leading(12, 543, 12, 12), new Trailing(12, 129, 121, 128)));
			jPanel1.add(getJLabel14(), new Constraints(new Leading(25, 58, 12, 12), new Leading(15, 50, 153)));
			jPanel1.add(getJLabel15(), new Constraints(new Leading(25, 58, 12, 12), new Leading(55, 50, 153)));
			jPanel1.add(getJLabel16(), new Constraints(new Leading(25, 58, 12, 12), new Leading(96, 50, 153)));
			jPanel1.add(getJLabel17(), new Constraints(new Leading(310, 76, 12, 12), new Leading(15, 50, 153)));
			jPanel1.add(getJLabel18(), new Constraints(new Leading(310, 68, 10, 10), new Leading(56, 50, 153)));
			jPanel1.add(getJLabel19(), new Constraints(new Leading(310, 92, 10, 10), new Leading(96, 50, 153)));
			jPanel1.add(getJLabel22(), new Constraints(new Leading(12, 301, 10, 10), new Trailing(159, 124, 128)));
			jPanel1.add(getJButton2(), new Constraints(new Leading(375, 10, 10), new Trailing(154, 124, 128)));
			jPanel1.add(getJButton3(), new Constraints(new Trailing(12, 471, 471), new Trailing(154, 121, 128)));
		}
		return jPanel1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Search");
			jButton0.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new Object[] { "O +", "O -", "A +", "A -", "B +", "B -", "AB +", "AB -" }));
			jComboBox1.setDoubleBuffered(false);
		}
		return jComboBox1;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "MALE","FEMALE" }));
			jComboBox0.setDoubleBuffered(false);
		}
		return jComboBox0;
	}

	private JLabel getJLabel13() {
		if (jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("E-Mail");
		}
		return jLabel13;
	}

	private JLabel getJLabel12() {
		if (jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("Country");
		}
		return jLabel12;
	}

	private JLabel getJLabel11() {
		if (jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("Address");
		}
		return jLabel11;
	}

	private JLabel getJLabel10() {
		if (jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("Occupation");
		}
		return jLabel10;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("Father's No.");
		}
		return jLabel9;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Mobile No.");
		}
		return jLabel8;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Blood Group");
		}
		return jLabel7;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("NIC No.");
		}
		return jLabel6;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Date of Birth");
		}
		return jLabel5;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Gender");
		}
		return jLabel4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Age");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Father Name");
		}
		return jLabel2;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Name");
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

	private JTextField getJTextField13() {
		if (jTextField13 == null) {
			jTextField13 = new JTextField();
		}
		return jTextField13;
	}

	private JTextField getJTextField12() {
		if (jTextField12 == null) {
			jTextField12 = new JTextField();
		}
		return jTextField12;
	}

	private JTextField getJTextField11() {
		if (jTextField11 == null) {
			jTextField11 = new JTextField();
		}
		return jTextField11;
	}

	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
		}
		return jTextField10;
	}

	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			try {

				jTextField9 = new JFormattedTextField(new MaskFormatter("####-#######"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jTextField9;
	}

	private JTextField getJTextField8() {
		if (jTextField8 == null) {

			try {

				jTextField8 = new JFormattedTextField(new MaskFormatter("####-#######"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return jTextField8;
	}

	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			try {

				jTextField6 = new JFormattedTextField(new MaskFormatter("#####-#######-#"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jTextField6.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					jTextField6ActionActionPerformed(event);
				}
			});
		}
		return jTextField6;
	}

	private JTextField getJTextField5() {

		if (jTextField5 == null) {

			try {

				jTextField5 = new JFormattedTextField(new MaskFormatter("##/##/####"));
				jTextField5.setVisible(false);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return jTextField5;
	}

	private JXDatePicker getDatePicker() {
		if (datePicker == null) {
			datePicker = new JXDatePicker(new Date());
		}
		return datePicker;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			try {

				jTextField3 = new JFormattedTextField(new MaskFormatter("##"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jTextField3;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					jTextField2ActionActionPerformed(event);
				}
			});
		}
		return jTextField2;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					jTextField1ActionActionPerformed(event);
				}
			});
		}
		return jTextField1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font(
					"Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJTextField0(), new Constraints(new Leading(117, 134, 10, 10), new Leading(15, 23, 10, 10)));
			jPanel0.add(getJTextField1(), new Constraints(new Leading(117, 134, 12, 12), new Leading(54, 23, 10, 10)));
			jPanel0.add(getJTextField2(), new Constraints(new Leading(117, 134, 12, 12), new Leading(95, 23, 12, 12)));
			jPanel0.add(getJTextField3(), new Constraints(new Leading(117, 134, 12, 12), new Leading(136, 23, 12, 12)));
			jPanel0.add(getJTextField19(), new Constraints(new Leading(117, 134, 12, 12), new Leading(177, 23, 12, 12)));
			jPanel0.add(getJComboBox0(), new Constraints(new Leading(117, 134, 12, 12), new Leading(177, 23, 12, 12)));
			//jPanel0.add(getJTextField5(), new Constraints(new Leading(117, 134, 12, 12), new Leading(218, 23, 12, 12)));
			jPanel0.add(getDatePicker(), new Constraints(new Leading(117, 134, 12, 12), new Leading(218, 23, 12, 12)));
			jPanel0.add(getJTextField6(), new Constraints(new Leading(117, 134, 12, 12), new Leading(259, 23, 12, 12)));
			jPanel0.add(getJTextField18(), new Constraints(new Leading(398, 134, 10, 10), new Leading(17, 23, 10, 10)));
			jPanel0.add(getJComboBox1(), new Constraints(new Leading(398, 134, 10, 10), new Leading(17, 23, 10, 10)));
			jPanel0.add(getJTextField8(), new Constraints(new Leading(398, 134, 12, 12), new Leading(58, 23, 12, 12)));
			jPanel0.add(getJTextField9(), new Constraints(new Leading(398, 134, 12, 12), new Leading(95, 23, 12, 12)));
			jPanel0.add(getJTextField10(), new Constraints(new Leading(398, 134, 12, 12), new Leading(136, 23, 12, 12)));
			jPanel0.add(getJTextField11(), new Constraints(new Leading(398, 134, 12, 12), new Leading(177, 23, 12, 12)));
			jPanel0.add(getJTextField12(), new Constraints(new Leading(398, 134, 12, 12), new Leading(218, 23, 12, 12)));
			jPanel0.add(getJTextField13(), new Constraints(new Leading(398, 134, 12, 12), new Leading(259, 23, 12, 12)));
			jPanel0.add(getJLabel0(), new Constraints(new Leading(25, 10, 10), new Leading(20, 12, 12)));
			jPanel0.add(getJLabel1(), new Constraints(new Leading(25, 58, 12, 12), new Leading(57, 12, 12)));
			jPanel0.add(getJLabel3(), new Constraints(new Leading(25, 58, 12, 12), new Leading(139, 12, 12)));
			jPanel0.add(getJLabel4(), new Constraints(new Leading(25, 58, 12, 12), new Leading(180, 12, 12)));
			jPanel0.add(getJLabel6(), new Constraints(new Leading(25, 58, 12, 12), new Leading(262, 12, 12)));
			jPanel0.add(getJLabel8(), new Constraints(new Leading(310, 12, 12), new Leading(61, 12, 12)));
			jPanel0.add(getJLabel11(), new Constraints(new Leading(310, 58, 12, 12), new Leading(180, 12, 12)));
			jPanel0.add(getJLabel12(), new Constraints(new Leading(310, 58, 12, 12), new Leading(221, 12, 12)));
			jPanel0.add(getJLabel13(), new Constraints(new Leading(310, 58, 12, 12), new Leading(262, 12, 12)));
			jPanel0.add(getJLabel2(), new Constraints(new Leading(25, 76, 10, 10), new Leading(98, 12, 12)));
			jPanel0.add(getJLabel5(), new Constraints(new Leading(25, 74, 12, 12), new Leading(221, 12, 12)));
			jPanel0.add(getJLabel9(), new Constraints(new Leading(310, 88, 10, 10), new Leading(98, 12, 12)));
			jPanel0.add(getJLabel7(), new Constraints(new Leading(310, 70, 12, 12), new Leading(20, 12, 12)));
			jPanel0.add(getJLabel10(), new Constraints(new Leading(310, 88, 12, 12), new Leading(139, 12, 12)));
		}
		return jPanel0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {

			try {
				jTextField0 = new JFormattedTextField(new MaskFormatter("###-UUUU-####"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

			jTextField0.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					jTextField0ActionActionPerformed(event);
				}
			});
		}
		return jTextField0;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		processSearch();

	}

	public void processSearch() {

		if (jCheckBox4.isSelected()) {

			if (jTextField0.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "SORRY! STUDENT ID NOT ENTERED!");

			} else {

				searchByID();

			}

		} else if (jCheckBox5.isSelected()) {

			if (jTextField6.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "SORRY! STUDENT NIC NO. NOT ENTERED!");

			} else {

				searchByNIC();

			}

		} else if (jCheckBox6.isSelected()) {

			if (jTextField1.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "SORRY! STUDENT NAME NOT ENTERED!");

			} else {

				searchByName();

			}

		} else if (jCheckBox7.isSelected()) {

			if (jTextField2.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "SORRY! FATHER NAME NOT ENTERED!");

			} else {

				searchByFatherName();

			}

		} else {

			JOptionPane.showMessageDialog(null, "PLEASE SELECT SEARCH CRITERIA!");

		}

	}

	public boolean validSelectionForSimpleSearch() {

		int count = 0;

		if (!jTextField0.getText().equals("")) {

			count++;

		}

		if (!jTextField1.getText().equals("")) {

			count++;

		}

		if (!jTextField2.getText().equals("")) {

			count++;

		}

		if (!jTextField6.getText().contains(" ") && jTextField6.getText().length()==15) {

			count++;

		}

		return count==1;
	}

	public void updateJTable() {

		String[][] jtableData = new String[qualificationData.size()][4];

		for (int i = 0; i < jtableData.length; i++) {

			jtableData[i][0] = qualificationData.get(i).getTitle();
			jtableData[i][1] = qualificationData.get(i).getInstitute();
			jtableData[i][2] = qualificationData.get(i).getYearOfPassing();
			jtableData[i][3] = String.valueOf(qualificationData.get(i).getPercentage());

		}

		jTable0.setModel(new DefaultTableModel(jtableData, QUALIFICATION_COLUMN) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		});

	}

	public void updateQualificationData() {

		if(Utilities.isNotEmptyFields(jTextField4,jTextField15,jTextField16,jTextField7,jTextField14,jTextField17)){

			if(Integer.parseInt(jTextField17.getText()) < Integer.parseInt(jTextField16.getText()) ){
				
				if (isNewEntry(jTextField4.getText())) {

					Qualification qualification = new Qualification();
					qualification.setTitle(jTextField4.getText());
					qualification.setInstitute(jTextField7.getText());
					qualification.setDuration(Integer.parseInt(jTextField14.getText()));
					qualification.setYearOfPassing(jTextField15.getText());
					qualification.setTotalMarks(Integer.parseInt(jTextField16.getText()));
					qualification.setObtainedMarks(Integer.parseInt(jTextField17.getText())); 
					qualification.setPercentage((Double.valueOf(jTextField17.getText()) / Double.valueOf(jTextField16.getText()))*100);

					qualificationData.add(qualification);

				} else {

					JOptionPane.showMessageDialog(null, jTextField4.getText()+" ALREADY ADDED!!!");

				}


			} else {

				JOptionPane.showMessageDialog(null, "Total Marks Cannot Be Less Than Obtained Marks!!");
			}
			
		} else {

			JOptionPane.showMessageDialog(null, "Please Enter All Educational Information!");

		}
	}

	public boolean isNewEntry(String title) {

		for (Qualification qualification : qualificationData) {

			if (qualification.getTitle().equalsIgnoreCase(title)) {

				return false;

			}

		}

		return true;
	}

	private void jCheckBox2ChangeStateChanged(ChangeEvent event) {

		jCheckBox2.setSelected(true);	
	}

	private void jCheckBox3ChangeStateChanged(ChangeEvent event) {

		jCheckBox3.setSelected(true);
	}

	public void searchByID() {

		String id = jTextField0.getText();
		student = new StudentSearchUtilities().getStudentByID(id);

		if (student!=null) {

			qualificationData = new StudentSearchUtilities().getStudentQualificationByID(id);
			serviceTitle = new StudentSearchUtilities().getStudentServicesByID(id);
			populateFormForSingleRecord();

		} else {

			JOptionPane.showMessageDialog(null, "Sorry! NO RECORD FOUND!");

		}

	}

	public void searchByID(String id) {

		student = new StudentSearchUtilities().getStudentByID(id);
		qualificationData = new StudentSearchUtilities().getStudentQualificationByID(id);
		serviceTitle = new StudentSearchUtilities().getStudentServicesByID(id);
		populateFormForSingleRecord();

	}

	public void searchByNIC() {

		String NIC = jTextField6.getText();
		student = new StudentSearchUtilities().getStudentByNIC(NIC);

		if (student!=null) {

			qualificationData = new StudentSearchUtilities().getStudentQualificationByNIC(NIC);
			serviceTitle = new StudentSearchUtilities().getStudentServicesByNIC(NIC);
			populateFormForSingleRecord();

		} else {

			JOptionPane.showMessageDialog(null, "Sorry! NO RECORD FOUND!");

		}

	}

	public void searchByName() {

		String name = jTextField1.getText();
		studentID = new StudentSearchUtilities().getStudentsByName(name);
		multipleRecordSearch();

	}

	public void searchByFatherName() {

		String fatherName = jTextField2.getText();
		studentID = new StudentSearchUtilities().getStudentsByFatherName(fatherName);
		multipleRecordSearch();

	}

	public void populateFormForSingleRecord() {

		jTextField0.setText(student.getId());
		jTextField1.setText(student.getName());
		jTextField2.setText(student.getFatherName());
		jTextField3.setText(String.valueOf(student.getAge()));
		jTextField19.setText(student.getGender());
		//jTextField5.setText(student.getDateOfBirth());
		datePicker.setDate(student.getDateOfBirth());
		jTextField6.setText(student.getNationalID());
		jTextField18.setText(student.getBloodGroup());
		jTextField8.setText(student.getStudentCell());
		jTextField9.setText(student.getFatherCell());
		jTextField10.setText(student.getFatherOccupation());
		jTextField11.setText(student.getAddress());
		jTextField12.setText(student.getCountry());
		jTextField13.setText(student.getEmailID());

		updateJTable();
		String title = null;

		for (int i = 0; i < serviceTitle.length; i++) {

			title = serviceTitle[i];

			if (title.equalsIgnoreCase("Mess")) {

				jCheckBox0.setSelected(true);
				break;

			} else {

				jCheckBox0.setSelected(false);

			}

		}

		for (int i = 0; i < serviceTitle.length; i++) {

			title = serviceTitle[i];

			if (title.equalsIgnoreCase("Internet")) {

				jCheckBox1.setSelected(true);
				break;

			} else {

				jCheckBox1.setSelected(false);

			}

		}
		
		jComboBox2.setSelectedItem(student.getRoom().getNo());

	}

	private void jTable0MouseMouseClicked(MouseEvent event) {

		Qualification qualification = null;
		for (int i = 0; i < qualificationData.size(); i++) {

			qualification = qualificationData.get(i);

			if (qualification.getTitle().equalsIgnoreCase(jTable0.getValueAt(jTable0.getSelectedRow(), 0).toString())) {

				jTextField4.setText(qualification.getTitle());
				jTextField7.setText(qualification.getInstitute());
				jTextField14.setText(String.valueOf(qualification.getDuration()));
				jTextField15.setText(qualification.getYearOfPassing());
				jTextField16.setText(String.valueOf(qualification.getTotalMarks()));
				jTextField17.setText(String.valueOf(qualification.getObtainedMarks()));
				updateIndex = i;

			}

		}

	}

	private void jButton1MouseMouseClicked(MouseEvent event) {

		clearFields();

	}

	public void clearFields(JTextField...fields) {

		for (int i = 0; i < fields.length; i++) {

			fields[i].setText("");

		}


	}

	public void clearFields() {

		jTextField0.setText("");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField19.setText("");
		jTextField6.setText("");
		jTextField18.setText("");
		jTextField8.setText("");
		jTextField9.setText("");
		jTextField10.setText("");
		jTextField11.setText("");
		jTextField12.setText("");
		jTextField13.setText("");

		jTextField4.setText("");
		jTextField7.setText("");
		jTextField14.setText("");
		jTextField15.setText("");
		jTextField16.setText("");
		jTextField17.setText("");

		jTable0.setModel(new DefaultTableModel(null,QUALIFICATION_COLUMN));

		try {

			jComboBox2.setModel(new DefaultComboBoxModel(new RoomDAO().availableRoomNOS()));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		jCheckBox0.setSelected(false);
		jCheckBox1.setSelected(false);
		jCheckBox2.setSelected(false);
		jCheckBox3.setSelected(false);

	}

	private void jSpinner0ChangeStateChanged(ChangeEvent event) {

		if (studentID!=null) {

			searchByID(studentID[Integer.parseInt(jSpinner0.getValue().toString())-1].toString());

		}

	}

	public void hidePager() {

		jLabel23.setVisible(false);
		jSpinner0.setVisible(false);

	}

	public void showPager() {

		jLabel23.setVisible(true);
		jSpinner0.setVisible(true);

	}

	private void jCheckBox6ItemItemStateChanged(ItemEvent event) {

		if (jCheckBox6.isSelected()) {

			showPager();

		} else {

			hidePager();

		}

	}

	private void jCheckBox7ItemItemStateChanged(ItemEvent event) {

		if (jCheckBox7.isSelected()) {

			showPager();

		} else {

			hidePager();

		}

	}

	public void multipleRecordSearch() {

		JOptionPane.showMessageDialog(null, studentID.length+" STUDENT(S) FOUND!\n PLEASE USE GOTO FOR NAVIGATION!");

		if (studentID.length>0) {

			searchByID(studentID[0].toString());
			jSpinner0.setModel(new SpinnerNumberModel(1, 1, studentID.length, 1));

		}

	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {

		jCheckBox4.setSelected(true);
		processSearch();

	}

	private void jTextField1ActionActionPerformed(ActionEvent event) {

		jCheckBox6.setSelected(true);
		processSearch();

	}

	private void jTextField2ActionActionPerformed(ActionEvent event) {

		jCheckBox7.setSelected(true);
		processSearch();

	}

	private void jTextField6ActionActionPerformed(ActionEvent event) {

		jCheckBox5.setSelected(true);
		processSearch();

	}

	private void jButton2MouseMouseClicked(MouseEvent event) {

		updateQualificationData();
		updateJTable();

	}

	private void jButton3MouseMouseClicked(MouseEvent event) {

		processQualificationUpdate();

	}

	public void processQualificationUpdate() {

		Qualification qualification = new Qualification();
		qualification.setTitle(jTextField4.getText());
		qualification.setInstitute(jTextField7.getText());
		qualification.setDuration(Integer.parseInt(jTextField14.getText()));
		qualification.setYearOfPassing(jTextField15.getText());
		qualification.setTotalMarks(Integer.parseInt(jTextField16.getText()));
		qualification.setObtainedMarks(Integer.parseInt(jTextField17.getText())); 
		qualification.setPercentage((Double.valueOf(jTextField17.getText()) / Double.valueOf(jTextField16.getText()))*100);

		qualificationData.remove(updateIndex);
		qualificationData.add(updateIndex, qualification);

		updateJTable();

	}

	private void jButton4MouseMouseClicked(MouseEvent event) {

		if(Utilities.isNotEmptyFields(jTextField1,jTextField10,jTextField11,jTextField12,jTextField13,jTextField14,jTextField15,jTextField16,jTextField17,jTextField2,jTextField3,jTextField4,jTextField6,jTextField7,jTextField8,jTextField9,jTextField0)){

			try {

				if (new StudentDAO().updateStudent(this)) {

					JOptionPane.showMessageDialog(null, "RECORD UPDATED!");

				} else {

					JOptionPane.showMessageDialog(null, "SORRY! RECORD NOT UPDATED!");
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "SORRY! RECORD NOT UPDATED!");
			}

		} else {

			JOptionPane.showMessageDialog(null, "Required Fields Cannot Be Left Blank!!");
		}

	}

}
