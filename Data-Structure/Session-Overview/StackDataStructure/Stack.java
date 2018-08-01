package StackDataStructure;

/**
 * @author Niraj Gupta
 * 
 * Interface to let the user know what operation he can perform on stack data structure.
 * @param <DataType> : User decide what kind of data is required in stack. 
 */
public interface Stack<DataType>{
	/**
	 * Method to get the top element of stack
	 * @return : The top of the stack
	 * @throws Exception : If the stack is empty than there is no element at the top of the stack.
	 */
	DataType getTopElement() throws Exception;
	
	/**
	 * Method to push the element on the top of stack
	 * @param element : The data which is to be inserted at the top of stack.
	 */
	void push(DataType element);
	
	/**
	 * Method to delete or remove the top element of the stack.
	 * @return : The top element of the stack which is removed from the stack.
	 */
	DataType pop();
	
	/**
	 * Method to check if the stack is empty or not.
	 * @return : True if the stack is empty, false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Method to get the size of the stack.
	 * @return : The total number of element present in the stack.
	 */
	int size();
}
