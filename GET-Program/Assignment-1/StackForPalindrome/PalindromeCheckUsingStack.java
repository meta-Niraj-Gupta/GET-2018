package StackForPalindrome;

/**
 * 
 * @author User14
 * This class creates an stack which can store characters.  
 */
public class PalindromeCheckUsingStack {
	private char[] charStack;
	private int topOfStack;
	
	/**
	 * This is a constructor used to create a reference of class PalindromeCheckUsingStack
	 * @param maxLength it is the maximum length of the stack.
	 */
	public PalindromeCheckUsingStack(int maxLength) {
		charStack = new char[maxLength];
		topOfStack = -1;
	}
	
	/**
	 * This method insert an character in the stack
	 * @param item the user sends the item which is to be inserted into the stack
	 */
	public void push(char item) {
		charStack[++topOfStack] = item;
	}
	
	/**
	 * This method deletes the top element from the stack
	 * @return the element which is deleted from the stack
	 */
	public char pop() {
		return charStack[topOfStack--];
	}
	
	/**
	 * This method checks whether the stack is empty or not.
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return topOfStack < 0;
	}
	
	/**
	 * This method returns the top element of the stack.
	 * @return top element of the stack
	 */
	public char topElement() {
		return charStack[topOfStack];
	}
}
