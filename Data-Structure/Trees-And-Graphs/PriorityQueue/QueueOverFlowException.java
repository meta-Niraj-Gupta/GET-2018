package PriorityQueue;

/**
 * @author Niraj Gupta
 * Class to represent the queue over flow exception which is thrown when the queue is full and no
 * more jobs can be added to it.
 */
public class QueueOverFlowException extends Exception{

	/**
	 * Parameterized Constructor.
	 * @param message : The message intended for the end user.
	 */
	public QueueOverFlowException(String message){
		super(message);
	}

}
