package UsingRecursionToCalculateLcmAndHcf;

/**
 * @author Niraj Gupta
 * Class to compute the least commom multiple or LCM and greatest commom divisor or GCD
 */
public class LcmAndHcf{
	
	/**
	 * Method to calculate the least common multiple or LCM of two numbers using recursion
	 * @param number1 : is the first number of type integer
	 * @param number2 : is the second number of type integer
	 * @param multiple : is the minimum value which when divided by number1 and number2 doesn't leave any remainder
	 * @return : the minimum values multiple which is also the LCM of the two numbers
	 * @throws : InvalidInputException if the input are negative
	 */
	public int calculateLeastCommomMultiple(int number1, int number2, int multiple) throws InvalidInputException{
		if(number1 < 0 || number2 < 0){
			throw new InvalidInputException("Invalid Input. Please provide valid positive numbers.");
		}
		if(multiple % number1 == 0 && multiple % number2 == 0){
			return multiple;
		}else{
			return calculateLeastCommomMultiple(number1, number2, ++multiple);
		}
	}
	
	/**
	 * Method to calculate the greatest commom divisor or GCD of two number using recursion
	 * @param number1 : is the first number of type integer
	 * @param number2 : is the second number of type integer
	 * @return : the GCD of two number of type integer
	 * @throws InvalidInputException : when the numbers are negative
	 */
	public int calculateGreatestCommonDivisor(int number1, int number2) throws InvalidInputException{
		if(number1 < 0 || number2 < 0){
			throw new InvalidInputException("Invalid Input. Please provide valid positive numbers.");
		}
		if(number2 == 0){
			return number1;
		}else{
			return calculateGreatestCommonDivisor(number2, number1 % number2);
		}
	}
}
