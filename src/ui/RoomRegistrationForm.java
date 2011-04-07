package ui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import dao.RoomDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class RoomRegistrationForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList jList0;
	private JScrollPane jScrollPane0;
	private JLabel jLabel0;

	private JList jList1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel1;
	private JButton jButton0;
	
	private DefaultListModel listAvailableRooms;
	DefaultListModel listStudentIDs;

	public RoomRegistrationForm() {
		initComponents();
		populateAvailableRoomsListExcluding(2);
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Leading(13, 131, 10, 10), new Leading(74, 135, 10, 88)));
		add(getJScrollPane1(), new Constraints(new Leading(180, 131, 10, 10), new Leading(74, 135, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(46, 12, 12), new Leading(48, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(193, 104, 12, 12), new Leading(52, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(130, 10, 10), new Leading(234, 10, 10)));
		setSize(320, 296);
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Save");
		}
		return jButton0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Available Room(s)");
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
			listAvailableRooms = new DefaultListModel();
			jList1.setModel(listStudentIDs);
		}
		return jList1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Student IDs");
		}
		return jLabel0;
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
			listStudentIDs = new DefaultListModel();
			jList0.setModel(listStudentIDs);
		}
		return jList0;
	}
	
	public void populateAvailableRoomsListExcluding(int roomNo) {
		
		try {
			
			Object[] notFullRoomNos = RoomDAO.getNotFullRoomNos();
			
			for (Object object : notFullRoomNos) {
				
				if (Integer.parseInt(object.toString())!=roomNo) {
					
					listAvailableRooms.addElement(object);
					
				} 
				
			}
			
			jList1.setModel(listAvailableRooms);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
