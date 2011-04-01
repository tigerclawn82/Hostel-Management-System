package dao;

import java.sql.SQLException;

import db.DataSource;
import db.Database;

import ui.StudentForm;
import ui.UpdateStudentForm;

import bean.Qualification;
import bean.Room;
import bean.Service;
import bean.ServiceRegistration;
import bean.Student;

public class StudentDAO extends DAO<Student,String>{

	public StudentDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(Student.class);
	}

	public boolean registerStudent(StudentForm form){

		Student student = new Student();

		student.setId(form.jFormattedTextField0.getText().toUpperCase());
		student.setName(form.jTextField1.getText());
		student.setFatherName(form.jTextField2.getText());
		student.setAge(Integer.parseInt(form.jTextField3.getText()));
		student.setGender(form.jComboBox0.getSelectedItem().toString());
		//student.setDateOfBirth(form.jTextField5.getText());
		student.setDateOfBirth(form.datePicker.getDate());
		student.setNationalID(form.jTextField6.getText());
		student.setBloodGroup(form.jComboBox1.getSelectedItem().toString());
		student.setStudentCell(form.jTextField8.getText());
		student.setFatherCell(form.jTextField9.getText());
		student.setFatherOccupation(form.jTextField10.getText());
		student.setAddress(form.jTextField11.getText());
		student.setCountry(form.jTextField12.getText());
		student.setEmailID(form.jTextField13.getText());

		Room room = null;

		try {

			room = new RoomDAO().queryForId(Integer.parseInt(form.jComboBox2.getSelectedItem().toString()));

			if (room.getCount()<room.getCapacity()) {

				room.setCount(room.getCount()+1);

			} else {

				room.setFull(true);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} finally {

			DataSource.closeConnection();

		}

		try {

			new RoomDAO().update(room);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} finally {

			DataSource.closeConnection();

		}

		try {

			student.setRoom(room);
			new StudentDAO().create(student);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} finally {

			DataSource.closeConnection();

		}

		for (Qualification qualification : form.qualificationData) {

			qualification.setStudent(student);

			try {

				new QualificationDAO().create(qualification);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

		}

		ServiceRegistration registration = new ServiceRegistration();
		registration.setStudent(student);
		Service service = null;

		if (form.jCheckBox0.isSelected()) {

			try {

				service = new ServiceDAO().queryForId("Mess");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

			try {

				registration.setService(service);
				new ServiceRegistrationDAO().create(registration);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

		}

		if (form.jCheckBox1.isSelected()) {

			try {

				service = new ServiceDAO().queryForId("Internet");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

			try {

				registration.setService(service);
				new ServiceRegistrationDAO().create(registration);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

		}

		String[] serviceTitle = {"Gas","Electricity"};

		for (int i = 0; i < serviceTitle.length; i++) {

			try {

				service = new ServiceDAO().queryForId(serviceTitle[i]);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

			try {

				registration.setService(service);
				new ServiceRegistrationDAO().create(registration);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

		}


		return true;
	}

	public boolean isStudentIDExist(String id) {

		try {

			return new StudentDAO().queryForId(id.toUpperCase())!=null;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		return false;
	}

	public boolean updateStudent(UpdateStudentForm form) {

		//boolean deleteStudent = Database.executeDelete("DELETE FROM STUDENT WHERE STD_ID = '"+form.jTextField0.getText().toUpperCase()+"'");
		boolean deleteQualification = Database.executeDelete("DELETE FROM QUALIFICATION WHERE STD_ID = '"+form.jTextField0.getText().toUpperCase()+"'");

		if (deleteQualification) {

			Student student = null;

			try {

				student = new StudentDAO().queryForId(form.jTextField0.getText().toUpperCase());

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			student.setName(form.jTextField1.getText());
			student.setFatherName(form.jTextField2.getText());
			student.setAge(Integer.parseInt(form.jTextField3.getText()));
			student.setGender(form.jComboBox0.getSelectedItem().toString());
			//student.setDateOfBirth(form.jTextField5.getText());
			student.setDateOfBirth(form.datePicker.getDate());
			student.setNationalID(form.jTextField6.getText());
			student.setBloodGroup(form.jComboBox1.getSelectedItem().toString());
			student.setStudentCell(form.jTextField8.getText());
			student.setFatherCell(form.jTextField9.getText());
			student.setFatherOccupation(form.jTextField10.getText());
			student.setAddress(form.jTextField11.getText());
			student.setCountry(form.jTextField12.getText());
			student.setEmailID(form.jTextField13.getText());

			Room room = null;

			try {

				room = new RoomDAO().queryForId(Integer.parseInt(form.jComboBox2.getSelectedItem().toString()));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

			RoomDAO.roomMigration(student.getRoom().getNo(), room.getNo());

			try {

				student.setRoom(room);
				new StudentDAO().update(student);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			} finally {

				DataSource.closeConnection();

			}

			for (Qualification qualification : form.qualificationData) {

				qualification.setStudent(student);

				try {

					new QualificationDAO().create(qualification);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;

				} finally {

					DataSource.closeConnection();

				}

			}

			boolean isMessSelected = ServiceRegistrationDAO.isServiceRegisteredByStudent(form.jTextField0.getText(), "Mess");
			boolean isInternetSelected = ServiceRegistrationDAO.isServiceRegisteredByStudent(form.jTextField0.getText(), "Internet");

			if (form.jCheckBox0.isSelected()) {

				if (!isMessSelected) {

					try {

						new ServiceRegistrationDAO().create(new ServiceRegistration(student, new ServiceDAO().queryForId("Mess")));

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();

					} finally {

						DataSource.closeConnection();

					}

				}

			} else {

				if (isMessSelected) {

					try {

						new ServiceRegistrationDAO().delete(new ServiceRegistration(student, new ServiceDAO().queryForId("Mess")));

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();

					} finally {

						DataSource.closeConnection();

					}

				} 

			}

			if (form.jCheckBox1.isSelected()) {

				if (!isInternetSelected) {

					try {

						new ServiceRegistrationDAO().create(new ServiceRegistration(student, new ServiceDAO().queryForId("Internet")));

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return false;

					} finally {

						DataSource.closeConnection();

					}

				}

			} else {

				if (isInternetSelected) {

					try {

						new ServiceRegistrationDAO().delete(new ServiceRegistration(student, new ServiceDAO().queryForId("Internet")));

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return false;

					} finally {

						DataSource.closeConnection();

					}

				} 

			}

		} else {

			return false;

		}

		return true;
	}

}
