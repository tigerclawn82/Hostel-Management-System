package utilities;

import ui.BillingRecordForm;
import bean.BillingRecord;
import bean.Student;
import dao.BillingRecordDAO;
import dao.StudentDAO;
import db.DataSource;
import db.Database;

public class BillUtitilities {
	
public boolean addBillingRecord(BillingRecordForm form) {
		
		Database.getPreparedStatement("INSERT INTO BILL_RECORD ");
		Student student = null;
		BillingRecord record = new BillingRecord();
		record.setGenerationDate(form.datePicker.getDate());
		record.setDueDate(form.dueDatePicker.getDate());
		
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
