package QueueDataStructure;

import java.util.NoSuchElementException;

/**
 * @author Niraj Gupta
 *
 * Class to implement the queue using link list an implementing queue interface and performing 
 * basic queue operation like adding element at rear, deleting element form front etc.
 * @param <DataType>
 */
public class QueueUsingLinkList<DataType> implements Queue<DataType>{
	private Node<DataType> first, last;
	
	/**
	 * @author Niraj Gupta
	 * 
	 * Class to create a node which is the used to create a link list.
	 * @param <DataType> : The user decide which data type to be used.
	 */
    private static class Node<DataType>{
        private DataType data;

        private Node<DataType> back;
        
        /**
         * Parameterized Constructor : Creating a node with a value in it.
         * @param element : The element or data which is stored inside the node.
         */
        public Node(DataType element){
            data = element;
        }
    }
    
    /**
     * Method to insert element to the rear of the queue.
     * @return : The new queue object after adding the new element.
     */
    @Override
    public Queue<DataType> add(DataType element){
        Node<DataType> newElement = new Node<DataType>(element);
        if(first == null){
            first = newElement;
        }else{
            if(first.back == null){
                first.back = newElement;
            }else{
                last.back = newElement;
            }

            last = newElement;
        }

        return this;
    }
    
    /**
     * Method to check if the element can be added to the queue or not it is similar to isFull() from stack.
     * @return : True if the insertion of new element to the queue is successful, false otherwise
     */
    @Override
    public boolean checkIfElementCanBeAdded(DataType element){
        add(element);
        return true;
    }
    
    /**
     * Method to get the front element of the queue.
     * @return : The front element of the queue.
     */
    @Override
    public DataType getFront(){
        return first == null ? null : first.data;
    }
    
    /**
     * Method to remove the element from the front of the queue.
     * @return : the front element of the queue which is removed from the queue.
     * @throw NoSuchElementException : If the queue is empty and there is no element to delete.
     */
    @Override
    public DataType poll(){
        if(first == null){
            throw new NoSuchElementException("Underflow : Queue is empty.");
        }

        DataType output = first.data;
        first = first.back;

        return output;
    }

}
