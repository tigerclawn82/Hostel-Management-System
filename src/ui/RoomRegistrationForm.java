package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import utilities.RoomUtilities;
import bean.Room;
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
	private DefaultListModel listStudentIDs;
	private ArrayList<Room> availableRooms = null;
	private JTable jTable0;
	private JScrollPane jScrollPane2;
	private String[] dataColumns = { "Student ID", "Room No."};
	private Object[][] jTableData = null;
	private ArrayList<String> studentIDs = new ArrayList<String>();
	private ArrayList<Integer> roomNos = new ArrayList<Integer>();

	public RoomRegistrationForm() {
		initComponents();
		listAvailableRooms = new DefaultListModel();
		listStudentIDs = new DefaultListModel();
	}

	public RoomRegistrationForm(int roomNo) {
		this();
		availableRooms = RoomDAO.getAvailableRooms();
		populateAvailableRoomsListExcluding(roomNo);
		populateStudentIDsInRoom(roomNo);
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Leading(13, 131, 10, 10), new Leading(74, 135, 10, 88)));
		add(getJScrollPane1(), new Constraints(new Leading(180, 131, 10, 10), new Leading(74, 135, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(46, 12, 12), new Leading(48, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(193, 104, 12, 12), new Leading(52, 12, 12)));
		add(getJScrollPane2(), new Constraints(new Leading(12, 299, 12, 12), new Leading(251, 150, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(133, 12, 12), new Leading(223, 20, 10, 10)));
		setSize(320, 465);
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJTable0());
		}
		return jScrollPane2;
	}

	private JTable getJTable0() {
		if (jTable0 == null) {
			jTable0 = new JTable();
			jTable0.setModel(new DefaultTableModel(null, dataColumns));
		}
		return jTable0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Add");
			jButton0.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
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
			DefaultListModel listModel = new DefaultListModel();
			jList1.setModel(listModel);
			jList1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jList1MouseMouseClicked(event);
				}
			});
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

			if (availableRooms.size()>0) {

				for (Room room : availableRooms) {

					if (room.getNo()!=roomNo) {

						listAvailableRooms.addElement(room.getNo());

					}

				}

				jList1.setModel(listAvailableRooms);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void populateStudentIDsInRoom(int roomNo) {

		try {

			String[] studentIDsInRoom = RoomUtilities.getStudentIDsInRoom(roomNo);

			if (studentIDsInRoom!=null) {

				for (String studentID : studentIDsInRoom) {

					listStudentIDs.addElement(studentID);

				}

				jList0.setModel(listStudentIDs);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		processJTableFill();

	}

	public void populateJTableData() {

		studentIDs.add(jList0.getSelectedValue().toString());
		roomNos.add(Integer.parseInt(jList1.getSelectedValue().toString()));
		jTableData = new Object[studentIDs.size()][2];

		for (int i = 0; i < jTableData.length; i++) {

			jTableData[i][0] = studentIDs.get(i);
			jTableData[i][1] = roomNos.get(i);

		}
		
		jTable0.setModel(new DefaultTableModel(jTableData, dataColumns));

	}

	public void updateAvailableRoomsList() {

		updateRoomData(Integer.parseInt(jList1.getSelectedValue().toString()));

	}

	public void updateStudentIDsList() {

		listStudentIDs.removeElement(jList0.getSelectedValue());

	}

	public void updateRoomData(int roomNo) {

		for (Room room : availableRooms) {

			if (room.getNo()==roomNo) {

				room.setCount(room.getCount()+1);

				if (room.getCount()==room.getCapacity()) {

					listAvailableRooms.removeElement(room.getNo());

				}

			}

		}

	}
	
	public void processJTableFill() {
		
		populateJTableData();
		updateStudentIDsList();
		updateAvailableRoomsList();
		
	}

	private void jList1MouseMouseClicked(MouseEvent event) {
		
		jList1.setToolTipText("Avaiable Capacity: "+ getCapacityOfRoomNo(Integer.parseInt(jList1.getSelectedValue().toString())));
		ToolTipManager.sharedInstance().mouseMoved(
		        new MouseEvent(jList1, 0, 0, 0,
		                event.getX(), event.getY(), // X-Y of the mouse for the tool tip
		                0, false));
		
	}
	
	public int getCapacityOfRoomNo(int roomNo) {
		
		for (Room room : availableRooms) {
			
			if (room.getNo()==roomNo) {
				
				return room.getCapacity();
				
			}
			
		}
		
		return 0;
	}

}
