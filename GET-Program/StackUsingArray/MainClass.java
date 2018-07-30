package StackUsingArray;

import java.util.Scanner;

/**
 * 
 * @author Niraj Gupta
 * This class contains the main function which is used to check if the class StackArray is working properly or not.
 *
 */
public class MainClass {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the maximum size of the stack");
		int maximumCapacity = scan.nextInt();
		StackArray stack = new StackArray(maximumCapacity);
		System.out.println("Menu");
		System.out.println("Press 1 to push/insert element in stack");
		System.out.println("Press 2 to pop/delete element");
		System.out.println("Press 3 to see the top element in stack");
		System.out.println("Press 4 to check if stack is empty");
		char repeat;
		do{
			System.out.println("Enter any of the choice");
			int choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the element to be inserted");
				int item = scan.nextInt();
				stack.push(item);
				break;
			case 2:
				System.out.println(stack.pop() + " is deleted from the stack");
				break;
			case 3:
				System.out.println(stack.topElement() + " is the top element of the stack");
				break;
			case 4:
				if(stack.isEmpty())
					System.out.println("Stack is empty");
				else
					System.out.println("Stack is not empty");
				break;
			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("Press y to continue");
			repeat = scan.next().charAt(0);
		}while(repeat == 'y');
		scan.close();
	}
}
