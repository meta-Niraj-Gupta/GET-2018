package PriorityQueue;

/**
 * @author Niraj Gupta
 * Interface to implement the priority queue having the facility to add and remove job from the queue.
 *
 */
public interface PriorityQueueInterface {
	/**
	 * Method to add a job in the priority queue.
	 * @param job : The job which is to be added to the priority queue.
	 * @return : True if the job is successfully added, false otherwise.
	 * @throws QueueOverFlowException 
	 */
	boolean enqueue(Job job) throws QueueOverFlowException;


	/**
	 * Method to remove a job from the priority queue.
	 * @return : The job removed from the priority queue.
	 * @throws QueueUnderFlowException 
	 */
	Job dequeue() throws QueueUnderFlowException;


	/**
	 * Method to check if the priority queue is empty.
	 * @return : True if the priority queue is empty, false otherwise.
	 */
	boolean isEmpty();


	/**
	 * Method to check if the priority queue is full.
	 * @return : True if the priority queue is full, false otherwise.
	 */
	boolean isFull();
}
