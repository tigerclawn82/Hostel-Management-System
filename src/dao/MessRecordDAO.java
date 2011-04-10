package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFormattedTextField;

import db.DataSource;
import db.Database;

import ui.MessRecordForm;

import bean.MessRecord;
import bean.Student;

public class MessRecordDAO extends DAO<MessRecord, Integer> {

	public MessRecordDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(MessRecord.class);
	}

	public boolean addMessRecord(MessRecordForm form) {

		MessRecord record = new MessRecord();
		record.setDate(form.datePicker.getDate());
		record.setType(form.jComboBox0.getSelectedItem().toString());

		if (form.jComboBox1.getSelectedItem().toString().equals("Open")) {

			record.setStatus(true);

		} else {

			record.setStatus(false);

		}

		record.setCharges(Integer.parseInt(((JFormattedTextField)form.jTextField2).getValue().toString()));

		Student student = null;

		try {

			student = new StudentDAO().queryForId(form.jTextField0.getText().toUpperCase());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		if (student!=null) {

			try {

				record.setStudent(student);
				record.setService(ServiceDAO.getServiceByTitle("Mess"));
				record.setBillingRecord(null);
				return new MessRecordDAO().create(record)==1;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			} finally {

				DataSource.closeConnection();

			}

		} else {

			return false;
		}

		return false;
	}

}
