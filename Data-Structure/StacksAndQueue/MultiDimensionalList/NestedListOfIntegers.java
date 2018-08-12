package MultiDimensionalList;

import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;

/**
 * @author Niraj Gupta
 * Class to perform different operations on the nested list, operations like finding the largest element, calculating 
 * the sum of the elements present in the list and searching an key element in the list.
 *
 */
public class NestedListOfIntegers implements NestedList{
	List<Object> listOfIntegers = new LinkedList<Object>();
	private int largestIntegerInList = 0;

	public int calculateSumOfIntegersFromList(List<Object> nestedListOfInteger){
		int sumOfList = 0;
		for(int index = 0; index < nestedListOfInteger.size(); index++){
			if(nestedListOfInteger.get(index) instanceof String){
				sumOfList += Integer.parseInt((String) nestedListOfInteger.get(index));
			}else if(nestedListOfInteger.get(index) instanceof List){
				sumOfList += calculateSumOfIntegersFromList((List) nestedListOfInteger.get(index));
			}
		}
		return sumOfList;
	}

	public int getTheLargestIntegerFromList(List<Object> nestedListOfInteger){
		for(int index = 0; index < nestedListOfInteger.size(); index++){
			if(nestedListOfInteger.get(index) instanceof String){
				if(Integer.parseInt((String) nestedListOfInteger.get(index)) > largestIntegerInList){
					largestIntegerInList = Integer.parseInt((String) nestedListOfInteger.get(index));
				}
			}else if(nestedListOfInteger.get(index) instanceof List){
				largestIntegerInList = getTheLargestIntegerFromList((List) nestedListOfInteger.get(index));
			}
		}
		return largestIntegerInList;
	}

	public boolean findIntegerInList(List<Object> nestedListOfInteger, int integerToBeSearched){
		for(int index = 0; index < nestedListOfInteger.size(); index++){
			if(nestedListOfInteger.get(index) instanceof String){
				if(Integer.parseInt((String) nestedListOfInteger.get(index)) == integerToBeSearched){
					return true;
				}
			}else if(nestedListOfInteger.get(index) instanceof List){
				return findIntegerInList((List) nestedListOfInteger.get(index), integerToBeSearched);
			}
		}
		return false;
	}

	/**
	 * Method to check if the string is integer or not.
	 * @param toCheckIfIntergerOrNot : The string element which is to be checked.
	 * @return : True if it is integer, false otherwise.
	 */
	private boolean isInteger(String toCheckIfIntergerOrNot){
		for(int index = 0; index < toCheckIfIntergerOrNot.length(); index++){
			if(toCheckIfIntergerOrNot.charAt(index) < 48 || toCheckIfIntergerOrNot.charAt(index) > 57){
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to create a nested list of integers from the JSONArray.
	 * @param nestedListOfInteger : The list which will hold the integers.
	 * @param jsonArray : The JSONArray containing the JSONObject nested list of integers.
	 * @return : The nested list of integers.
	 */
	public List<Object> createNestedList(List<Object> nestedListOfInteger, JSONArray jsonArray) {
		for(int index = 0; index < jsonArray.size(); index++){
			if(jsonArray.get(index) instanceof String){
				if(isInteger((String) jsonArray.get(index))){
					nestedListOfInteger.add(jsonArray.get(index));
				}
			}else if(jsonArray.get(index) instanceof List){
				List<Object> branchList = new LinkedList<Object>();
				nestedListOfInteger.add(createNestedList(branchList, (JSONArray) jsonArray.get(index)));
			}
		}

		return nestedListOfInteger;
	}
}
