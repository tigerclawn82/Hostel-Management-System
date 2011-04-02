package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ui.RoomForm;

import db.DataSource;

import bean.Room;

public class RoomDAO extends DAO<Room,Integer> {

	public RoomDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(Room.class);
	}
	
	public boolean registerRoom(RoomForm form) {
		
		Room room = new Room();
		room.setNo(Integer.parseInt(form.jTextField0.getText()));
		room.setCapacity(Integer.parseInt(form.jTextField1.getText()));
		room.setLocation(form.jTextArea0.getText());
		
		try {
			
			return new RoomDAO().create(room)==1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			DataSource.closeConnection();
			
		}
		
		return false;
	}
	
	public Object[] availableRoomNOS() {
		
		ArrayList<Integer> rooms = new ArrayList<Integer>();
		
		try {
			
			List<Room> queryForAll = new RoomDAO().queryForAll();
			
			for (Room room : queryForAll) {
				
				if (!room.isFull()) {
					
					rooms.add(room.getNo());
					
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			
			DataSource.closeConnection();
			
		}
		
		return rooms.toArray();
	}
	
	public static boolean roomMigration(int fromRoom, int toRoom) {
		
		Room room = null;
		
		try {
			
			room = new RoomDAO().queryForId(fromRoom);
			
			if (room.isFull()) {
				
				room.setFull(false);
				
			}
			
			room.setCount(room.getCount()-1);
			new RoomDAO().update(room);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
			
		} finally {
			
			DataSource.closeConnection();
			
		}
		
		try {
			
			room = new RoomDAO().queryForId(toRoom);
			
			if (room.getCount()<room.getCapacity()) {

				room.setCount(room.getCount()+1);

			} else {

				room.setFull(true);

			}
			
			new RoomDAO().update(room);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
			
		} finally {
			
			DataSource.closeConnection();
			
		}
	
		return true;
	}
	
	public static Room getRoomByNO(int roomNo) {
		
		Room room = null;
		
		try {

			room = new RoomDAO().queryForId(roomNo);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		} finally {

			DataSource.closeConnection();
		}
		
		return room;
	}

}
