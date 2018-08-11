package DictionaryUsingBST;

/**
 * @author Niraj Gupta
 * Class to represent the exception when the element to be inserted into the tree is already exist.
 *
 */
public class DuplicateElementInsertionException extends Exception {

	/**
	 * Parameterized Constructor
	 * @param message : The message intended for the user.
	 */
	public DuplicateElementInsertionException(String message){
		super(message);
	}
}
