package StackUsingArray;

/**
 * 
 * @author Niraj Gupta
 * This class is an stack implementation using array.
 * This class can also have following behaviour:
 * 1. It can add new element to the top of the stack
 * 2. It can delete element from the top of the stack
 * 3. It can tell the user what is at the top of the stack
 * 4. It checks whether the stack is empty or full.
 *
 */
public class StackArray {
	private int[] stackArray;
	private int topOfStack;
	
	/**
	 * This is a constructor which create a reference of class StackArray
	 * It also initialize the top of stack with -1
	 * @param maxLength the maximum length that user wants to create.
	 */
	public StackArray(int maxLength){
		topOfStack = -1;
		stackArray = new int[maxLength];
	}
	
	/**
	 * This method insert new element at the top  of the stack
	 * @param item user send it as an argument to insert in the stack.
	 */
	public void push(int item){
		if(isFull()){
			System.out.println("Stack overflow");
		}else{
			stackArray[++topOfStack] = item;
		}
	}
	
	/**
	 * It removes the elements from the top of the stack
	 * @return the top element which is been removed.
	 */
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return 0;
		}else{
			return stackArray[topOfStack--];
		}
	}
	
	/**
	 * This method gives the top element of the stack
	 * @return top element of the stack
	 */
	public int topElement(){
		return stackArray[topOfStack];
	}
	
	/**
	 * This method checks if the stack is full or not
	 * @return true if the stack is full, false othewise
	 */
	public boolean isFull(){
		return topOfStack == stackArray.length -1;
	}
	
	/**
	 * This method checks if the stack is empty or not
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty(){
		return topOfStack < 0;
	}
}
