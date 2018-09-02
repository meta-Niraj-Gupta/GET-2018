package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.DatabaseConnection;
import com.dbquery.DatabaseQuery;
import com.pojo.Advertisement;

public class AdvertismentDAO{
	private Connection connection;

	public AdvertismentDAO() throws ClassNotFoundException, SQLException, IOException{
		connection = DatabaseConnection.getConnection();
	}

	public void addAdvertisment(Advertisement advertisement) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.INSERT_INTO_ADVERTISMENT);
		statement.setString(1, advertisement.getAdvetismentTitle());
		statement.setString(2, advertisement.getAdvertismentDescription());
		statement.setInt(3, advertisement.getCategoryId());
		statement.executeUpdate();
	}

	public Advertisement getAdvertisment(int id) throws SQLException{
		Advertisement advertisement = null;
		PreparedStatement statement = connection
				.prepareStatement(DatabaseQuery.SELECT_FROM_ADVERTISMENT);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			advertisement = new Advertisement();
			advertisement.setCategoryId(resultSet.getInt("category_id"));
			advertisement.setId(resultSet.getInt("id"));
			advertisement.setAdvetismentTitle(resultSet.getString("title"));
			advertisement.setAdvertismentDescription(resultSet.getString("description"));
		}
		return advertisement;
	}

	public List<Advertisement> getAllAdvertisment(int id) throws SQLException{
		List<Advertisement> advertisements = new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.SELECT_ALL_FROM_ADVERTISMENT_HAVING_ID);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Advertisement advertisement = new Advertisement();
			advertisement.setCategoryId(resultSet.getInt("category_id"));
			advertisement.setId(resultSet.getInt("id"));
			advertisement.setAdvertismentDescription(resultSet.getString("title"));
			advertisement.setAdvertismentDescription(resultSet.getString("description"));
			advertisements.add(advertisement);
		}
		return advertisements;
	}

	public List<Advertisement> getAll() throws SQLException{
		List<Advertisement> advertisements = new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.SELECT_ALL_FROM_ADVERTISMENT);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Advertisement advertisement = new Advertisement();
			advertisement.setCategoryId(resultSet.getInt("category_id"));
			advertisement.setId(resultSet.getInt("id"));
			advertisement.setAdvetismentTitle(resultSet.getString("title"));
			advertisement.setAdvertismentDescription(resultSet.getString("description"));
			advertisements.add(advertisement);
		}
		return advertisements;
	}

	public boolean updateAdvertismentTitle(int id, String title) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.UPDATE_ADVERTISMENT_TITLE);
		statement.setString(1, title);
		statement.setInt(2, id);
		return 1 == statement.executeUpdate();
	}

	public boolean removeAdvertisment(int id) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.DELETE_ADVERTISMENT);
		statement.setInt(1, id);
		return 1 == statement.executeUpdate();
	}
}
