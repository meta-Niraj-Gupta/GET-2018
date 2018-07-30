package String;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;

/**
 * 
 * @author Niraj Gupta
 * Class to perform the basic operation on the string like reversing the string, changing the case of the string, 
 * comparing two string and finding the longest word in the string.
 */
public class MyStringClass {
	
	/**
	 * method to computes the reverse of the string.
	 * @param inputString : It stores the input string whose reverse to be calculated it is of type string and is case sensitive
	 * @return : The reverse of the string in string format
	 * @throws InvalidInputException 
	 */
	public String reverse(String inputString) throws InvalidInputException{
		String reverseOfString = "";
		if(inputString == null){
			throw new InvalidInputException("Invalid Input : The string object is null. Enter a valid string");
		}else{
			for(int i = inputString.length()-1; i >= 0; i--){
				reverseOfString += inputString.charAt(i);
			}
		}
		return reverseOfString;
	}
	
	/**
	 * Method to converts the lower case into upper case and vice versa
	 * @param inputString : stores the input string whose case has to be converted
	 * @return : the case converted string to user 
	 * @throws InvalidInputException : if the string is null 
	 */
	public String convertCase(String inputString) throws InvalidInputException{
		String outputString = "";
		if(inputString == null){
			throw new InvalidInputException("Invalid Input : The string object is null. Enter a valid string");
		}else{
			for(int i = 0; i < inputString.length(); i++){
				if(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z'){
					outputString += (char) ((int) inputString.charAt(i) + 32);
				}else if(inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'){
					outputString += (char) ((int) inputString.charAt(i) - 32);
				}else{
					outputString += inputString.charAt(i);
				}
			}
		}
		return outputString;
	}
	
	/**
	 * Method to compares two string for equality
	 * @param inputString1 : the first string which is to be checked for equality
	 * @param inputString2 : the second string which checked against the first string
	 * @return : it return 0 if both the string are different and 1 if both the string are same
	 * @throws InvalidInputException : if the string is null
	 */
	public int compareTwoString(String inputString1, String inputString2) throws InvalidInputException{
		if(inputString1 == null || inputString2 == null){
			throw new InvalidInputException("Invalid Input : The string object is null. Enter a valid string");
		}else{
			if(inputString1.length() > inputString2.length() || inputString1.length() < inputString2.length()){
				return 0;
			}else{
				int length = 0;
				for(int i = 0; i < inputString1.length(); i++){
					if(inputString1.charAt(i) == inputString2.charAt(i)){
						length++;
						if(length == inputString1.length()){
							return 1;
						}
					}
				}
				return 0;
			}
		}
	}
	
	/**
	 * Method to find the longest word in the string using the linear search approach.
	 * @param inputString : it is the input string from which the longest word has to be extracted
	 * @return : the longest word from the string
	 * @throws InvalidInputException : if the input string is null
	 */
	public String longestWordInString(String inputString) throws InvalidInputException{
		String[] stringArray = {};
		int maxLength = 0;
		String longestWord = "";
		if(inputString == null){
			throw new InvalidInputException("Invalid Input : The string object is null. Enter a valid string");
		}else{
			stringArray = inputString.trim().split(" ");
			maxLength = stringArray[0].length();
			longestWord = stringArray[0];
			for(int i = 1; i < stringArray.length; i++){
				if(stringArray[i].length() > maxLength){
					maxLength = stringArray[i].length();
					longestWord = stringArray[i];
				}
			}
		}
		return longestWord;
	}
	
	
}
