package utilities;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import ui.MessRecordForm;
import db.Database;

public class MessUtilities {

	public static void main(String[] args) {

		try {
			
			System.out.println(messEntryAlreadyExist("121-ADAS-1213", "Breakfast", new Date("04/10/2011")));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static boolean addMessRecord(MessRecordForm form) throws SQLException {

		String studentID = form.jTextField0.getText().toUpperCase();
		String serviceTitle = "Mess";
		Date date = form.datePicker.getDate();
		String type = form.jComboBox0.getSelectedItem().toString();
		boolean status = form.jComboBox1.getSelectedItem().toString().equals("Open");
		int charges = Integer.parseInt(((JFormattedTextField)form.jTextField2).getValue().toString());

		if (isMessRegistered(studentID)) {
			
			if (messEntryAlreadyExist(studentID, type, date)) {

				JOptionPane.showMessageDialog(null, "Sorry! Mess Entry already Exist!");
				return false;

			} else {

				PreparedStatement preparedStatement = Database.getPreparedStatement("INSERT INTO MESS_RECORD(STD_ID,S_TITLE,M_TYPE,M_STATUS,M_CHARGES,M_DATE) VALUES(?,?,?,?,?,?)");
				preparedStatement.setObject(1, studentID);
				preparedStatement.setObject(2, serviceTitle);
				preparedStatement.setObject(3, type);
				preparedStatement.setObject(4, status);
				preparedStatement.setObject(5, charges);
				preparedStatement.setObject(6, date);

				return Database.executeInsert(preparedStatement);
			}
			
		} else {

			JOptionPane.showMessageDialog(null, "Sorry! Mess is not Registered for Student: "+studentID);
			return false;
			
		}

	}

	public static boolean messEntryAlreadyExist(String studentID, String type, Date date )  throws SQLException {

		PreparedStatement preparedStatement = Database.getPreparedStatement("SELECT COUNT(*) FROM MESS_RECORD " + 
		"WHERE M_DATE = ? AND S_TITLE = 'Mess' AND STD_ID = ? AND M_TYPE = ? ");
		preparedStatement.setObject(1, date);
		preparedStatement.setObject(2, studentID);
		preparedStatement.setObject(3, type);
		Object[][] executeSelect = Database.executeSelect(preparedStatement);
		
		if (executeSelect!=null) {

			if (executeSelect.length>0) {

				return Integer.parseInt(executeSelect[0][0].toString())==1;

			}

		} 

		return false;
	}

	public static boolean isMessRegistered(String studentID) {

		Object[][] executeSelect = Database.executeSelect("SELECT COUNT(*) FROM STD_SER WHERE STD_ID = '"+studentID+"' AND S_TITLE = 'Mess'");
		
		if (executeSelect!=null) {

			if (executeSelect.length>0) {

				return Integer.parseInt(executeSelect[0][0].toString())==1;

			}

		} 

		return false;
	}

}
