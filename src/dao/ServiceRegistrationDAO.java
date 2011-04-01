package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.StudentSearchUtilities;

import db.DataSource;

import bean.ServiceRegistration;

public class ServiceRegistrationDAO extends DAO<ServiceRegistration,String> {

	public ServiceRegistrationDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(ServiceRegistration.class);
	}

	public static Object[] getServicesRegisteredByStudent(String studentID){

		List<ServiceRegistration> queryForAll = null;
		ArrayList<String> serviceTitles = new ArrayList<String>();

		try {

			queryForAll = new ServiceRegistrationDAO().queryForAll();
			for (ServiceRegistration serviceRegistration : queryForAll) {

				if (serviceRegistration.getStudent().getId().equalsIgnoreCase(studentID)) {

					serviceTitles.add(serviceRegistration.getService().getTitle());

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		} finally {

			DataSource.closeConnection();

		}

		return serviceTitles.toArray();
	}

	public static boolean isServiceRegisteredByStudent(String studentID, String serviceTitle){

		Object[] servicesRegisteredByStudent = getServicesRegisteredByStudent(studentID);
		
		for (Object object : servicesRegisteredByStudent) {
			
			if (object.toString().equalsIgnoreCase(serviceTitle)) {
				
				return true;
				
			}
			
		}

		return false;
	}

}
