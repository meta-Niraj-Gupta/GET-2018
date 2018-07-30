package StackUsingLinkList;

/**
 * 
 * @author Niraj Gupta
 * This class creates a node which is inserted to the linklist
 * This class contains two attributes data and a node reference next.
 *
 */
public class Node {
	protected int data;
	protected Node next;
	Node(int item){
		data = item;
		next = null;
	}
}
