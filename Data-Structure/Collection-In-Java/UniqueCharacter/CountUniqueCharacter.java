package UniqueCharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Niraj Gupta
 * Class to count the number of unique character in a given string.
 *
 */
public class CountUniqueCharacter{
	private static Map<String, Integer> stringContainer = new HashMap<String, Integer>();

	/**
	 * Method to count the number of unique character in a given string.
	 * @param string : From which we have count the number of unique character.
	 */
	private void countNumberOfUniqueCharacter(String string){
		char[] character = string.toCharArray();
		Set<Character> uniqueCharacter = new HashSet<Character>();
		for(int i = 0; i < character.length; i++){
			uniqueCharacter.add(character[i]);
		}
		stringContainer.put(string, uniqueCharacter.size());
	}

	/**
	 * Method to check if the given string is already in processed or not.
	 * @param string : The string to be checked for past processing.
	 * @return : The number of unique character if it was already processed, otherwise calculate it and store it. 
	 */
	public int getNumberOfUniqueCharacter(String string){
		if(!stringContainer.containsKey(string)){
			countNumberOfUniqueCharacter(string);
		}
		return stringContainer.get(string);
	}
}
