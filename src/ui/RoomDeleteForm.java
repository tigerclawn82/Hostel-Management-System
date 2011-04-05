package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import utilities.RoomUtilities;

import dao.RoomDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class RoomDeleteForm extends JPanel {

	private class RoomDeleteFromRoomSearch extends SearchRoomForm {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int roomNo = 0;
		@Override
		public JButton getJButton0() {
			// TODO Auto-generated method stub
			if (jButton0 == null) {
				jButton0 = new JButton();
				jButton0.setText("Delete");
				jButton0.addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent event) {

						if (searchRoomForm0.jTextField0.getText().equals("")) {

							JOptionPane.showMessageDialog(null, "Sorry! Please Enter Room No.");

						} else {

							roomNo = Integer.parseInt(jTextField0.getText());

							if (RoomDAO.isRoomExist(roomNo)) {

								JOptionPane.showMessageDialog(null, "Room No. "+roomNo+" not Exist!");

							} else {

								if (RoomUtilities.isAnyStudentInRoom(roomNo)) {

									JOptionPane.showMessageDialog(null, "These Students are in this Room: ");

								} else {

									if (RoomDAO.deleteRoomNo(roomNo)) {

										JOptionPane.showMessageDialog(null, "Room No. "+roomNo+" Deleted!");

									} else {

										JOptionPane.showMessageDialog(null, "Sorry! Room No. "+roomNo+" not Deleted!");

									}

								}

							}

						}

					}
				});
			}
			return jButton0;
		}

	}

	private static final long serialVersionUID = 1L;
	private SearchRoomForm searchRoomForm0;

	public RoomDeleteForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getSearchRoomForm0(), new Constraints(new Leading(0, 320, 12, 12), new Leading(0, 10, 10)));
		setSize(320, 381);
	}

	private SearchRoomForm getSearchRoomForm0() {
		if (searchRoomForm0 == null) {
			searchRoomForm0 = new RoomDeleteFromRoomSearch();
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

}
