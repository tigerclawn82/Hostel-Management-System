package utilities;

import java.util.List;

import bean.Service;
import dao.ServiceDAO;
import db.DataSource;

public class RegistrationUtilities {
	
	public static void main(String[] args) {
		
		System.out.println(serviceAdded("Internet"));
		
	}

	public boolean isMendatoryServicesAdded() {

		List<Service> queryForAll = null; 
		String[] serviceTitles = {"Mess","Internet","Gas","Electricity"};

		try {

			queryForAll = new ServiceDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;

		} finally {

			DataSource.closeConnection();

		}

		for (String string : serviceTitles) {

			if (!serviceAdded(string)) {

				return false;

			}

		}

		return true;
	}

	public static boolean serviceAdded(String title) {

		List<Service> queryForAll = null; 
		
		try {

			queryForAll = new ServiceDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;

		} finally {

			DataSource.closeConnection();

		}

		for (int i = 0; i < queryForAll.size(); i++) {

			if (queryForAll.get(i).getTitle().equalsIgnoreCase(title)) {

				return true;

			}

		}

		return false;
	}

}
