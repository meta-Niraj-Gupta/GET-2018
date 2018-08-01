package QueueDataStructure;

/**
 * @author Niraj Gupta
 *
 * Interface to implement the queue data structure and can accept any user entered data type. 
 * @param <DataType> : The user select the type of the queue.
 */
public interface Queue<DataType>{
	
	/**
	 * Method to add new element to the queue.
	 * @param element : The element to be added to the queue.
	 * @return : The Queue Array in which the element is added to the front of the queue.
	 */
	Queue<DataType> add(DataType element);
	
	/**
	 * Method to check if the element can be added to queue or not.
	 * @param element : The element which is to be added to the queue.
	 * @return : True if the element can be added to the queue successfully, false otherwise.
	 */
    boolean checkIfElementCanBeAdded(DataType element);
    
    /**
     * Method to get the front element of the queue.
     * @return : The front element of the queue
     */
    DataType getFront();
    
    /**
     * Method to delete the front element from the queue
     * @return : The element which is removed from the front of the queue.
     */
    DataType poll();
    
}
