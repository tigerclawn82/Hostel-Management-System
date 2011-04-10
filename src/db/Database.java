package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {

	private static String URL = "jdbc:h2:/"+System.getProperty("user.dir")+"/HMS;AUTO_SERVER=TRUE;MODE=MSSQLServer";
	private static Connection connection = null;
	private static Statement statement = null;

	public static PreparedStatement getPreparedStatement(String sql) {

		PreparedStatement pStatement = null;

		if (openConnection()) {

			try {

				pStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_UPDATABLE);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}

		} else {

			return null;

		}

		return pStatement;
	}

	public static boolean openConnection(){

		if (connection==null) {

			try {

				Class.forName("org.h2.Driver");
				connection = DriverManager.getConnection(URL);

				System.out.println("CONNECTED!!!");

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}

		} else {

			return true;
		}


		return true;
	}

	public static boolean openConnection(boolean autoCommit){

		if (connection==null) {

			try {

				Class.forName("org.h2.Driver");
				connection = DriverManager.getConnection(URL);
				connection.setAutoCommit(autoCommit);

				System.out.println("CONNECTED!!!");

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}

		} else {

			return true;
		}


		return true;
	}

	public static boolean closeConnection(){

		try {

			if (connection!=null) {

				connection.close();
				connection = null;
				System.out.println("DIS-CONNECTED!!!");

			} else {

				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean executeInsert(String sql){

		try {

			if (openConnection()) {

				statement = connection.createStatement();

				statement.execute(sql);
				return true;

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {

			closeConnection();

		}

	}

	public static boolean executeInsert(PreparedStatement pStatement){

		try {

			if (openConnection()) {

				pStatement.execute();
				return true;

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {

			closeConnection();

		}

	} 

	public static Object[][] executeSelect(String sql){

		Object[][] dataSet = null;

		try {

			ResultSet result = selectExecutor(sql);
			result.last();
			int rows = result.getRow();
			result.absolute(0);
			int columns = result.getMetaData().getColumnCount();
			dataSet = new Object[rows][columns];

			for (int i = 0; result.next(); i++) {

				for (int j = 0; j < columns; j++) {

					dataSet[i][j] = result.getString(j+1);

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			closeConnection();

		}

		return dataSet;
	}

	public static Object[][] executeSelect(PreparedStatement pStatement){

		Object[][] dataSet = null;

		try {

			ResultSet result = selectExecutor(pStatement);
			result.last();
			int rows = result.getRow();
			result.absolute(0);
			int columns = result.getMetaData().getColumnCount();
			dataSet = new Object[rows][columns];

			for (int i = 0; result.next(); i++) {

				for (int j = 0; j < columns; j++) {

					dataSet[i][j] = result.getString(j+1);

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			closeConnection();

		}

		return dataSet;
	}

	public static ResultSet selectExecutor(String sql){

		try {

			if (openConnection()) {

				statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);

				return statement.executeQuery(sql);

			} else {

				return null;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} 

	}

	public static ResultSet selectExecutor(PreparedStatement pStatement){

		try {

			if (openConnection()) {

				return pStatement.executeQuery();

			} else {

				return null;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} 

	}

	public static boolean executeUpdate(String sql){

		try {

			if (openConnection()) {

				statement = connection.createStatement();
				statement.executeUpdate(sql);

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {

			closeConnection();

		}

		return true;
	}

	public static boolean executeDelete(String sql){

		try {

			if (openConnection()) {

				statement = connection.createStatement();
				statement.execute(sql);

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {

			closeConnection();

		}

		return true;
	}

	public static boolean executeSQL(String sql){

		try {

			if (openConnection()) {

				statement = connection.createStatement();
				statement.execute(sql);

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {

			closeConnection();

		}

		return true;
	}

	public static boolean executeTransaction(String... queries){

		StringBuilder sql = new StringBuilder();

		for (String query : queries) {

			sql.append(query+";\n");

		}

		try {

			if (openConnection(false)) {

				statement = connection.createStatement();
				statement.execute(sql.toString());
				connection.commit();

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {

			closeConnection();

		}

		return true;
	}

}
