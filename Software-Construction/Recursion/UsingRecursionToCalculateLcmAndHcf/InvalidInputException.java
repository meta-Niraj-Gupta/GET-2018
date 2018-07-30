package UsingRecursionToCalculateLcmAndHcf;

/**
 * @author Niraj Gupta
 * Class to handle the invalid input from the user.
 */
public class InvalidInputException extends Exception{
	
	/**
	 * Parametrized constructor
	 * @param message : the message to be displayed to user if he enters an invalid input.
	 */
	public InvalidInputException(String message) {
		super(message);
	}
}
