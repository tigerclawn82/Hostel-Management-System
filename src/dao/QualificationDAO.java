package dao;

import java.sql.SQLException;

import bean.Qualification;

public class QualificationDAO extends DAO<Qualification, String>{

	public QualificationDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		super(Qualification.class);
	}
	
}
