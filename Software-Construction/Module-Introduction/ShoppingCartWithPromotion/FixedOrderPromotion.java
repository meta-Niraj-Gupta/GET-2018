package ShoppingCartWithPromotion;

/**
 * @author Niraj Gupta
 * This class contain following behaviour which are implemented from interface named promotion
 * 1. It set the minimum price of the order
 * 2. It also return the minimum price of the order
 * 3. It set the fixed discount amount which can be applied if the user crossed the range of minimum price on the total cost of the order.
 * 4. It returns the fixed discount amount which is to be applied.
 * 5. It also checks whether the promotion code is valid or not.
 * 6. It sets the promotion code which is to be checked
 * 7. It returns the promotion code
 * 8. It also applies the promotion if applicable. 
 *
 */
public class FixedOrderPromotion implements Promotion{
	private String promotionCode;
	private double minimumPrice;
	private double fixedDiscount;
	
	/**
	 * This method returns the minimum order price after which the promotion code is checked and if applicable then the discount is given
	 * @return : the minimum price of type double
	 */
	@Override
	public double getMinimumPrice(){
		return minimumPrice;
	}
	
	/**
	 * This method set the minimum price of the order after which the promotion code is applicable if entered correctly
	 * @return : doesn't return anythin
	 */
	@Override
	public void setMinimumPrice(double minimumPrice){
		this.minimumPrice = minimumPrice;
		
	}
	
	/**
	 * This method returns the fixed discount which can be given to user if the promotion code entered is correct and if the promotion
	 * is applicable
	 * @return : the fixed discount which is of type double 
	 */
	@Override
	public double getFixedDiscount(){
		return fixedDiscount;
	}
	
	/**
	 * This method sets the fixed discount which can be given to user if the promotion code entered is correct and if the promotion
	 * is applicable.
	 * @return : void
	 */
	@Override
	public void setFixedDiscount(double fixedDiscount){
		this.fixedDiscount = fixedDiscount;
		
	}
	
	/**
	 * This method checks if the promotion code is applicable or not.
	 * @return : returns true if the promotion code is applicable otherwise false 
	 */
	@Override
	public boolean isPromotionApplicable(){
		return PromotionEnum.isValidPromo(this.promotionCode);
	}
	
	/**
	 * This method basically returns the promotion code which is been entered by the user
	 * @return : the promotion code of type string
	 */
	public String getPromotionCode(){
		return promotionCode;
	}
	
	/**
	 * This method set the promotion code to the instance variable promotion code.
	 * @param promotionCode : promo code provided by the user.
	 */
	public void setPromotionCode(String promotionCode){
		this.promotionCode = promotionCode;
	}
	
	/**
	 * This method apply the promotion if applicable by first checking the promotion code by calling the function isPromotionApplicable()
	 * if it returns true than the promotion is applied otherwise no changes are done.
	 * @param promotion : the promotion code passed by the user
	 * @param price : the total price of the shopped products
	 * @return : the price after applying the promotion if applicable otherwise the price is returned
	 */
	public static double applyPromotion(Promotion promotion, double price){
		if (promotion.isPromotionApplicable() && promotion.getMinimumPrice() <= price)
			return price * (100 - promotion.getFixedDiscount()) / 100;
		
		return price;
	}
}
