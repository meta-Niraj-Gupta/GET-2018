package JavaDataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Niraj Gupta
 * Class to establish connection between java and the database server using JDBC API.
 */
public class JDBCConnection{
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_NAME = "storefront";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "guptaNiraj";
	
	/**
	 * Method to get the connection for the MySQL server.
	 * @return : The connection to the database server.
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}catch(SQLException e){
			e.printStackTrace();
			System.exit(2);
		}
		return connection;
	}
}
