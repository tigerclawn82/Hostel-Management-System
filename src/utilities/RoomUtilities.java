package utilities;

import db.Database;

public class RoomUtilities {
	
	public static void main(String[] args) {
		
		System.out.println(isAnyStudentInRoom(3));
		
	}
	
	public static String[] getStudentIDsInRoom(int roomNo) {
		
		String[] studentIDs = null;
		Object[][] data = Database.executeSelect("SELECT STD_ID FROM STUDENT WHERE R_NO = "+roomNo);
		
		if (data!=null) {
			
			if (data.length>0) {
				
				studentIDs = new String[data.length];
				for (int i = 0; i < data.length; i++) {
					
					studentIDs[i] = String.valueOf(data[i][0]);
					
				}
				
			} else {
				
				return null;
				
			}
			
		} else {

			return null;
		}
		
		return studentIDs;
	}
	
	public static boolean isAnyStudentInRoom(int roomNo) {
		
		if (getStudentIDsInRoom(roomNo)!=null) {
			
			return true;
		}
		
		return false;
	}

}
