package com.doa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.DatabaseConnection;
import com.dbquery.DatabaseQueries;
import com.pojo.User;

public class DatabaseOperation{
	private Connection connection;

	public DatabaseOperation() throws ClassNotFoundException, SQLException, IOException{
		connection = DatabaseConnection.getConnection();
	}

	public int addUser(User user) throws SQLException, FileNotFoundException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQueries.ADD_USER_QUERY);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setDate(3, user.getBirthDate());
		statement.setString(4, user.getOrganization());
		statement.setString(5, user.getMobileNumber());
		statement.setString(6, user.getEmail());
		statement.setString(7, user.getPassword());
		File image = new File("C:/Users/Brothers/eclipse-workspace/EADSession4Assignment/WebContent/defaultProfilePic.jpg");
		InputStream inputImage = new FileInputStream(image);
		statement.setBinaryStream(8, inputImage, (int)(image.length()));
		return statement.executeUpdate();
	}

	public User fetchUserEmailPassword(String email, String password) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQueries.FETCH_USER_DETAIL);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			return new User(resultSet.getInt("id"), 
					resultSet.getString("firstname"), 
					resultSet.getString("lastname"), 
					resultSet.getString("mobilenumber"),
					resultSet.getDate("birthdate"),
					resultSet.getString("organization"),
					resultSet.getString("email"), 
					resultSet.getString("password"),
					resultSet.getBlob("image"));
		}else{
			return null;
		}
	}

	public List<User> getFriendList(String organization, String email) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQueries.FETCH_FRIEND_LIST);
		statement.setString(1, organization);
		statement.setString(2, email);
		ResultSet resultSet = statement.executeQuery();
		List<User> users = new ArrayList<>();
		while(resultSet.next()){
			users.add(new User(
					resultSet.getInt("id"), 
					resultSet.getString("firstname"), 
					resultSet.getString("lastname"), 
					resultSet.getString("mobilenumber"),
					resultSet.getDate("birthdate"),
					resultSet.getString("organization"),
					resultSet.getString("email"), 
					resultSet.getString("password"),
					resultSet.getBlob("image")));
		}
		return users;
	}

	public int updateUserDetail(User user) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQueries.UPDATE_USER_DETAIL);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getMobileNumber());
		statement.setDate(4, user.getBirthDate());
		statement.setString(5, user.getOrganization());
		statement.setString(6, user.getEmail());
		statement.setString(7, user.getPassword());
		statement.setInt(8, user.getId());
		return statement.executeUpdate();
	}

	public User fetchUserByEmail(String email) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQueries.FETCH_USER_BY_EMAIL);
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			return new User(resultSet.getInt("id"), 
					resultSet.getString("firstname"), 
					resultSet.getString("lastname"), 
					resultSet.getString("mobilenumber"),
					resultSet.getDate("birthdate"),
					resultSet.getString("organization"),
					resultSet.getString("email"), 
					resultSet.getString("password"),
					resultSet.getBlob("image"));
		}else{
			return null;
		}
	}

	public int updateImage(String filePath, Integer id) throws SQLException, FileNotFoundException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQueries.UPADTE_USER_IMAGE);
		File image = new File(filePath);
		InputStream inputImage = new FileInputStream(image);
		statement.setBinaryStream(1, inputImage, (int)(image.length()));
		statement.setInt(2, id);
		return statement.executeUpdate();
	}
}
