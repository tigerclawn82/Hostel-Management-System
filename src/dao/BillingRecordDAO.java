package dao;

import java.sql.SQLException;

import db.DataSource;

import ui.BillingRecordForm;

import bean.BillingRecord;
import bean.Student;

public class BillingRecordDAO extends DAO<BillingRecord,Integer> {

	public BillingRecordDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(BillingRecord.class);
	}
	
	public boolean addBillingRecord(BillingRecordForm form) {
		
		Student student = null;
		BillingRecord record = new BillingRecord();
		record.setDate(form.jTextField1.getText());
		
		if (form.jCheckBox0.isSelected()) {
			
			record.setAdditional(true);
			record.setDescription(form.jTextArea0.getText());
			
		} else {

			record.setAdditional(false);
			record.setDescription(null);
			
		}
		
		record.setTotalAmount(Integer.parseInt(form.jTextField2.getText()));
		
		try {
			
			student = new StudentDAO().queryForId(form.jTextField0.getText().toUpperCase());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			DataSource.closeConnection();
			
		}
		
		record.setStudent(student);
		
		try {
			
			return new BillingRecordDAO().create(record)==1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			DataSource.closeConnection();
			
		}
		
		return false;
	}
	
}
