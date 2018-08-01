package StackDataStructure;

import java.util.NoSuchElementException;

/**
 * @author Niraj Gupta
 *
 * Class to implement stack using an array of fixed size by implementing the stack interface.
 * @param <DataType> : The Data type which user select to create an stack.
 */
public class StackUsingArray<DataType> implements Stack<DataType>{
	private DataType[] stackArray;
	private int topOfStack;
	private final static int DEFAULT_SIZE = 10;
	
	/**
	 * Default Constructor : Creates an stack of default size.
	 */
	public StackUsingArray(){
		this(DEFAULT_SIZE);
	}
	
	/**
	 * Parameterized constructor : Creating an stack of user entered size.
	 * @param stackCapacity : The maximum size of stack entered by the user.
	 */
	public StackUsingArray(int stackCapacity){
		stackArray = (DataType[]) new Object[stackCapacity];
		topOfStack = -1;
	}
	
	/**
	 * Method to get the Top element of the stack.
	 * @return : the top element of the stack.
	 * @throws : NoSuchElementException if the stack is empty. Since there is no element to be deleted.
	 */
	@Override
	public DataType getTopElement(){
		if(isEmpty()){
			throw new NoSuchElementException("UnderFlow : The stack is empty.");
		}else{
			return stackArray[topOfStack];
		}
	}
	
	/**
	 * Method to insert element in the stack at the top.
	 * @throws : IndexOutOfBoundsException if the stack is full.
	 */
	@Override
	public void push(DataType element){
		if(isFull()){
			throw new IndexOutOfBoundsException("OverFlow : The stack is full.");
		}else{
			stackArray[++topOfStack] = element;
		}
	}
	
	/**
	 * Method to delete element from the top of the stack.
	 * @return : The top element of the stack which is been removed.
	 * @throws : NoSuchElementException if the stack is empty.
	 */
	@Override
	public DataType pop(){
		if(isEmpty()){
			throw new NoSuchElementException("UnderFlow : The stack is empty. No element to remove.");
		}else{
			return stackArray[topOfStack--];
		}
	}
	
	/**
	 * Method to check if the stack is empty or not.
	 * @return : True if the stack is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty(){
		return topOfStack < 0;
	}
	
	/**
	 * Method to check whether the stack is full or not.
	 * @return : True if the stack is full, false otherwise.
	 */
	public boolean isFull(){
		return topOfStack == stackArray.length - 1;
	}

	/**
	 * Method to get the size of the stack.
	 * @return : The total number of element present in the stack.
	 */
	@Override
	public int size() {
		return topOfStack + 1;
	}

}
