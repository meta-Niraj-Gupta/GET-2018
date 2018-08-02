package QueueDataStructure;

import java.util.NoSuchElementException;

/**
 * @author Niraj Gupta
 *
 * Class to implement the queue using array an implementing queue interface and performing 
 * basic queue operation like adding element at rear, deleting element form front etc.
 * @param <T>
 */
public class QueueUsingArray<T> implements Queue<T>{
	private T[] data;
    private int front, size, rear;

    public final static int DEFAULT_ARRAY_SIZE = 10;
    
    /**
     * Default Constructor : Creating queue of default size.
     */
    public QueueUsingArray(){
        this(DEFAULT_ARRAY_SIZE);
    }
    
    /**
     * Parameterized Constructor : Creating queue of user entered size.
     * @param maximumCapacity : The user entered maximum length of queue.
     * @throws IllegalArgumentException : If the queue size entered by user is less than 1.
     */
    public QueueUsingArray(int maximumCapacity) throws IllegalArgumentException{
        T[] tempData = (T[]) new Object[maximumCapacity];
        data = tempData;
    }
    
    /**
     * Method to insert element to the rear of the queue.
     * @return : The new queue object after adding the new element.
     * @throws IllegalArgumentException : If there is no space to enqueue more elements to the queue.
     */
    @Override
    public Queue<T> enqueue(T element) throws IllegalArgumentException{
        if(size == data.length){
            throw new IllegalArgumentException("OverFlow : No space to store more elements");
        }

        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
        return this;
    }
    
    /**
     * Method to check if the element can be enqueueed to the queue or not it is similar to isFull() from stack.
     * @return : True if the insertion of new element to the queue is successful, false otherwise
     */
    @Override
    public boolean checkIfElementCanBeenqueued(T e){
        if(size == data.length){
            return false;
        }

        size++;
        data[rear] = e;
        rear = (rear + 1) % data.length;
        return true;
    }
    
    /**
     * Method to get the front element of the queue.
     * @return : The front element of the queue.
     */
    @Override
    public T getFront(){
        if(size == 0){
        	throw new NoSuchElementException("Underflow : Queue is empty.");
        }else{
        	return data[front];
        }
    }
    
    /**
     * Method to remove the element from the front of the queue.
     * @return : the front element of the queue which is removed from the queue.
     */
    @Override
    public T dequeue(){
        if(size == 0){
            throw new NoSuchElementException("Underflow : The queue is empty.");
        }

        T output= data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return output;
    }
	/**
	* Method to get the size of the queue.
	* @return : The total number of element present in the queue.
	@Override
	public int size(){
		return size;
	}
}
