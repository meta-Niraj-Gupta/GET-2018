package Calculator;
/**
 * @author Niraj Gupta
 * Calss HexCalc is the implementation of the interface ArithmeticCalculations and have following behaviours:
 * 1. It can compute the addition of two hexadecimal numbers.
 * 2. It can compute the subtraction of two hexadecimal numbers.
 * 3. It can compute the multiplication of two hexadecimal numbers.
 * 4. It can compute the division of two hexadecimal numbers.
 * 5. It can check whether two hexadecimal numbers are equal or not.
 * 6. It can check whether the first hexadecimal numbers is greater than second hexadecimal number or not.
 * 7. It can check whether the first hexadecimal numbers is less than second hexadecimal number or not.
 * 8. It can also be used to convert from hexadecimal to decimal and vice versa.
 */
public class HexCalc implements ArithmeticCalculations{ 
	
	/**
	 * This method adds two hexadecimal values by first converting them into decimal
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return the hexadecimal number after addition of two hexadecimal number in string format
	 */
	@Override
	public String add(String value1, String value2){
		return convertFromDecimalToHex(Integer.parseInt(convertFromHexToDecimal(value1.toUpperCase())) 
										+ Integer.parseInt(convertFromHexToDecimal(value2.toUpperCase())));
	}
	
	/**
	 * This method subtracts two hexadecimal values by first converting them into decimal
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return the hexadecimal number after subtraction of two hexadecimal number in string format
	 * @throws CannotSubtractException 
	 * @throws CannotSubtractNumber 
	 */
	@Override
	public String subtract(String value1, String value2) throws CannotSubtractException{
		int subtraction = Integer.parseInt(convertFromHexToDecimal(value1.toUpperCase())) 
				- Integer.parseInt(convertFromHexToDecimal(value2.toUpperCase()));
		if(subtraction < 0){
			throw new CannotSubtractException("Invalid Input : The first number must be greater than second number");
		}
		return convertFromDecimalToHex(subtraction);
	}
	/**
	 * This method multiply two hexadecimal values by first converting them into decimal
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return the hexadecimal number after multiply of two hexadecimal number in string format
	 */
	@Override
	public String multiply(String value1, String value2){
		return convertFromDecimalToHex(Integer.parseInt(convertFromHexToDecimal(value1.toUpperCase())) 
										* Integer.parseInt(convertFromHexToDecimal(value2.toUpperCase())));
	}
	/**
	 * This method divide two hexadecimal values by first converting them into decimal
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return the hexadecimal number after division of two hexadecimal number in string format
	 */
	@Override
	public String divide(String value1, String value2){
		return convertFromDecimalToHex(Integer.parseInt(convertFromHexToDecimal(value1.toUpperCase())) 
										/ Integer.parseInt(convertFromHexToDecimal(value2.toUpperCase())));
	}
	
	/**
	 * This method check if two hexadecimal numbers are equal or not without converting them into decimal.
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return true if both the hexadecimal number are equal otherwise it returns false
	 */
	@Override
	public boolean equalsTo(String value1, String value2){
		if(value1.equalsIgnoreCase(value2)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * This method check if the first hexadecimal numbers is greater than the second hexadecimal number without converting them into decimal.
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return true if the first hexadecimal number is greater than second, otherwise it returns false
	 */
	@Override
	public boolean greaterThan(String value1, String value2){
		if(value1.length() > value2.length()){
			return true;
		}else if(value1.length() == value2.length()){
			for(int i = 0; i < value1.length(); i++){
				if(value1.charAt(i) == value2.charAt(i)){
					continue;
				}else if(value1.charAt(i) > value2.charAt(i)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	/**
	 * This method check if the first hexadecimal numbers is less than the second hexadecimal number without converting them into decimal.
	 * @param value1 the first hexadecimal number
	 * @param value2 the second hexadecimal number
	 * @return true if the first hexadecimal number is less than second, otherwise it returns false
	 */
	@Override
	public boolean lessThan(String value1, String value2){
		if(value1.length() < value2.length()){
			return true;
		}else if(value1.length() == value2.length()){
			for(int i = 0; i < value1.length(); i++){
				if(value1.charAt(i) == value2.charAt(i)){
					continue;
				}else if(value1.charAt(i) < value2.charAt(i)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method convert the hexadecimal number into decimal value.
	 * @param value is a string of hexadecimal number which is to be converted into decimal
	 * @return the string of decimal value
	 */
	public String convertFromHexToDecimal(String value){
		int length = value.length();
		int decimalValue = 0;
		for(int i = 0; i < value.length(); i++){
			if(isDigit(value.charAt(i))){
				decimalValue += Integer.parseInt(String.valueOf(value.charAt(i))) * Math.pow(16, --length);
			}else{
				decimalValue += Integer.parseInt(String.valueOf(valueOfTheAlphabet(value.charAt(i)))) * Math.pow(16, --length);
			}
		}
		return Integer.toString(decimalValue);
	}
	
	/**
	 * This method converts decimal number to hexadecimal number
	 * @param value is a string of decimal number which is to be converted into hexadecimal
	 * @return the string of hexadecimal number
	 */
	public String convertFromDecimalToHex(int value){
		int decimalToHex = value;
		String hexValue = "";
		while(decimalToHex > 0){
			int remainder = decimalToHex % 16;
			if(remainder > 9){
				String str = valueOfInteger(remainder);
				hexValue += str;
			}else{
				hexValue += Integer.toString(remainder);
			}
			decimalToHex /= 16;
		}
		StringBuilder str = new StringBuilder(hexValue);
		return str.reverse().toString();
	}
	
	/**
	 * This method is used to check if the particular character of the string is a digit or not
	 * @param element is the character which is to be checked whether it is a digit or not
	 * @return true if the element is digit, false otherwise
	 */
	public boolean isDigit(char element){
		if(element >= '0' && element <= '9'){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * This method is used to convert the alphabet value in hexadecimal representation into there corresponding digit value.
	 * @param character accepts a char which is to be converted into the digit,
	 * @return the string of digit corresponding to the provided char value.
	 */
	public String valueOfTheAlphabet(char character){
		if(character == 'A'){
			return "10";
		}else if(character == 'B'){
			return "11";
		}else if(character == 'C'){
			return "12";
		}else if(character == 'D'){
			return "13";
		}else if(character == 'E'){
			return "14";
		}else{
			return "15";
		}
	}
	
	/**
	 * This method is used to convert the digit value in hexadecimal which is greater than 9 to its alphabetic representation
	 * @param number accepts an Integer which is to be converted into the alphabet,
	 * @return the string of value corresponding to the provided integer value.
	 */
	public String valueOfInteger(int number){
		if(number == 10){
			return "A";
		}else if(number == 11){
			return "B";
		}else if(number == 12){
			return "C";
		}else if(number == 13){
			return "D";
		}else if(number == 14){
			return "E";
		}else{
			return "F";
		}
	}
}
