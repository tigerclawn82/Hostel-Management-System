package main;

import java.sql.SQLException;
import java.util.Date;

import dao.QualificationDAO;
import dao.RoomDAO;
import dao.ServiceDAO;
import dao.ServiceRegistrationDAO;
import dao.StudentDAO;
import db.DataSource;
import bean.Qualification;
import bean.Room;
import bean.Service;
import bean.ServiceRegistration;
import bean.Student;

public class StudentRegistration {

	public static void main(String[] args) {

		Student student = new Student();

		student.setId("020-BSCS-09");
		student.setName("Waqas Ahmed");
		student.setFatherName("Muhammad Ashraf");
		student.setAge(20);
		student.setGender("Male");
		student.setDateOfBirth(new Date());
		student.setNationalID("36502-2116542-5");
		student.setBloodGroup("O+");
		student.setStudentCell("0321-6939134");
		student.setFatherCell("0301-6520082");
		student.setFatherOccupation("Business");
		student.setAddress("Lhr");
		student.setCountry("Pakistan");
		student.setEmailID("tigerclawn82@gmail.com");

		Room room = new Room();
		room.setNo(1);
		room.setLocation("2nd Floor");
		room.setCount(0);
		room.setCapacity(4);
		room.setFull(false);

		try {

			new RoomDAO().create(room);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		student.setRoom(room);

		try {

			new StudentDAO().create(student);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		Qualification qualification = new Qualification();
		qualification.setTitle("BSCS");
		qualification.setInstitute("GCU");
		qualification.setYearOfPassing("2010");
		qualification.setTotalMarks(100);
		qualification.setObtainedMarks(85);
		qualification.setPercentage(85);
		qualification.setStudent(student);
		
		try {
			
			new QualificationDAO().create(qualification);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {

			DataSource.closeConnection();

		}

		Service service = new Service();
		service.setTitle("Mess");
		service.setType("Mendatory");
		service.setCharge(1200);
		service.setChargeType("Monthly");
		
		try {
			
			new ServiceDAO().create(service);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {

			DataSource.closeConnection();

		}

		ServiceRegistration registration = new ServiceRegistration();
		registration.setStudent(student);
		registration.setService(service);
		
		try {
			
			new ServiceRegistrationDAO().create(registration);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {

			DataSource.closeConnection();

		}

	}

}
