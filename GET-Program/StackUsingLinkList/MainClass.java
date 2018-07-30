package StackUsingLinkList;

import java.util.Scanner;
/**
 * 
 * @author Niraj Gupta
 * This class contains the main function which is used to check if the LinkListThroughStack class is working properly or not
 *
 */
public class MainClass {
	public static void main(String[] args){
		LinkListThroughStack linkList = new LinkListThroughStack();
		System.out.println("Menu");
		System.out.println("Press 1 to push/insert element in link list");
		System.out.println("Press 2 to pop/delete element from link list");
		System.out.println("Press 3 to see the top element in link list");
		System.out.println("Press 4 to check if link list is empty");
		Scanner scan = new Scanner(System.in);
		char repeat;
		do{
			System.out.println("Enter any of the choice");
			int choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the element to be inserted");
				int item = scan.nextInt();
				linkList.push(item);
				break;
			case 2:
				System.out.println(linkList.pop() + " is deleted from the Link List");
				break;
			case 3:
				System.out.println(linkList.topElement() + " is the top element of the Link List");
				break;
			case 4:
				if(linkList.isEmpty())
					System.out.println("Link List is empty");
				else
					System.out.println("Link List is not empty");
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
