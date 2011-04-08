package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import dao.RoomDAO;


//VS4E -- DO NOT REMOVE THIS LINE!
public class RoomUpdateForm extends JPanel {

	private class RoomUpdateFormFromRoomDeleteForm extends SearchRoomForm {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Override
		public JButton getJButton0() {
			// TODO Auto-generated method stub
			if (jButton0 == null) {
				jButton0 = new JButton();
				jButton0.setText("Update");
				jButton0.addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent event) {
						
						processRoomUpdate();
					}
				});
			}
			return jButton0;
		}

	}

	private static final long serialVersionUID = 1L;
	public SearchRoomForm searchRoomForm0;

	public RoomUpdateForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getSearchRoomForm0(), new Constraints(new Leading(0, 320, 10, 10), new Leading(0, 380, 10, 10)));
		setSize(320, 380);
	}

	private SearchRoomForm getSearchRoomForm0() {
		if (searchRoomForm0 == null) {
			searchRoomForm0 = new RoomUpdateFormFromRoomDeleteForm();
			searchRoomForm0.add(getDetailButton(), new Constraints(new Leading(237, 70, 10, 10), new Leading(103, 23,10, 10)));
		}
		return searchRoomForm0;
	}

	JButton detailButton = null;
	public JButton getDetailButton() {

		if (detailButton==null) {

			detailButton = new JButton("Detail");
			detailButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					searchRoomForm0.processSearch();
				}

			});

		}

		return detailButton;
	}
	
	public void processRoomUpdate() {
		
		if (RoomDAO.UpdateRoom(this)) {
			
			JOptionPane.showMessageDialog(null, "Room Details Updated!");
			
		} else {

			JOptionPane.showMessageDialog(null, "Sorry! Room Details not Updated!");
			
		}
		
	}

}
