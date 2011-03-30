package db;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class DataSource {
	
	private static ConnectionSource connectionSource = null;
	private static String URL = "jdbc:h2:/"+System.getProperty("user.dir")+"/HMS";
	
	public static boolean openConnection() {
		
		try {
			
			connectionSource = new JdbcConnectionSource(URL);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean closeConnection() {
		
		if (connectionSource!=null) {
			
			try {
				
				connectionSource.close();
				connectionSource = null;
				System.out.println("DIS-CONNECTED!!!");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} else {
			
			return false;
			
		}
		
		return true;
	}
	
	public static ConnectionSource getConnectionSource() {
		
		if (connectionSource==null) {
			
			if (openConnection()) {
				
				System.out.println("CONNECTED!!!");
				return connectionSource;
				
			} else {
				
				return null;
				
			}
			
		}
		
		return connectionSource;
	}

}
