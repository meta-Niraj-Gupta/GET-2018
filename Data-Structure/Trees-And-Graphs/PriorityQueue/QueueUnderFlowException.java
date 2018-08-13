package PriorityQueue;

/**
 * @author Niraj Gupta
 * Class to represent the queue under flow exception which is thrown when the queue is empty and 
 * there are no jobs to be removed from the queue.
 */
public class QueueUnderFlowException extends Exception{

	/**
	 * Parameterized Constructor.
	 * @param message : The message intended for the end user.
	 */
	public QueueUnderFlowException(String message){
		super(message);
	}

}
