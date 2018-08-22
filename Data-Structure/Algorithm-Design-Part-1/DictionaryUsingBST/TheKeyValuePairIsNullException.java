package DictionaryUsingBST;

/**
 * @author Niraj Gupta
 * Class to represent the exception when the either/both the key or value pair are/is null.
 *
 */
public class TheKeyValuePairIsNullException extends NullPointerException{

	/**
	 * Parameterized Constructor
	 * @param message : The message intended for the user.
	 */
	public TheKeyValuePairIsNullException(String message){
		super(message);
	}
}
