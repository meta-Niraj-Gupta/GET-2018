package ShoppingCartWithPromotion;

/**
 * @author Niraj Gupta
 * This Interface contain following abstract methods
 * 1. setMinimumPrice() set the minimum price of the order 
 * 2. getMinimumPrice() return the minimum price of the order of type double
 * 3. setFixedDiscount() set the fixed discount amount which can be applied if the user crossed the range of minimum price on the total cost of the order.
 * 4. getFixedDiscount() returns the fixed discount amount which is to be applied of type double
 * 5. isPromotionApplicable() checks whether the promotion code is valid or not and returns boolean true if valid, false otherwise
 * 
 */
public interface Promotion{
	double getMinimumPrice();
	void setMinimumPrice(double minimumPrice);
	double getFixedDiscount();
	void setFixedDiscount(double fixedDiscount);
	boolean isPromotionApplicable();
}
