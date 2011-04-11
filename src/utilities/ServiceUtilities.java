package utilities;

import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;

import ui.ServiceRegistrationForm;
import db.Database;

public class ServiceUtilities {

	public static void main(String[] args) {

		
	}
	
	public static Object[][] getServicesWithChargesForStudent(String studentID){
		
		Object[][] servicesWithCharges = null;
	
		Object[][] resultSet = Database.executeSelect("SELECT S_TITLE FROM STD_SER WHERE STD_ID = '"+studentID.toUpperCase()+"'");
		servicesWithCharges = new Object[resultSet.length+1][2];
		
		for (int i = 0; i < resultSet.length; i++) {
			
			servicesWithCharges[i][0] = resultSet[i][0];
			servicesWithCharges[i][1] = getChargesOfService(resultSet[i][0].toString());
			
		}
		
		servicesWithCharges[resultSet.length][0] = "Mess Bill";
		servicesWithCharges[resultSet.length][1] = getMessChargesOfStudent(studentID);
		
		return servicesWithCharges;
	}
	
	public static int getChargesOfService(String title) {
		
		Object[][] select = Database.executeSelect("SELECT S_CHARGE FROM SERVICE WHERE S_TITLE = '"+title+"'");
		double no = Double.valueOf(select[0][0].toString());
		
		return (int) no;
	}
	
	public static int getMessChargesOfStudent(String studentID) {
		
		int messCharges = 0;
		Object[][] resultSet = Database.executeSelect("SELECT M_CHARGES FROM MESS_RECORD WHERE STD_ID = '"+studentID.toUpperCase()+"'");

		for (int j = 0; j < resultSet.length; j++) {

			messCharges += Integer.parseInt(resultSet[j][0].toString());

		}
		
		return messCharges;
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

					notSelectedServices[i] = executeSelect[i][0];

				}

			} else {

				return null;

			}

		} else {

			return null;

		}

		return notSelectedServices;
	}

	public static Object[] getMendatoryServices(){

		Object[][] data = Database.executeSelect("SELECT S_TITLE FROM SERVICE WHERE S_TYPE = 'Mendatory'");
		Object[] mendatoryServices = new Object[data.length];

		if (data.length>0) {

			for (int i = 0; i < mendatoryServices.length; i++) {

				mendatoryServices[i] = data[i][0];

			}

		} else {

			return null;

		}

		return mendatoryServices;
	}

	public static boolean updateStudentServices(ServiceRegistrationForm form){

		PreparedStatement preparedStatement = null;
		String studentID = form.jTextField0.getText().toUpperCase();
		boolean delete = Database.executeDelete("DELETE FROM STD_SER WHERE STD_ID = '"+studentID+"'");

		if (delete) {

			DefaultListModel selectedServices = form.selectedServices;
			for (int i = 0; i < selectedServices.size(); i++) {

				try {

					preparedStatement = Database.getPreparedStatement("INSERT INTO STD_SER (STD_ID,S_TITLE) VALUES (?,?)");
					preparedStatement.setObject(1, studentID);
					preparedStatement.setObject(2, selectedServices.get(i));
					Database.executeInsert(preparedStatement);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return false;
				}

			}

		} else {

			return false;
		}

		return true;
	}

	public static boolean updateStudentServices(String studentID, DefaultListModel selectedServices){

		studentID = studentID.toUpperCase();
		
		String studentDelete = "DELETE FROM STD_SER WHERE STD_ID = '"+studentID+"'";
		String[] insertQueries = new String[selectedServices.size()+1];
		
		insertQueries[0] = studentDelete;

		for (int i = 0; i < selectedServices.size(); i++) {

			insertQueries[i+1] = "INSERT INTO STD_SER (STD_ID,S_TITLE) VALUES ('"+studentID+"','"+selectedServices.get(i)+"')";

		}
		
		boolean executeTransaction = Database.executeTransaction(insertQueries);
		
		if (!executeTransaction) {
			
			return false;
			
		}

		return true;
	}

}
