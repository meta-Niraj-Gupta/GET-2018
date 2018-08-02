package QueueDataStructure;

import java.util.NoSuchElementException;

/**
 * @author Niraj Gupta
 *
 * Class to implement the queue using link list an implementing queue interface and performing 
 * basic queue operation like enqueueing element at rear, deleting element form front etc.
 * @param <T>
 */
public class QueueUsingLinkList<T> implements Queue<T>{
	private Node<T> front, rear;
	private int size;
	
	/**
	 * @author Niraj Gupta
	 * 
	 * Class to create a node which is the used to create a link list.
	 * @param <T> : The user decide which data type to be used.
	 */
    private static class Node<T>{
        private T data;

        private Node<T> next;
        
        /**
         * Parameterized Constructor : Creating a node with a value in it.
         * @param element : The element or data which is stored inside the node.
         */
        public Node(T element){
            data = element;
        }
    }
    
    /**
     * Method to insert element to the rear of the queue.
     * @return : The new queue object after enqueueing the new element.
     */
    @Override
    public Queue<T> enqueue(T element){
        Node<T> newElement = new Node<T>(element);
        if(front == null){
            front = newElement;
        }else{
            if(front.next == null){
                front.next = newElement;
            }else{
                rear.next = newElement;
            }

            rear = newElement;
        }
        size++;
        return this;
    }
    
    /**
     * Method to check if the element can be enqueueed to the queue or not it is similar to isFull() from stack.
     * @return : True if the insertion of new element to the queue is successful, false otherwise
     */
    @Override
    public boolean checkIfElementCanBeenqueued(T element){
        enqueue(element);
        return true;
    }
    
    /**
     * Method to get the front element of the queue.
     * @return : The front element of the queue.
     */
    @Override
    public T getFront(){
        return front == null ? null : front.data;
    }
    
    /**
     * Method to remove the element from the front of the queue.
     * @return : the front element of the queue which is removed from the queue.
     * @throw NoSuchElementException : If the queue is empty and there is no element to delete.
     */
    @Override
    public T dequeue(){
        if(front == null){
            throw new NoSuchElementException("Underflow : Queue is empty.");
        }

        T output = front.data;
        front = front.next;
        size--;
        return output;
    }

	@Override
	public int size() {
		return size;
	}

}
