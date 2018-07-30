package OperationsOnArray;

/**
 * @author Niraj Gupta
 * Class to handle the exception when a user enters an empty array for performing operations.
 */
public class EmptyArrayException extends Exception{
	
	/**
	 * Parameterized constructor
	 * @param message : to be displayed when the user pass an empty array.
	 */
	public EmptyArrayException(String message) {
		super(message);
	}
}
