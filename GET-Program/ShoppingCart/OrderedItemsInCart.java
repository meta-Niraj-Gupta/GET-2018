package ShoppingCart;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Niraj Gupta
 * The class is used to create an reference of OrderedItemsInCart which contains the product id and the quantity of the product. 
 * This calss has following behaviours:
 * 1. The class can be used to add/remove products from cart
 * 2. The class allow user to view at any instance what they have added to their cart
 * 3. The class also generate bills once the product has been finally added to the cart.
 *
 */
public class OrderedItemsInCart {
	
	Map<Integer, Integer> shoppingCart;
	static public Map<Integer, Item> product;
	private double totalShoppingCost;
	
	/**
	 * This is constructor which creats an empty shopping cart which is a hashMap of key value pair of type integer
	 */
	public OrderedItemsInCart(){
		shoppingCart = new HashMap<Integer, Integer>();
		totalShoppingCost = 0.0;
	}
	
	/**
	 * This method adds items to the shopping cart having an product id as key and quantity as its value.
	 * @param productId	The product is used as a key to store value in HashMap named shoppingCart.
	 * @param quantity	The quantity of the product 
	 */
	public void addProductToCart(int productId, int quantity){
		if(shoppingCart.containsKey(productId)){
			editProductQuantity(productId, quantity);
		}
		if(product.containsKey(productId)){
			shoppingCart.put(productId, quantity);
		}else{
			System.out.println("Product with ID " + productId + " is not available.");
		}
		totalShoppingCost += product.get(productId).getProductCost() * quantity;
	}
	
	/**
	 * This method edit the quantity of the already existing item in the shopping cart.
	 * @param productId	The product is used as a key to store value in HashMap named shoppingCart.
	 * @param quantity	The quantity of the product
	 */
	public void editProductQuantity(int productId, int quantity){
		if(shoppingCart.containsKey(productId)){
			shoppingCart.put(productId, shoppingCart.get(productId) + quantity);
		}else{
			System.out.println("Product with ID " + productId + " is not available.");
		}
		totalShoppingCost += product.get(productId).getProductCost() * quantity;
	}
	
	/**
	 * This method removes the product from the shopping cart.
	 * @param productId	The product is used as a key to store value in HashMap named shoppingCart.
	 */
	public void removeProductFromCart(int productId){
		if(shoppingCart.containsKey(productId)){
			totalShoppingCost -= product.get(productId).getProductCost() * shoppingCart.get(productId);
			shoppingCart.remove(productId);
		}
		else{
			System.out.println("Product is not added to the cart hence cannot be removed.");
		}
	}
	
	/**
	 * This method prints the product id, name, rate, quantity and price whenever user wants to see what they have
	 * added to the shopping cart.
	 */
	public void printCartItems(){
		System.out.println("Your Cart Contains following items.");
		System.out.format("\n%-10s %-15s %10s %10s %10s\n", "ProductID", "ProductName", "Quantity");
		for(int id : shoppingCart.keySet()){
			Item item = product.get(id);
			System.out.format("%-10d %-15s %10.2f  %9d %10.2f\n", item.getProductId(), item.getProductName(), shoppingCart.get(id));
		}
	}
	
	/**
	 * This method generates bill which will give information about product id, name, rate, quantity and price and the
	 * total cost.
	 */
	public void generateBill(){
		System.out.println("\n\t\t\t\tInvoice");
		System.out.format("\n%-10s %-15s %10s %10s %10s\n", "ProductID", "ProductName", "Rate", "Quantity", "Price");
		for(int id : shoppingCart.keySet()){
			Item item = product.get(id);
			double itemCost=(item.getProductCost()*shoppingCart.get(id));
			System.out.format("%-10d %-15s %10.2f  %9d %10.2f\n",item.getProductId(),item.getProductName(),item.getProductCost(),shoppingCart.get(id),itemCost);
		}
		System.out.println("\nTotal value added to cart is: " + totalShoppingCost);
	}
}
