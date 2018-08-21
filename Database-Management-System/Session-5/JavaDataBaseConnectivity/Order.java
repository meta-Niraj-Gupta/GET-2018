package JavaDataBaseConnectivity;

import java.sql.Date;

/**
 * @author Niraj Gupta
 * Class to get or set the fields of the order table in storefront database.
 * It is a simple POJO class containing setters and getters.
 */
public class Order{
	private int orderId;
	private Date orderDate;
	private double amount;

	public int getOrderId(){
		return orderId;
	}

	public Date getOrderDate(){
		return orderDate;
	}

	public double getAmount(){
		return amount;
	}

	public void setOrderId(int orderId){
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate){
		this.orderDate = orderDate;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	@Override
	public String toString(){
		return "Order [orderId = " + orderId + ", orderDate = " + orderDate
				+ ", amount = " + amount + "]";
	}	
}
