package ShoppingCartWithPromotion;

public class Item {
	private int productID;
	private double productCost;
	private String productName;
	
	/**
	 * This is a constructor accepts three arguments and creates a new object of calss Items
	 * @param id	The id of the product which is also key while storing in hashmap.
	 * @param price	The price of the product. 
	 * @param name	The name of the product.
	 */
	public Item(int id, float price, String name){
		productID = id;
		productCost = price;
		productName = name;
	}
	
	/**
	 * This method return the ID of the product
	 * @return id of the product
	 */
	public int getProductId(){
		return productID;
	}
	
	/**
	 * This method return the rate of the product
	 * @return cost of the product
	 */
	public double getProductCost(){
		return productCost;
	}
	
	/**
	 * This method return the name of the product
	 * @return Name of the product
	 */
	public String getProductName(){
		return productName;
	}
}
