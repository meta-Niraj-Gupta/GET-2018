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
import com.pojo.Category;

public class CategoryDAO{
	private Connection connection;

	public CategoryDAO() throws ClassNotFoundException, SQLException, IOException{
		connection = DatabaseConnection.getConnection();
	}

	public void addCategory(Category category) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.INSERT_CATEGORY);
		statement.setString(1, category.getCategoryName());
		statement.executeUpdate();
	}

	public Category getCategoryById(int id) throws SQLException{
		Category category = null;
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.SELECT_CATEGORY_BY_ID);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			category = new Category();
			category.setId(resultSet.getInt("id"));
			category.setCategoryName(resultSet.getString("name"));
		}
		return category;
	}

	public List<Category> getAllCategory() throws SQLException{
		List<Category> categories = new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.SELECT_ALL_CATEGORY);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Category category = new Category();
			category.setId(resultSet.getInt("id"));
			category.setCategoryName(resultSet.getString("name"));
			categories.add(category);
		}
		return categories;
	}

	public boolean updateCategoryName(int id, String name) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(DatabaseQuery.UPDATE_CATEGORY_BY_ID);
		statement.setString(1, name);
		statement.setInt(2, id);
		return 1 == statement.executeUpdate();
	}

	public boolean removeCategory(int id) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement(DatabaseQuery.DELETE_CATEGORY_BY_ID);
		stmt.setInt(1, id);
		return 1 == stmt.executeUpdate();
	}
}
