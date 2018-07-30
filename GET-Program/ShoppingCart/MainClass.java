package ShoppingCart;

import java.util.HashMap;

/**
 * @author Niraj Gupta
 * This class is the main class having main function which is required to check if the methods implemented in class Item and 
 * OrderedItemInCart are working properly or not.
 *
 */
public class MainClass {
	public static void main(String args[]){
		OrderedItemsInCart.product = new HashMap<Integer,Item> ();
		OrderedItemsInCart.product.put(1,new Item(1, 5000, "Monitor"));
		OrderedItemsInCart.product.put(2,new Item(2, 500, "Mouse"));
		OrderedItemsInCart.product.put(3,new Item(3, 800, "Keyboard"));
		OrderedItemsInCart.product.put(4,new Item(4, 4500, "Hard Drive"));
		OrderedItemsInCart.product.put(4,new Item(4, 700, "Flash Drive"));
	
		OrderedItemsInCart cart = new OrderedItemsInCart();
	
		cart.addProductToCart(1, 1);
		cart.addProductToCart(2,1);
		cart.addProductToCart(3,1);
		cart.editProductQuantity(2,3);
		cart.addProductToCart(4,4);
		cart.printCartItems();
		cart.addProductToCart(3, 2);
		cart.removeProductFromCart(4);
		cart.printCartItems();
		cart.generateBill();
	}
}
