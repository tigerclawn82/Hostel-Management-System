package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import utilities.IconProcess;
import utilities.ServiceUtilities;
import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ServiceRegistrationForm extends JPanel {

	DefaultListModel availableServices = new DefaultListModel();
	DefaultListModel selectedServices = new DefaultListModel();

	private static final long serialVersionUID = 1L;
	private JTextField jTextField0;
	private JLabel jLabel0;
	private JList jList0;
	private JScrollPane jScrollPane0;
	private JList jList1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton jButton0;
	private JButton jButton1;

	public ServiceRegistrationForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Leading(37, 121, 10, 10), new Leading(101, 135, 10, 10)));
		add(getJScrollPane1(), new Constraints(new Leading(218, 121, 10, 10), new Leading(101, 135, 10, 92)));
		add(getJLabel2(), new Constraints(new Leading(170, 12, 12), new Leading(170, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(170, 12, 12), new Leading(135, 10, 10)));
		add(getJLabel3(), new Constraints(new Leading(72, 12, 12), new Leading(79, 12, 12)));
		add(getJLabel4(), new Constraints(new Leading(253, 12, 12), new Leading(79, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(258, 81, 12, 12), new Leading(273, 24, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(37, 12, 12), new Leading(30, 12, 12)));
		add(getJTextField0(), new Constraints(new Leading(115, 118, 10, 10), new Leading(26, 24, 12, 12)));
		add(getJButton1(), new Constraints(new Leading(261, 75, 10, 43), new Leading(26, 24, 12, 12)));
		setSize(378, 327);
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Search");
			jButton1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Save");
		}
		return jButton0;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Selected");
		}
		return jLabel4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Available");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setIcon(new IconProcess().resizeIcon("/images/navigate-left-icon.png", 35, 25));
			jLabel2.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jLabel2MouseMouseClicked(event);
				}
			});
		}
		return jLabel2;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setIcon(new IconProcess().resizeIcon("/images/navigate-right-icon.png", 35, 25));
			jLabel1.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jLabel1MouseMouseClicked(event);
				}
			});
		}
		return jLabel1;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJList1());
		}
		return jScrollPane1;
	}

	private JList getJList1() {
		if (jList1 == null) {
			jList1 = new JList();
		}
		return jList1;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJList0());
		}
		return jScrollPane0;
	}

	private JList getJList0() {
		if (jList0 == null) {
			jList0 = new JList();

		}
		return jList0;
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

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Student ID");
		}
		return jLabel0;
	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {

		performSearchAndPopulate();

	}

	public void performSearchAndPopulate() {

		try {

			if (new StudentDAO().isStudentIDExist(jTextField0.getText())) {

				populateAvailableServices();
				populateSelectedeServices();

			} else {

				JOptionPane.showMessageDialog(null, "Student ID doesn't Exist!");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}

	private void jLabel1MouseMouseClicked(MouseEvent event) {
		
		System.out.println("Right!");
		
		if (isNotAdded(jList0.getSelectedValue().toString())) {
			
			selectedServices.addElement(jList0.getSelectedValue());
			availableServices.removeElement(jList0.getSelectedValue());
			
		} else {
			
			JOptionPane.showMessageDialog(null, jList0.getSelectedValue().toString()+" is Already Added!");

		}
		
	}

	private void jLabel2MouseMouseClicked(MouseEvent event) {
		
		System.out.println("Left!");
		
		availableServices.addElement(jList1.getSelectedValue());
		selectedServices.removeElement(jList1.getSelectedValue());
		
	}

	public void populateAvailableServices() {

		Object[] notSelectedServicesByStudent = ServiceUtilities.notSelectedServicesOfStudent(jTextField0.getText());

		if (notSelectedServicesByStudent!=null) {

			for (int i = 0; i < notSelectedServicesByStudent.length; i++) {

				availableServices.addElement(notSelectedServicesByStudent[i]);

			}

		}

		jList0.setModel(availableServices);

	}

	public void populateSelectedeServices() {

		Object[] selectedServicesByStudent = ServiceUtilities.selectedServicesOfStudent(jTextField0.getText());

		if (selectedServicesByStudent!=null) {

			for (int i = 0; i < selectedServicesByStudent.length; i++) {

				selectedServices.addElement(selectedServicesByStudent[i]);

			}

		}

		jList1.setModel(selectedServices);

	}

	private void jButton1MouseMouseClicked(MouseEvent event) {
		
		performSearchAndPopulate();
		
	}
	
	public boolean isNotAdded(String title) {
		
		return !selectedServices.contains(title);
		
	}

}
