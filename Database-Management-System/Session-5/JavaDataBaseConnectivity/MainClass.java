package JavaDataBaseConnectivity;

import java.util.List;
import java.util.Scanner;

/**
 * @author Niraj Gupta
 * Main Class to run the MySqlQueryClass.
 *
 */
public class MainClass{
	public static void main(String[] args){
		MySqlQueryClass mySqlQuery = new MySqlQueryClass();

		System.out.println("Press 1 to get the total amount of a order ordered by a user.");
		System.out.println("Press 2 to batch insert image into product_iamge relation.");
		System.out.println("Press 3 to update the state of the product which were not sold in last 1 year.");
		System.out.println("Press 4 to get the category name and there sub category name and so on.");
		System.out.println("Enter your choice");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter the user id : ");
			int userId = scan.nextInt();
			List<Order> orderTotalAmount = mySqlQuery.getTotalAmountOfOrderUsingUserID(userId);
			for(Order order : orderTotalAmount){
				System.out.println("OrderId = " + order.getOrderId() 
						+ " OrderDate = " + order.getOrderDate() + " TotalAmount = " + order.getAmount());
			}
			break;

		case 2:
			int rowsInserted = mySqlQuery.batchInsert();
			System.out.println(rowsInserted);
			break;

		case 3:
			int rowsAffected = mySqlQuery.updateProductActiveState();
			System.out.println("Number of rows affected after batch insert = " + rowsAffected);
			break;

		case 4:
			List<Category> categories = mySqlQuery.getCategoryName();
			for(Category category : categories){
				System.out.println("ParentCategory = " + category.getParentCategory() 
						+ "\tCountChildCategory = " + category.getCountChildCategory());
			}
			break;

		default:
			System.out.println("Invalid Input : Please enter correct choice.");
		}
		scan.close();
	}
}
