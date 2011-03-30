package utilities;

import db.Database;

public class ServiceUtilities {
	
	public static void main(String[] args) {
		
		System.out.println(selectedServicesOfStudent("020-bscs-09"));
		
	}
	
	public static Object[][] servicesWithAmount(String id){
		
		Object[][] data = null;
		Object[][] resultSet = null;
		String query = null;
		
		query = "SELECT S_TITLE FROM STD_SER WHERE STD_ID = '"+id.toUpperCase()+"'";
		resultSet = Database.executeSelect(query);
		
		data = new Object[resultSet.length][2];
		
		for (int i = 0; i < data.length; i++) {
			
			data[i][0] = resultSet[i][0];
			
		}
		
		for (int i = 0; i < data.length; i++) {
			
			if (data[i][0].toString().equalsIgnoreCase("Mess")) {
				
				int messCharges = 0;
				query = "SELECT MR_CHARGES FROM MESS_RECORD WHERE STD_ID = '"+id.toUpperCase()+"'";
				resultSet = Database.executeSelect(query);
				
				for (int j = 0; j < resultSet.length; j++) {
					
					messCharges += Integer.parseInt(resultSet[j][0].toString());
					
				}
				
				data[i][1] = messCharges;
				
			} else {
				
				query = "SELECT S_CHARGE FROM SERVICE WHERE S_TITLE = '"+data[i][0]+"'";
				resultSet = Database.executeSelect(query);
				data[i][1] = resultSet[0][0];

			}
			
		}
		
		return data;
	}
	
	public static int getFineOfStudent(String id) {
		
		int fine = 0;
		Object[][] charges = Database.executeSelect("SELECT FR_CHARGES FROM FINE_RECORD WHERE STD_ID = '"+id.toUpperCase()+"'");
		
		for (int i = 0; i < charges.length; i++) {
			
			fine += Integer.parseInt(charges[i][0].toString());
			
		}
		
		return fine;
	}
	
	public static Object[] selectedServicesOfStudent(String studentID) {
		
		Object[] selectedServices = null;
		String query = "SELECT S_TITLE FROM STD_SER WHERE STD_ID = '"+studentID.toUpperCase()+"'";
		Object[][] services = Database.executeSelect(query);
		
		if (services!=null) {
			
			if (services.length>0) {
				
				selectedServices = new Object[services.length];
				
				for (int i = 0; i < services.length; i++) {
					
					selectedServices[i] = services[i][0];
					
				}
				
			} else {

				return null;
				
			}
			
		} else {

			return null;
			
		}
		
		
		return selectedServices;
	}
	
	public static Object[] notSelectedServicesOfStudent(String studentID) {
		
		Object[] notSelectedServices = null;
		String selectedServices = new String();
		selectedServices+="(";
		
		Object[] selectedServicesOfStudent = selectedServicesOfStudent(studentID);
		
		if (selectedServicesOfStudent!=null) {
			
			if (selectedServicesOfStudent.length>0) {
				
				for (int i = 0; i < selectedServicesOfStudent.length; i++) {
					
					if (i==selectedServicesOfStudent.length-1) {
						
						selectedServices += "'"+selectedServicesOfStudent[i]+"')";
						
					} else {

						selectedServices += "'"+selectedServicesOfStudent[i]+"',";
						
					}
					
				}
				
			} else {
				
				return null;

			}
			
		} else {

			return null;
			
		}
		
		String query = "SELECT S_TITLE FROM SERVICE WHERE S_TITLE NOT IN "+selectedServices;
		Object[][] executeSelect = Database.executeSelect(query);
		
		if (executeSelect!=null) {
			
			if (executeSelect.length>0) {
				
				notSelectedServices = new Object[executeSelect.length];
				
				for (int i = 0; i < executeSelect.length; i++) {
					
					notSelectedServices[i] = executeSelect[0][i];
					
				}
				
			} else {

				return null;
				
			}
			
		} else {

			return null;
			
		}
		
		return notSelectedServices;
	}

}
