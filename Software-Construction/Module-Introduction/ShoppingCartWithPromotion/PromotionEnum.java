package ShoppingCartWithPromotion;

import java.util.*;

/**
 * @author Niraj Gupta
 * This is an enumeration class having promotion codes as an constant and have following attributes
 * 1. It has a constructor which creates the promo code
 * 2. It can tell you about the start date and end date of the promo code
 * 3. It sets code in hash map 
 * 4. It checks if the promo code is present in hash map or not
 * 5. It returns the promotion code if available in the hash map
 */
public enum PromotionEnum {
	
	//Creating the following enum constants by invoking Constructor
	MONSOON("MONSOON", new GregorianCalendar(2018, 7, 1), new GregorianCalendar(2018, 7, 30)),
	SUMMER("SUMMER", new GregorianCalendar(2018, 6, 1), new GregorianCalendar(2018, 6, 30)),
	WINTER("WINTER", new GregorianCalendar(2018, 11, 1), new GregorianCalendar(2018, 11, 30)),
	SPRING("SPRING", new GregorianCalendar(2018, 5, 1), new GregorianCalendar(2018, 5, 30));
	
	private final String promoCode;
	private final GregorianCalendar startDate;
	private final GregorianCalendar endDate;
	private static Map<String, PromotionEnum> storePromoCode;
	
	/**
	 * Parameterized constructor
	 * @param code : is the promotion code
	 * @param startDate : is the date from which the promotion code is applicable
	 * @param endDate : is the end date after which the promotion code is invalid  
	 */
	PromotionEnum(String code, GregorianCalendar startDate, GregorianCalendar endDate){
		this.promoCode = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * Method to get the start date of the promotion code,
	 * @return : the GregorianCalendar object start date which is nothing but the start date of the promotion code from which it is valid
	 */
	public GregorianCalendar getStartDateOfCode(){
		return this.startDate;
	}
	
	/**
	 * Method to get the end date of the promotion code,
	 * @return : the GregorianCalendar object end date which is nothing but the end date of the promotion code after which it is not valid
	 */
	public GregorianCalendar getEndDateOfCode(){
		return this.endDate;
	}
	
	/**
	 * Method to insert the promotion code in the hash map with their start and end date
	 */
	private static void setCodeToHashMap(){
		storePromoCode = new HashMap<String, PromotionEnum>();
		for(PromotionEnum promo : PromotionEnum.values()){
			storePromoCode.put(promo.promoCode, promo);
		}
	}
	
	/**
	 * Method to checks if the promotion code is present in the hash map and if the code is present than it returns the PromotionEnum object or code
	 * @param code : is the code whose availabilty is checked and if present than the code is returned
	 * @return : the promotion code if present in the hash map
	 */
	public static boolean isValidPromo(String code){
			PromotionEnum.setCodeToHashMap();
		PromotionEnum promotion = PromotionEnum.storePromoCode.get(code);
		GregorianCalendar todayDate = new GregorianCalendar();
		if(storePromoCode.containsKey(code) && todayDate.after(promotion.getStartDateOfCode())
				&& todayDate.before(promotion.getEndDateOfCode())){
			return true;
		}	
		return false;
	}
}
