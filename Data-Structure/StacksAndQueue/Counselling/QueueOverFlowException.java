package Counselling;

/**
 * @author Niraj Gupta
 * Class to handle the queue overflow exception.
 */
public class QueueOverFlowException extends Exception{
	/**
	 * Parameterized Constructor : Calling Constructor of Exception class.
	 * @param message : The detailed message about the exception. 
	 */
	public QueueOverFlowException(String message){
		super(message);
	}
}
