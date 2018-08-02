package QueueDataStructure;

/**
 * @author Niraj Gupta
 *
 * Interface to implement the queue data structure and can accept any user entered data type. 
 * @param <T> : The user select the type of the queue.
 */
public interface Queue<T>{
	
	/**
	 * Method to enqueue new element to the queue.
	 * @param element : The element to be enqueueed to the queue.
	 * @return : The Queue Array in which the element is enqueueed to the front of the queue.
	 */
	Queue<T> enqueue(T element);
	
	/**
	 * Method to check if the element can be enqueueed to queue or not.
	 * @param element : The element which is to be enqueueed to the queue.
	 * @return : True if the element can be enqueueed to the queue successfully, false otherwise.
	 */
    boolean checkIfElementCanBeenqueued(T element);
    
    /**
     * Method to get the front element of the queue.
     * @return : The front element of the queue
     */
    T getFront();
    
    /**
     * Method to delete the front element from the queue
     * @return : The element which is removed from the front of the queue.
     */
    T dequeue();
    
    /**
     * Method to get the size of the queue.
     * @return : The total number of element present in the queue.
     */
    int size();
    
}
