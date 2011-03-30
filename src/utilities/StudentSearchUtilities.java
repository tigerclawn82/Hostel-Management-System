package utilities;

import java.util.ArrayList;
import java.util.List;

import dao.QualificationDAO;
import dao.StudentDAO;
import db.DataSource;
import db.Database;
import bean.Qualification;
import bean.Student;

public class StudentSearchUtilities {

	public Student getStudentByID(String id) {

		Student student = null;

		try {

			student = new StudentDAO().queryForId(id.toUpperCase());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}


		return student;
	}

	public List<Qualification> getStudentQualificationByID(String id){

		List<Qualification> qualificationData = new ArrayList<Qualification>();
		List<Qualification> queryForAll = null;

		try {

			queryForAll = new QualificationDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		for (Qualification qualification : queryForAll) {

			if (qualification.getStudent().getId().equalsIgnoreCase(id)) {

				qualificationData.add(qualification);

			}

		}

		return qualificationData;
	}

	public String[] getStudentServicesByID(String id) {

		Object[][] serviceData = Database.executeSelect("SELECT S_TITLE FROM STD_SER WHERE STD_ID = '"+id.toUpperCase()+"'");
		String[] serviceTitle = new String[serviceData.length];

		for (int i = 0; i < serviceData.length; i++) {

			serviceTitle[i] = serviceData[i][0].toString();

		}

		return serviceTitle;
	}

	public Student getStudentByNIC(String NIC) {

		List<Student> studentList = null;

		try {

			studentList = new StudentDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		for (Student student : studentList) {

			if (student.getNationalID().equalsIgnoreCase(NIC)) {

				return student;

			}

		}


		return null;
	}

	public List<Qualification> getStudentQualificationByNIC(String NIC){

		List<Qualification> qualificationData = new ArrayList<Qualification>();
		List<Qualification> queryForAll = null;

		try {

			queryForAll = new QualificationDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}

		for (Qualification qualification : queryForAll) {

			if (qualification.getStudent().getNationalID().equalsIgnoreCase(NIC)) {

				qualificationData.add(qualification);

			}

		}

		return qualificationData;
	}

	public String[] getStudentServicesByNIC(String NIC) {

		Object[][] serviceData = null;
		serviceData = Database.executeSelect("SELECT STD_ID FROM STUDENT WHERE STD_NIC = '"+NIC+"'");
		String id = serviceData[0][0].toString();

		serviceData = Database.executeSelect("SELECT S_TITLE FROM STD_SER WHERE STD_ID = '"+id.toUpperCase()+"'");
		String[] serviceTitle = new String[serviceData.length];

		for (int i = 0; i < serviceData.length; i++) {

			serviceTitle[i] = serviceData[i][0].toString();

		}

		return serviceTitle;
	}

	public Object[] getStudentsByName(String name) {

		List<Student> studentList = null;
		ArrayList<String> studentID = new ArrayList<String>();

		try {

			studentList = new StudentDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}


		for (Student student : studentList) {

			if (student.getName().toLowerCase().contains(name.toLowerCase())) {

				studentID.add(student.getId());

			}

		}

		return studentID.toArray();	
	}

	public Object[] getStudentsByFatherName(String fatherName) {

		List<Student> studentList = null;
		ArrayList<String> studentID = new ArrayList<String>();

		try {

			studentList = new StudentDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}


		for (Student student : studentList) {

			if (student.getFatherName().toLowerCase().contains(fatherName.toLowerCase())) {

				studentID.add(student.getId());

			}

		}

		return studentID.toArray();	
	}
	
	public Object[] getAllStudents() {

		List<Student> studentList = null;
		ArrayList<String> studentID = new ArrayList<String>();

		try {

			studentList = new StudentDAO().queryForAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			DataSource.closeConnection();

		}


		for (Student student : studentList) {

			studentID.add(student.getId());

		}

		return studentID.toArray();	
	}

}
