package Queue;

import QueueDataStructure.Queue;


/**
 * @author Niraj Gupta
 * Class to implement circular queue using array.
 * @param <T> : The data type of element user want the queue to hold.
 */
public class CircularQueue<T> implements Queue<T>{
	private T[] queue;
    private int front, size, rear;
    public final static int DEFAULT_ARRAY_SIZE = 10;
    
    /**
     * Non - Parameterized Constructor 
     */
    public CircularQueue(){
        this(DEFAULT_ARRAY_SIZE);
    }
    
    /**
     * Parameterized Constructor : Creating a queue of maximum length defined by user
     * @param maximumCapacity
     */
    public CircularQueue(int maximumCapacity){
    	queue = (T[]) new Object[maximumCapacity];
    	front = rear = -1;
    	size = maximumCapacity;
    }
    
    /**
     * Method to insert the element in the queue.
     * @param element : The element to be inserted in the queue.
     * @return : The reference to the queue after insertion of new element.
     */
	@Override
	public Queue<T> enqueue(T element){
		if(front == 0 && rear == size - 1 || rear == (front-1) % (size-1)){
			throw new IndexOutOfBoundsException("Index Out Of Bound : The queue is full. Cannot add more elements.");
		}else if(front == -1){
			front = rear = 0;
			queue[rear] = element;
		}else if(rear == size-1 && front != 0){
			rear = 0;
			queue[rear] = element;
		}else{
			queue[++rear] = element;
		}
		return this;
	}
	
	/**
	 * Method to check if the element can be added to the queue.
	 * @param element : The element to be inserted in the queue.
	 * @return : true if the element can be added, false otherwise.
	 */
	@Override
	public boolean checkIfElementCanBeEnqueued(T element){
		try{
			this.enqueue(element);
		}catch(IndexOutOfBoundsException exception){
			return false;
		}
		return true;
	}
	
	/**
	 * Method to get the front element of the queue.
	 * @return : the front element of the queue.
	 */
	@Override
	public T getFront(){
		return queue[front];
	}
	
	/**
	 * Method to delete the element from the queue.
	 * @return : The front element which is deleted from the queue.
	 */
	@Override
	public T dequeue(){
		T data = null;
		if(front == -1){
			throw new IndexOutOfBoundsException("Index Out Of Bound : The queue is empty. Cannot delete element.");
		}
		data = queue[front];
		queue[front] = null;
		if(front == rear){
			front = rear = -1;
		}else if(front == size-1){
			front = 0;
		}else{
			front++;
		}
		return data;
	}
	
	/**
	 * Method to get the size of the queue.
	 * @return : The size of the queue.
	 */
	@Override
	public int size(){
		return (front >= rear) ? front - rear : rear - front + 1;
	}
	
	/**
	 * Method to get the last/rear element form the queue.
	 * @return : The last element from the queue.
	 */
	public T getRear(){
		return queue[rear];
	}
	
}
