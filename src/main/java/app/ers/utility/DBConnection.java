package app.ers.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	public static final String DRIVER = "org.postgresql.Driver";
	public static final String DBURL= "jdbc:postgresql://localhost:5432/postgres";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
