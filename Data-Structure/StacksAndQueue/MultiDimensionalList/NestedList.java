package MultiDimensionalList;

import java.util.List;

/**
 * @author Niraj Gupta
 * Interface to perform operations on multi-dimensional or nested list, operations like
 * calculating the sum, finding the key and getting the maximum value from the nested list.
 *
 */
public interface NestedList{

	/**
	 * Method to calculate the sum of integers present in the Nested List.
	 * @param listOfIntegers : The nested list of integers.
	 * @return : The sum of integers present in the nested list.
	 */
	int calculateSumOfIntegersFromList(List<Object> listOfIntegers);

	/**
	 * Method to get the largest integer from the Nested List.
	 * @param listOfIntegers : The nested list of integers.
	 * @return : The largest integer present in the nested list.
	 */
	int getTheLargestIntegerFromList(List<Object> listOfIntegers);

	/**
	 * Method to search integer in the Nested List.
	 * @param listOfIntegers : The nested list of integers in which the integer to be searched.
	 * @param integerToBeSearched : The key which is to be searched in the nested list.
	 * @return : True if the key is present in the list, false otherwise.
	 */
	boolean findIntegerInList(List<Object> listOfIntegers, int integerToBeSearched);
}
