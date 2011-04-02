package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import dao.RoomDAO;

import bean.Room;


//VS4E -- DO NOT REMOVE THIS LINE!
public class RoomSearchForm extends JPanel {

	private final class RoomFormExtension extends RoomForm {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void initComponents() {
			// TODO Auto-generated method stub
			setLayout(new GroupLayout());
			add(getJTextField0(), new Constraints(new Leading(118, 116, 12, 12), new Leading(37, 24, 12, 12)));
			add(getJLabel0(), new Constraints(new Leading(41, 10, 10), new Leading(41, 12, 12)));
			add(getJTextField1(), new Constraints(new Leading(118, 116, 12, 12), new Leading(75, 24, 12, 12)));
			add(getJLabel1(), new Constraints(new Leading(41, 54, 12, 12), new Leading(79, 12, 12)));
			add(getJScrollPane0(), new Constraints(new Leading(117, 115, 10, 10), new Leading(118, 49, 10, 10)));
			add(getJLabel2(), new Constraints(new Leading(41, 54, 12, 12), new Leading(125, 10, 10)));
			//add(getJButton0(), new Constraints(new Leading(170, 12, 12), new Leading(185, 12, 12)));
			setSize(320, 240);
		}
		
	}
	
	private static final long serialVersionUID = 1L;
	private RoomForm roomForm0;
	private JTextField jTextField0;
	private JLabel jLabel0;
	private JCheckBox jCheckBox0;
	private JPanel jPanel0;
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox3;
	private JSpinner jSpinner0;
	private JButton jButton0;
	private JButton jButton1;
	private ButtonGroup buttonGroup1;
	
	private Room room = null;

	public RoomSearchForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getRoomForm0(), new Constraints(new Leading(0, 320, 12, 12), new Leading(88, 171, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(117, 114, 10, 10), new Leading(271, 24, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(42, 10, 10), new Leading(275, 10, 34)));
		add(getJCheckBox0(), new Constraints(new Leading(237, 10, 10), new Leading(271, 10, 10)));
		add(getJPanel0(), new Constraints(new Leading(12, 296, 12, 12), new Leading(20, 66, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(42, 10, 10), new Leading(309, 12, 12)));
		add(getJButton1(), new Constraints(new Leading(156, 10, 10), new Leading(309, 10, 16)));
		initButtonGroup1();
		setSize(320, 351);
	}

	private void initButtonGroup1() {
		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(getJCheckBox1());
		buttonGroup1.add(getJCheckBox2());
		buttonGroup1.add(getJCheckBox3());
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
			jButton0.setText("Clear Fields");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JSpinner getJSpinner0() {
		if (jSpinner0 == null) {
			jSpinner0 = new JSpinner();
		}
		return jSpinner0;
	}

	private JCheckBox getJCheckBox3() {
		if (jCheckBox3 == null) {
			jCheckBox3 = new JCheckBox();
			jCheckBox3.setSelected(true);
			jCheckBox3.setText("View All");
			jCheckBox3.addItemListener(new ItemListener() {
	
				public void itemStateChanged(ItemEvent event) {
					jCheckBox3ItemItemStateChanged(event);
				}
			});
		}
		return jCheckBox3;
	}

	private JCheckBox getJCheckBox2() {
		if (jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			jCheckBox2.setText("Not Full");
		}
		return jCheckBox2;
	}

	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setText("Room No.");
		}
		return jCheckBox1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Search By", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJCheckBox1(), new Constraints(new Leading(0, 8, 8), new Leading(4, 10, 10)));
			jPanel0.add(getJCheckBox2(), new Constraints(new Leading(80, 79, 10, 10), new Leading(4, 8, 8)));
			jPanel0.add(getJCheckBox3(), new Constraints(new Leading(159, 79, 10, 10), new Leading(4, 8, 8)));
			jPanel0.add(getJSpinner0(), new Constraints(new Leading(240, 42, 10, 10), new Leading(6, 10, 10)));
		}
		return jPanel0;
	}

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setText("Full");
		}
		return jCheckBox0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Residents");
		}
		return jLabel0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
		}
		return jTextField0;
	}

	private RoomForm getRoomForm0() {
		if (roomForm0 == null) {
			roomForm0 = new RoomFormExtension();
		}
		return roomForm0;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		
		clearFields();
		
	}
	
	public void clearFields() {
		
		roomForm0.jTextField0.setText("");
		roomForm0.jTextField1.setText("");
		roomForm0.jTextArea0.setText("");
		jTextField0.setText("");
		jCheckBox0.setSelected(false);
		
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

	private void jButton1MouseMouseClicked(MouseEvent event) {
		
		processSearch();
		
	}
	
	public void processSearch() {
		
		if (jCheckBox1.isSelected()) {
			
			searchByNO();
			
		} else if(jCheckBox2.isEnabled()) {
			
			searchAvailabe();

		} else {
			
			searchAllRooms();
			
		}
		
	}
	
	public void searchByNO() {
		
		searchByNO(Integer.parseInt(roomForm0.jTextField0.getText()));
		
	}
	
	public void searchByNO(int roomNo) {
		
		room = RoomDAO.getRoomByNO(roomNo);
		
	}
	
	public void searchAvailabe() {
		
		
	}
	
	public void searchAllRooms() {
		
		
		
	}

	private void jCheckBox3ItemItemStateChanged(ItemEvent event) {
		
		if (jCheckBox3.isSelected()) {
			
			searchAllRooms();
			
		}
		
	}
	
	public void populateFieldsForSingleRecord() {
		
		roomForm0.jTextField0.setText(String.valueOf(room.getNo()));
		roomForm0.jTextField1.setText(String.valueOf(room.getCapacity()));
		roomForm0.jTextArea0.setText(String.valueOf(room.getLocation()));
		jTextField0.setText(String.valueOf(room.getCount()));
		jCheckBox0.setSelected(room.isFull());
		
	}

}
