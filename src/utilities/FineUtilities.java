package utilities;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ui.FineRecordForm;
import db.Database;

public class FineUtilities {
	
	public static boolean addFineRecord(FineRecordForm form) throws SQLException {
		
		String studentID = form.jTextField0.getText();
		Date generationDate = form.getJxDatePicker().getDate(); 
		int charges = Integer.parseInt(form.jTextField2.getText());
		String reason = form.jTextArea0.getText();
		PreparedStatement preparedStatement = Database.getPreparedStatement("INSERT INTO FINE_RECORD(STD_ID,F_REASON,F_GDATE,F_CHARGES) VALUES(?,?,?,?,?)");
		preparedStatement.setObject(1, studentID);
		preparedStatement.setObject(2, reason);
		preparedStatement.setObject(3, generationDate);
		preparedStatement.setObject(4, charges);
		
		return Database.executeInsert(preparedStatement);
	}

	public static int getFineOfStudent(String id) {

		int fine = 0;
		Object[][] charges = Database.executeSelect("SELECT F_CHARGES FROM FINE_RECORD WHERE STD_ID = '"+id.toUpperCase()+"'");

		for (int i = 0; i < charges.length; i++) {

			fine += Integer.parseInt(charges[i][0].toString());

		}

		return fine;
	}

}
