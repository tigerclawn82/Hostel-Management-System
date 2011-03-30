package dao;

import java.sql.SQLException;

import db.DataSource;

import ui.FineRecordForm;

import bean.FineRecord;
import bean.Student;

public class FineRecordDAO extends DAO<FineRecord, Integer> {

	public FineRecordDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(FineRecord.class);
	}

	public boolean addFineRecord(FineRecordForm form) {

		FineRecord record = new FineRecord();
		record.setDate(form.jTextField1.getText());
		record.setCharges(Integer.parseInt(form.jTextField2.getText()));
		record.setReason(form.jTextArea0.getText());

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
				return new FineRecordDAO().create(record)==1;
				
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
