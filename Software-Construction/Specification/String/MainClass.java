package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;

/**
 * 
 * @author Niraj Gupta
 * This is the main class having the main function to check if the methods implemented in the MyStringClass is working properly or not.
 * It is required that the string passed to any method is not null and can be case sensitive
 */
public class MainClass {
	public static void main(String[] args) throws InvalidInputException{
		Scanner scan = new Scanner(System.in);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		MyStringClass myString = new MyStringClass();
		String userInputString = "";
		String userInputString1 = "";
		char repeat;
		try{
			do{
				System.out.println("Menu");
				System.out.println("Press 1 to compare two string");
				System.out.println("Press 2 to convert the case of the string");
				System.out.println("Press 3 to find the reverse of the string");
				System.out.println("Press 4 to find the longest word in the given string");
				System.out.println("Enter your choice");
				int choice = scan.nextInt();
				switch(choice){
				case 1:
					System.out.println("Enter first string");
					userInputString = buffer.readLine();
					System.out.println("Enter first string");
					userInputString1 = buffer.readLine();
					int returnValue = myString.compareTwoString(userInputString, userInputString1);
					if(returnValue == 0){
						System.out.println("Both the strings are different");
					}else{
						System.out.println("Both the strings are same");
					}
					break;
				
				case 2:
					System.out.println("Enter a string");
					userInputString = buffer.readLine();
					System.out.println("The input string is " + userInputString);
					System.out.println("The string after converting case is " + myString.convertCase(userInputString));
					break;
				
				case 3:
					System.out.println("Enter a string");
					userInputString = buffer.readLine();
					System.out.println("The input string is " + userInputString);
					System.out.println("The string after reverse is " + myString.reverse(userInputString));
					break;
				
				case 4:
					System.out.println("Enter a string");
					userInputString = buffer.readLine();
					System.out.println("The input string is " + userInputString);
					System.out.println("The longest word from the string is " + myString.longestWordInString(userInputString));
					break;
				
				default:
					System.out.println("Enter a valid choice");
				}
				System.out.println("Press y to continue");
				repeat = scan.next().charAt(0);
			}while(repeat == 'y');
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		scan.close();
	}
}
