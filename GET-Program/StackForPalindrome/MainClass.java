package StackForPalindrome;

import java.util.Scanner;
/**
 * 
 * @author Niraj Gupta
 * This is a class containing main function and it implements the stack to check whether a string is palindrome or not.
 *
 */
public class MainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string to check for palindrome");
		String str = scan.nextLine();
		
		PalindromeCheckUsingStack stack = new PalindromeCheckUsingStack(str.length());
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			if (stack.pop() != str.charAt(i)) {
				flag = false;
				break;
			}

		}

		if (flag) {
			System.out.println("The string is Palindrome");
		} else {
			System.out.println("The string is not Palindrome");
		}
		scan.close();
	}
}
