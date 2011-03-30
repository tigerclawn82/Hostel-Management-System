package main;

import java.sql.SQLException;

import annotation.ConstraintProcessor;
import bean.BillingRecord;
import bean.FineRecord;
import bean.MessRecord;
import bean.Qualification;
import bean.Room;
import bean.Service;
import bean.ServiceRegistration;
import bean.Student;

import com.j256.ormlite.table.TableUtils;

import dao.RoomDAO;
import db.DataSource;

public class Test {

	public static void main(String[] args) {

		try {

			TableUtils.createTable(DataSource.getConnectionSource(), Qualification.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {

			try {

				DataSource.closeConnection();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}

	}

}
