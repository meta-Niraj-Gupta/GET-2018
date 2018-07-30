package ShoppingCartWithPromotion;

/**
 * @author Niraj Gupta
 * This class is an error class which extends the Exception class and it gives an error message to user if the product he wants to add in 
 * the shopping cart is not available in the stock.
 *
 */
public class ItemNotFoundException extends Exception{
	public ItemNotFoundException(String errorMessage){
		super(errorMessage);
	}
}
