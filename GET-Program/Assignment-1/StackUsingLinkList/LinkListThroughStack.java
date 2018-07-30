package StackUsingLinkList;

/**
 * 
 * @author Niraj Gupta
 * This class is an implementation of stack using link list.
 * This class has following behaviour:
 * 1. can insert new node or element at the start of the stack/linklist
 * 2. can remove element from the start of the stack/linklist
 * 3. can be used to see what is at the top of the stack/ at the start of the linklist
 * 4. can also check if the stack/linklist is empty or not.
 *
 */
public class LinkListThroughStack {
	private Node topOfStack = null;
	
	/**
	 * This method basically insert new element at the start of the link list.
	 * if the linklist is empty it add new nodes to it, otherwise it add new nodes to the existing list
	 * @param element the item to be inserted in the link list
	 */
	public void push(int element){
		Node firstNode = new Node(element);
		if(isEmpty()){
			topOfStack = firstNode;
		}else{
			firstNode.next = topOfStack;
			topOfStack = firstNode;
		}
	}
	
	/**
	 * This method is used to delete the starting element from the linklist
	 * @return the data from the node which has been deleted.
	 */
	public int pop(){
		if(isEmpty()){
			System.out.println("No element to delete");
			return 0;
		}else{
			int deletedItem = topOfStack.data;
			topOfStack = topOfStack.next;
			return deletedItem;
		}
	}
	
	/**
	 * This method gives the starting element of the linklist i.e. top of the stack
	 * @return the top element of the stack
	 */
	public int topElement(){
		if(isEmpty()){
			System.out.println("There is no element to delete");
			return 0;
		}else{
			return topOfStack.data;
		}
	}
	
	/**
	 * This method checks if the linklist is empty or not
	 * @return true if the linklist is empty , false otherwise
	 */
	public boolean isEmpty(){
		return topOfStack == null;
	}
}
