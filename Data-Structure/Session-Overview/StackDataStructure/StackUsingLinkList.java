package StackDataStructure;

import java.util.NoSuchElementException;

/**
 * @author Niraj Gupta
 *
 * Class to implement stack using Link List of dynamic size by implementing the stack interface.
 * @param <DataType> : The Data type which user select to create an stack.
 */
public class StackUsingLinkList<DataType> implements Stack<DataType>{
	private Node<DataType> topOfStack = null;
	private int counter = 0;
	
	/**
	 * @author Niraj Gupta
	 *
	 * Class to create a node for the creation of the link list.
	 * @param <DataType> : The Data type which user select to create an stack.
	 */
	private static class Node<DataType> {
        private DataType data;
        private Node<DataType> next;
        
        /**
         * Parameterized constructor : Creating a node with some value.
         * @param element
         */
        Node(DataType element) {
            data = element;
            next = null;
        }
    }
	
	/**
	 * Method to get the Top element of the stack.
	 * @return : the top element of the stack.
	 * @throws : NoSuchElementException if the stack is empty. Since there is no element to be deleted.
	 */
	@Override
	public DataType getTopElement() throws Exception {
		if(isEmpty()){
			throw new NoSuchElementException("UnderFlow : The stack is empty");
		}else{
			return topOfStack.data;
		}
	}
	
	/**
	 * Method to insert element in the stack at the top.
	 * @throws : IndexOutOfBoundsException if the stack is full.
	 */
	@Override
	public void push(DataType element){
		Node<DataType> newItem = new Node<DataType>(element);

        if(topOfStack == null){
            topOfStack = newItem;
        }else{
            newItem.next = topOfStack;
            topOfStack = newItem;
        }
        counter++;
	}
	
	/**
	 * Method to delete element from the top of the stack.
	 * @return : The top element of the stack which is been removed.
	 * @throws : NoSuchElementException if the stack is empty.
	 */
	@Override
	public DataType pop() {
		if(topOfStack == null){
            throw new NoSuchElementException("UnderFlow : The stack is empty.");
        }

        DataType output = topOfStack.data;
        topOfStack = topOfStack.next;
        counter--;

        return output;
	}
	
	/**
	 * Method to check if the stack is empty or not.
	 * @return : True if the stack is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty(){
		return topOfStack == null;
	}
	
	/**
	 * Method to get the size of the stack.
	 * @return : The total number of element present in the stack.
	 */
	@Override
	public int size(){
		return counter;
	}
	

}
