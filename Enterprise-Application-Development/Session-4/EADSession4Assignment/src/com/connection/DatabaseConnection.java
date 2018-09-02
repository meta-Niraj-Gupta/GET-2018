package com.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection{  
	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException{ 
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Guptafamily@5");
	}
}
