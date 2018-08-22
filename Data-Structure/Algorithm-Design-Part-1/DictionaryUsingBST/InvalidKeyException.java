package DictionaryUsingBST;

/**
 * @author Niraj Gupta
 * Class to represent the exception when the key entered is null.
 *
 */
public class InvalidKeyException extends Exception{

	/**
	 * Parameterized Constructor
	 * @param message : The message intended for the user.
	 */
	public InvalidKeyException(String message){
		super(message);
	}
}
