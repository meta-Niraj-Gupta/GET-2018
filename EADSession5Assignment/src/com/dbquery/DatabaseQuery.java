package com.dbquery;

public class DatabaseQuery{
	public static final String INSERT_INTO_ADVERTISMENT = "INSERT INTO advertisement "
			+ "(title, description, category_id) VALUES (?,?,?)";
	
	public static final String SELECT_FROM_ADVERTISMENT = "SELECT id, title, description, "
			+ "category_id FROM advertisement WHERE id = ?";
	
	public static final String SELECT_ALL_FROM_ADVERTISMENT_HAVING_ID = "SELECT id, title, description, "
			+ "category_id FROM advertisement WHERE category_id = ?";
	
	public static final String SELECT_ALL_FROM_ADVERTISMENT = "SELECT id, title, description, category_id"
			+ " FROM advertisement";
	
	public static final String UPDATE_ADVERTISMENT_TITLE = "UPDATE advertisement SET title = ? WHERE id = ?";
	
	public static final String DELETE_ADVERTISMENT = "DELETE FROM advertisement WHERE id = ?";
	
	public static final String INSERT_CATEGORY = "INSERT INTO category (name) VALUES (?)";
	
	public static final String SELECT_CATEGORY_BY_ID = "SELECT id, name FROM category WHERE id = ?";
	
	public static final String SELECT_ALL_CATEGORY = "SELECT id, name FROM category";
	
	public static final String UPDATE_CATEGORY_BY_ID = "UPDATE category SET name = ? WHERE id = ?";
	
	public static final String DELETE_CATEGORY_BY_ID = "DELETE FROM Category WHERE id = ?";
}
