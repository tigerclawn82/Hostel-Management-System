package dao;

import java.sql.SQLException;
import java.util.List;

import db.DataSource;

import ui.MendatoryServicesForm;
import ui.ServiceForm;

import bean.Service;

public class ServiceDAO extends DAO<Service, String>{

	public ServiceDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(Service.class);
	}

	public boolean registerService(ServiceForm form) {

		Service service = new Service();

		service.setTitle(form.jTextField0.getText());
		service.setType(form.jComboBox0.getSelectedItem().toString());
		service.setChargeType(form.jComboBox1.getSelectedItem().toString());
		service.setCharge(Integer.parseInt(form.jTextField1.getText()));

		try {

			return new ServiceDAO().create(service)==1;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		return false;
	}

	public boolean registerService(MendatoryServicesForm form) {

		Service service = new Service();

		service.setTitle(form.jTextField0.getText());
		service.setType(form.jComboBox0.getSelectedItem().toString());
		service.setChargeType(form.jComboBox1.getSelectedItem().toString());
		service.setCharge(Integer.parseInt(form.jTextField1.getText()));

		try {

			return new ServiceDAO().create(service)==1;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		return false;
	}
	
	public static Service getServiceByTitle(String title) {
		
		try {

			List<Service> queryForAll = new ServiceDAO().queryForAll();
			if (queryForAll!=null) {
				
				for (Service service : queryForAll) {
					
					if (service.getTitle().equalsIgnoreCase(title)) {
						
						return service;
						
					}
					
				}
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();
		}
		
		return null;
	}

}
