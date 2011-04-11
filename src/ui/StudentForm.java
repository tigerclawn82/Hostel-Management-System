package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import msg.Error;
import msg.Success;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;
import org.jdesktop.swingx.JXDatePicker;

import utilities.EmailValidator;
import utilities.FILTERS;
import utilities.JTextFieldFilter;
import utilities.Utilities;
import bean.Qualification;
import dao.RoomDAO;
import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class StudentForm extends JPanel {

	public ArrayList<Qualification> qualificationData = null;
	public final String[] QUALIFICATION_COLUMN = { "TITLE", "INSTITUTE","YEAR OF PASSING","PERCENTAGE" };
	public String acceptAlphabet = "abcdefghijklmonpqrstuvwxyz ABCDEFGHIJKLMONPQRSTUVWXYZ-";

	private static final long serialVersionUID = 1L;
	private JPanel jPanel0;
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
	private JButton jButton1;
	private JPanel jPanel2;
	public JCheckBox jCheckBox0;
	public JCheckBox jCheckBox1;
	private JLabel jLabel20;
	public JCheckBox jCheckBox2;
	public JCheckBox jCheckBox3;
	public JComboBox jComboBox2;
	private JLabel jLabel21;
	public JXDatePicker datePicker;
	private JButton jButton2;
	public JFormattedTextField jFormattedTextField0;
	private boolean studentExist = true;

	public StudentForm() {

		qualificationData = new ArrayList<Qualification>();
		initComponents();

	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Leading(12, 576, 12, 12), new Leading(33, 332, 10, 10)));
		add(getJPanel2(), new Constraints(new Leading(12, 576, 12, 12), new Leading(760, 100, 10, 10)));
		add(getJPanel1(), new Constraints(new Leading(12, 576, 12, 12), new Leading(388, 347, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(284, 10, 10), new Leading(878, 12, 12)));
		add(getJButton2(), new Constraints(new Leading(172, 10, 10), new Leading(878, 12, 12)));
		setSize(600, 925);
	}

	private JFormattedTextField getJFormattedTextField0() {
		if (jFormattedTextField0 == null) {

			try {

				jFormattedTextField0 = new JFormattedTextField(new MaskFormatter("###-UUUU-####"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			
			jFormattedTextField0.addFocusListener(new FocusAdapter() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
					studentExist = StudentDAO.isStudentIDExist(jFormattedTextField0.getText());
					if (studentExist) {
						
						JOptionPane.showMessageDialog(null, "Student ID: "+jFormattedTextField0.getText()+" already Exist!");
						
					}
					
				}
			});
		}
		return jFormattedTextField0;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Clear Fields");
			jButton2.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton2MouseMouseClicked(event);
				}
			});
		}
		return jButton2;
	}

	private JLabel getJLabel21() {
		if (jLabel21 == null) {
			jLabel21 = new JLabel();
			jLabel21.setText("Room No.");
		}
		return jLabel21;
	}

	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();

			try {

				Object[] availableRoomNOS = new RoomDAO().availableRoomNOS();

				if (availableRoomNOS!=null) {

					jComboBox2.setModel(new DefaultComboBoxModel(availableRoomNOS));

				} 

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			jComboBox2.setDoubleBuffered(false);


		}
		return jComboBox2;
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
			jCheckBox0.setText("Mess");
		}
		return jCheckBox0;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Register Services", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getJCheckBox0(), new Constraints(new Leading(17, 10, 10), new Leading(21, 10, 10)));
			jPanel2.add(getJCheckBox1(), new Constraints(new Leading(118, 78, 10, 10), new Leading(21, 8, 8)));
			jPanel2.add(getJLabel20(), new Constraints(new Leading(400, 12, 12), new Leading(-6, 40, 40)));
			jPanel2.add(getJCheckBox2(), new Constraints(new Leading(413, 56, 10, 10), new Leading(21, 36, 36)));
			jPanel2.add(getJCheckBox3(), new Constraints(new Leading(413, 84, 8, 8), new Trailing(8, 49, 49)));
			jPanel2.add(getJLabel21(), new Constraints(new Leading(235, 12, 12), new Leading(-6, 12, 12)));
			jPanel2.add(getJComboBox2(), new Constraints(new Leading(229, 60, 12, 12), new Leading(21, 12, 12)));
		}
		return jPanel2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("ADD");
			jButton1.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
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
			jTable0.setModel(new DefaultTableModel(new Object[][] { { "", "", }, { "", "", }, }, QUALIFICATION_COLUMN) {

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
		return jTable0;
	}

	private JTextField getJTextField17() {
		if (jTextField17 == null) {
			jTextField17 = new JTextField();
			jTextField17.setDocument(JTextFieldFilter.filter(FILTERS.NUMERIC));

		}
		return jTextField17;
	}

	private JTextField getJTextField16() {
		if (jTextField16 == null) {
			jTextField16 = new JTextField();
			jTextField16.setDocument(JTextFieldFilter.filter(FILTERS.NUMERIC));

		}
		return jTextField16;
	}

	private JTextField getJTextField15() {
		if (jTextField15 == null) {
			jTextField15 = new JTextField();
			jTextField15.setDocument(JTextFieldFilter.filter(FILTERS.NUMERIC));

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
			JTextFieldFilter filter = new JTextFieldFilter(acceptAlphabet);
			jTextField7.setDocument(filter);


		}
		return jTextField7;
	}

	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			JTextFieldFilter filter = new JTextFieldFilter(acceptAlphabet);
			jTextField4.setDocument(filter);
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
			jPanel1.add(getJButton1(), new Constraints(new Leading(261, 10, 10), new Trailing(153, 124, 124)));
		}
		return jPanel1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("REGISTER");
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
			JTextFieldFilter filter = new JTextFieldFilter(acceptAlphabet);
			jTextField12.setDocument(filter);


		}
		return jTextField12;
	}

	private JTextField getJTextField11() {
		if (jTextField11 == null) {
			jTextField11 = new JTextField();
			jTextField11.setDocument(JTextFieldFilter.filter(FILTERS.ALPHA_SPACE,FILTERS.NUMERIC,"/-"));

		}
		return jTextField11;
	}

	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			JTextFieldFilter filter = new JTextFieldFilter(acceptAlphabet);
			jTextField10.setDocument(filter);

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

		}
		return jTextField6;
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
			
			jTextField3.addFocusListener(new FocusAdapter() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
					datePicker.setDate(new Date("01/01/"+(getCurrentYear()-Integer.parseInt(jTextField3.getText()))));
					
				}
				
			});

		}
		return jTextField3;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			JTextFieldFilter filter = new JTextFieldFilter(acceptAlphabet);
			jTextField2.setDocument(filter);

		}
		return jTextField2;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setDocument(JTextFieldFilter.filter(FILTERS.ALPHA_SPACE));
		}
		return jTextField1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font(
					"Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJTextField1(), new Constraints(new Leading(117, 134, 12, 12), new Leading(54, 23, 10, 10)));
			jPanel0.add(getJTextField2(), new Constraints(new Leading(117, 134, 12, 12), new Leading(95, 23, 12, 12)));
			jPanel0.add(getJTextField3(), new Constraints(new Leading(117, 134, 12, 12), new Leading(136, 23, 12, 12)));
			jPanel0.add(getJComboBox0(), new Constraints(new Leading(117, 134, 12, 12), new Leading(177, 23, 12, 12)));
			jPanel0.add(getDatePicker(), new Constraints(new Leading(117, 134, 12, 12), new Leading(218, 23, 12, 12)));
			jPanel0.add(getJTextField6(), new Constraints(new Leading(117, 134, 12, 12), new Leading(259, 23, 12, 12)));
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
			jPanel0.add(getJFormattedTextField0(), new Constraints(new Leading(117, 134, 12, 12), new Leading(18, 23, 12, 12)));
		}
		return jPanel0;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		if(validateStudentInputs()){

			try {

				if (new StudentDAO().registerStudent(this)) {

					JOptionPane.showMessageDialog(null, Success.STUDENT_REGSISTRATION_SUCCESS);

				} else {

					JOptionPane.showMessageDialog(null, Error.STUDENT_REGSISTRATION_FAILED);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, Error.STUDENT_REGSISTRATION_FAILED);
			}


		} else {

			// DO NOTHING EXCEPTIONS ARE HANDLED IN METHOD!!
		}
	}

	private void jButton1MouseMouseClicked(MouseEvent event) {

		updateQualificationData();
		updateJTable();

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

		if(validateQualificatioInputs()){

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

			// DON NOTHING
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

	private void jButton2MouseMouseClicked(MouseEvent event) {

		clearFields();

	}

	public void clearFields() {

		jFormattedTextField0.setText("");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField6.setText("");
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

	}

	public boolean validateStudentInputs(){

		if(Utilities.isNotEmptyFields(jTextField1,jTextField10,jTextField11,jTextField12,jTextField13,jTextField2,jTextField3,jTextField6,jTextField8,jTextField9,jFormattedTextField0)){

			if(!EmailValidator.validate(jTextField13.getText())){

				JOptionPane.showMessageDialog(null, "EMAIL ID NOT VALID !!");
				return false;
				
			}

		} else {

			JOptionPane.showMessageDialog(null, "REQUIRED FIELDS CAN'T BE LEFT BLANK!!");
			return false;
		}
		
		if (studentExist) {
			
			JOptionPane.showMessageDialog(null, "Student ID: "+jFormattedTextField0.getText()+" already Exist!");
			return false;
		}

		return true;
	}

	public boolean validateQualificatioInputs(){

		if(Utilities.isNotEmptyFields(jTextField4,jTextField15,jTextField16,jTextField7,jTextField14,jTextField17)){

			if (isNewEntry(jTextField4.getText())) {

				if(Integer.parseInt(jTextField17.getText()) < Integer.parseInt(jTextField16.getText()) ){

					if(Integer.parseInt(jTextField15.getText()) >= getCurrentYear()){

						JOptionPane.showMessageDialog(null, "Passing Year Should Be Less Than Current Year");
						return false;
					} 

				} else {

					JOptionPane.showMessageDialog(null, "TOTAL MARKS CAN'T BE LESS THAN OBTAINED MARKS!!");
					return false;
				}

			} else {

				JOptionPane.showMessageDialog(null, jTextField4.getText()+" ALREADY ADDED!!!");
				return false;
			}

		} else {

			JOptionPane.showMessageDialog(null, "PLEASE ENTER COMPLETE EDUCATIONAL INFO!!");
			return false;
		}


		return true;
	}

	public int  getCurrentYear(){

		return new GregorianCalendar().get(Calendar.YEAR);
	}

}
