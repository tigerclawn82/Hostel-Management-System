package dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;

import db.DataSource;

public class DAO<T, ID> extends BaseDaoImpl<T, ID> implements Dao<T, ID> {

	public DAO(Class<T> dataClass)
			throws SQLException {
		super(DataSource.getConnectionSource(), dataClass);
		// TODO Auto-generated constructor stub
	}
	
}
