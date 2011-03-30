package dao;

import java.sql.SQLException;

import bean.ServiceRegistration;

public class ServiceRegistrationDAO extends DAO<ServiceRegistration,String> {

	public ServiceRegistrationDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(ServiceRegistration.class);
	}
	
}
