package JavaDataBaseConnectivity;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to perform few queries on the storefront database which is stored in relational
 * database using MySQL.
 */
public class MySqlQueryClass{
	
	/**
	 * Method to get the total amount of order placed by a user.
	 * @param userId : The user_id which is used to find the order placed by the user.
	 * @return : The list of orders with total amount sorted with respect to the order date.
	 */
	public List<Order> getTotalAmountOfOrderUsingUserID(int userId){
		if(userId < 0){
			System.out.println("Invalid input !!!");
			System.exit(0);
		}

		final String query = "SELECT\r\n"
				+ "pod.order_id,\r\n"
				+ "po.date,\r\n"
				+ "SUM(pod.price * pod.quantity) AS 'amount'\r\n"
				+ "FROM\r\n"
				+ "product p\r\n"
				+ "INNER JOIN\r\n"
				+ "order_detail pod ON p.product_id = pod.product_id\r\n"
				+ "INNER JOIN\r\n"
				+ "product_order po ON po.order_id = pod.order_id\r\n"
				+ "WHERE\r\n" + "pod.status = 'SHIPPED' AND po.user_id = ?\r\n"
				+ "GROUP BY (pod.order_id)\r\n"
				+ "ORDER BY (po.date) DESC";

		List<Order> orders = new ArrayList<Order>();
		try(
				Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				){
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Order order = new Order();
				order.setOrderId(resultSet.getInt("order_id"));
				order.setOrderDate(resultSet.getDate("date"));
				order.setAmount(resultSet.getDouble("price"));
				orders.add(order);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.exit(3);
		}
		return orders;
	}
	
	/**
	 * Method to insert image in the product_image using batch insert.
	 */
	public void batchInsert(){
		final String query = "INSERT INTO product_image (img_url, img_name, product_id) VALUES (?,?,?)";
		try(
				Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				){
			try{
				connection.setAutoCommit(false);
				for(int index = 1; index <= 5; index++){
					statement.setString(1, "img_url" + index);
					statement.setString(2, "img_name" + index);
					statement.setInt(3, 22);
					statement.addBatch();
				}
				int[] totalInsertCount = statement.executeBatch();
				System.out.println(totalInsertCount.length);
				connection.commit();
			}catch(BatchUpdateException batch){
				batch.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.exit(3);
		}
	}
	
	/**
	 * Method to update the product state to inactive if the order is not ordered by any user in last 1 year.
	 * @return : The number of row which are affected by running the update query.
	 */
	public int updateProductActiveState(){
		int affectedRows = 0;
		final String query = "UPDATE product\r\n"
				+ "SET is_active = 0\r\n"
				+ "WHERE product.product_id\r\n"
				+ "NOT IN(\r\n"
				+ "SELECT DISTINCT(od.product_id) \r\n"
				+ "FROM order_detail od INNER JOIN product_order po ON po.order_id = od.order_id\r\n"
				+ "WHERE DATEDIFF(NOW(), po.date) <= 365\r\n"
				+ ") AND is_active = 1";
		try(
				Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				){
			affectedRows = statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			System.exit(3);
		}
		return affectedRows;
	}
	
	/**
	 * Method to get the display the parent category then there sub category and so on.
	 * @return : The list of categories and there sub-categories if any.
	 */
	public List<Category> getCategoryName(){
		List<Category> categories = new ArrayList<Category>();
		Category category = new Category();
		final String query = "SELECT \r\n"
				+ "a.category_name AS 'Top_Category',\r\n"
				+ "COUNT(b.category_name) AS 'Category_Count'\r\n" + "FROM\r\n"
				+ "category a\r\n" + "INNER JOIN\r\n"
				+ "category b ON a.category_id = b.parent_category\r\n"
				+ "GROUP BY (a.category_name)\r\n"
				+ "ORDER BY a.category_name, b.category_name;";
		try(
				Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				){
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				category.setParentCategory(resultSet.getString("Top_Category"));
				category.setCountChildCategory(resultSet.getInt("Category_Count"));
				categories.add(category);
			}
			System.out.println(category.toString());
		}catch(SQLException e){
			e.printStackTrace();
			System.exit(3);
		}
		return categories;
	}
}
