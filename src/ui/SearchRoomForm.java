package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import bean.Room;
import dao.RoomDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class SearchRoomForm extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField jTextField0;
	public JTextField jTextField1;
	private JLabel jLabel0;
	private JLabel jLabel1;
	public JTextArea jTextArea0;
	private JScrollPane jScrollPane0;
	private JLabel jLabel2;
	public JButton jButton0;
	private JPanel jPanel0;
	public JTextField jTextField2;
	private JLabel jLabel3;
	private JCheckBox jCheckBox0;
	private JButton jButton1;
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox3;
	private ButtonGroup buttonGroup1;
	private JSpinner jSpinner0;

	private Room room = null;
	private Object[] roomNos = null;

	public SearchRoomForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Leading(12, 296, 12, 12), new Leading(25, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(37, 54, 10, 229), new Leading(236, 10, 83)));
		add(getJLabel0(), new Constraints(new Leading(32, 10, 10), new Leading(107, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(32, 54, 10, 234), new Leading(145, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(117, 116, 12, 12), new Leading(103, 24, 12, 12)));
		add(getJTextField1(), new Constraints(new Leading(117, 116, 10, 87), new Leading(141, 24, 12, 12)));
		add(getJTextField2(), new Constraints(new Leading(117, 116, 10, 87), new Leading(179, 24, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(32, 65, 10, 10), new Leading(183, 12, 12)));
		add(getJCheckBox0(), new Constraints(new Leading(248, 10, 10), new Leading(179, 10, 132)));
		add(getJButton1(), new Constraints(new Leading(118, 12, 12), new Leading(332, 24, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(233, 10, 10), new Leading(332, 24, 10, 10)));
		add(getJScrollPane0(), new Constraints(new Leading(118, 115, 10, 88), new Leading(220, 82, 10, 10)));
		initButtonGroup1();
		setSize(320, 394);
	}

	private JSpinner getJSpinner0() {
		if (jSpinner0 == null) {
			jSpinner0 = new JSpinner();
			jSpinner0.setModel(new SpinnerNumberModel(1, 1, 1, 1));
			jSpinner0.addChangeListener(new ChangeListener() {

				public void stateChanged(ChangeEvent event) {
					jSpinner0ChangeStateChanged(event);
				}
			});
		}
		return jSpinner0;
	}

	private void initButtonGroup1() {
		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(getJCheckBox1());
		buttonGroup1.add(getJCheckBox2());
		buttonGroup1.add(getJCheckBox3());
	}

	private JCheckBox getJCheckBox3() {
		if (jCheckBox3 == null) {
			jCheckBox3 = new JCheckBox();
			jCheckBox3.setSelected(true);
			jCheckBox3.setText("View All");
		}
		return jCheckBox3;
	}

	private JCheckBox getJCheckBox2() {
		if (jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			jCheckBox2.setSelected(true);
			jCheckBox2.setText("Not Full");
		}
		return jCheckBox2;
	}

	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setSelected(true);
			jCheckBox1.setText("Room No.");
		}
		return jCheckBox1;
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

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setText("Full");
		}
		return jCheckBox0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Residents");
		}
		return jLabel3;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setEditable(false);
		}
		return jTextField2;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Search By", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJCheckBox1(), new Constraints(new Leading(8, 81, 10, 10), new Leading(2, 10, 10)));
			jPanel0.add(getJCheckBox2(), new Constraints(new Leading(89, 67, 10, 10), new Leading(2, 8, 8)));
			jPanel0.add(getJCheckBox3(), new Constraints(new Leading(156, 72, 10, 10), new Leading(2, 8, 8)));
			jPanel0.add(getJSpinner0(), new Constraints(new Trailing(12, 41, 234, 236), new Leading(4, 24, 10, 12)));
		}
		return jPanel0;
	}

	public JButton getJButton0() {
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

	protected JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
		}
		return jTextField1;
	}

	protected JTextField getJTextField0() {
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

		processSearch();

	}

	private void jButton1MouseMouseClicked(MouseEvent event) {

		clearFields();

	}

	public void clearFields() {

		jTextField0.setText("");
		jTextField1.setText("");
		jTextField2.setText("");
		jCheckBox0.setSelected(false);
		jTextArea0.setText("");

	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {

		jCheckBox1.setSelected(true);
		processSearch();

	}

	public void showPager() {

		jSpinner0.setVisible(true);

	}

	public void hidePager() {

		jSpinner0.setVisible(false);

	}

	public void processPager() {

		if (jCheckBox2.isSelected() || jCheckBox3.isSelected()) {

			showPager();

		} else {

			hidePager();

		}

	}

	public void processSearch() {

		if (jCheckBox1.isSelected()) {

			if (jTextField0.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Sorry! Room No. not Entered!");

			} else {

				searchByNO();

			}

		} else if(jCheckBox2.isEnabled()) {

			searchAvailabe();

		} else {

			searchAllRooms();

		}

	}

	public void searchByNO() {

		searchByNO(Integer.parseInt(jTextField0.getText()));

	}

	public void searchByNO(int roomNo) {

		room = RoomDAO.getRoomByNO(roomNo);
		populateFieldsForSingleRecord();

	}

	public void searchAvailabe() {

		roomNos = RoomDAO.getNotFullRoomNos();
		populateForMultipleRecordSearch();

	}

	public void searchAllRooms() {

		roomNos = RoomDAO.getAllRoomNos();
		populateForMultipleRecordSearch();

	}

	public void populateFieldsForSingleRecord() {

		if (room!=null) {

			jTextField0.setText(String.valueOf(room.getNo()));
			jTextField1.setText(String.valueOf(room.getCapacity()));
			jTextField2.setText(String.valueOf(room.getCount()));
			jCheckBox0.setSelected(room.isFull());
			jTextArea0.setText(String.valueOf(room.getLocation()));

		} else {

			JOptionPane.showMessageDialog(null, "Sorry! Room No. "+jTextField0.getText()+" not Exist!");

		}

	}

	public void populateForMultipleRecordSearch() {

		if (roomNos!=null) {

			if (roomNos.length>0) {

				JOptionPane.showMessageDialog(null, roomNos.length+" Room(s) Found. Use Pager for Navigation!");
				searchByNO(Integer.parseInt(roomNos[0].toString()));
				jSpinner0.setModel(new SpinnerNumberModel(1, 1, roomNos.length, 1));

			} else {

				JOptionPane.showMessageDialog(null, "Sorry! No Record Found!");

			}

		}

	}

	private void jSpinner0ChangeStateChanged(ChangeEvent event) {

		if (roomNos!=null) {

			searchByNO(Integer.parseInt(jSpinner0.getValue().toString()));

		}

	}

}
