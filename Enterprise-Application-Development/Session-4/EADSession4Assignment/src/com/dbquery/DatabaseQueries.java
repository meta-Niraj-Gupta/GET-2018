package com.dbquery;

public class DatabaseQueries{
	public final static String ADD_USER_QUERY = "INSERT INTO user_detail (firstname, lastname, "
			+ "birthdate, organization, mobilenumber, email, password, image) VALUES (?,?,?,?,?,?,?,?)";

	public final static String FETCH_USER_DETAIL = "SELECT id, firstname, lastname, mobilenumber,"
			+ "birthdate, organization, email, password, image FROM user_detail WHERE email = ? AND password = ?";

	public final static String FETCH_FRIEND_LIST = "SELECT id, firstname, lastname, mobilenumber,"
			+ "birthdate, organization, email, password, image FROM user_detail WHERE organization = ? AND email <> ?";

	public final static String UPDATE_USER_DETAIL = "UPDATE user_detail SET firstname = ?, lastname = ?,"
			+ "mobilenumber = ?, birthdate = ?, organization = ?, email = ?, password = ? WHERE id = ? ";

	public final static String FETCH_USER_BY_EMAIL = "SELECT id, firstname, lastname, mobilenumber,"
			+ "birthdate, organization, email, password, image FROM user_detail WHERE email = ?";
	
	public final static String UPADTE_USER_IMAGE = "UPDATE user_detail SET image = ? WHERE id = ?";
}
