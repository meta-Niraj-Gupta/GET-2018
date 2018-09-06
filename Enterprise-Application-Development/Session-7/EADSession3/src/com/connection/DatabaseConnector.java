package com.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


public class DatabaseConnector{
	
	private DataSource dataSource;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		return dataSource.getConnection();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
