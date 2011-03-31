package utilities;

import db.Database;

public class FineUtilities {

	public static int getFineOfStudent(String id) {

		int fine = 0;
		Object[][] charges = Database.executeSelect("SELECT FR_CHARGES FROM FINE_RECORD WHERE STD_ID = '"+id.toUpperCase()+"'");

		for (int i = 0; i < charges.length; i++) {

			fine += Integer.parseInt(charges[i][0].toString());

		}

		return fine;
	}

}
