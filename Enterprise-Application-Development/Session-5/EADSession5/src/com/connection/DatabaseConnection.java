package com.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection{
	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException{  
		InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties");
		Properties property = new Properties();  
		property.load(inputStream);

		Class.forName(property.getProperty("DRIVER"));
		return DriverManager.getConnection(property.getProperty("HOSTNAME")+property.getProperty("DATABASE"), 
				property.getProperty("USERNAME"), property.getProperty("PASSWORD"));
	}
}
