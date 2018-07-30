package OperationsOnArray;

/**
 * @author Niraj Gupta
 * Class to perform different functions on array i.e. finding mirror and clumps in an array, spliting an array into 2 sub-array such that
 * both have equal sum and fitting the XY in an array such that the Y is always on the right of the X.
 */
public class PerformingDifferentOperationOnArray{
	
	/**
	 * Method to splits the array into two sub-array such that the sum of the two sub-array is equal.
	 * The array should not be empty and it contains only positive integers.
	 * @param array : is an 1-D array for storing the values.
	 * @return : the index at which the split occurs otherwise return -1.
	 * @throws EmptyArrayException : if the array is empty
	 */
	public int splitArray(int[] array) throws EmptyArrayException{
		if(array.length == 0){
			throw new EmptyArrayException("The array cannot be empty");
		}
		int totalSumOfArray = 0, sumFromFront = 0;
		for(int i = 0; i < array.length; i++){
			totalSumOfArray += array[i];
		}
		for(int i = 0; i < array.length; i++){
			sumFromFront += array[i];
			totalSumOfArray -= array[i];
			if(sumFromFront == totalSumOfArray){
				return i + 1;
			}
		}
		return -1;
	}
	
	/**
	 * Method finds the total count of clumps in an array. An clump is the number in an array which occurs for more
	 * than one time consecutively. 
	 * @param array : is an 1-D array for storing the elements.
	 * @return : the total count of clumps present in the array.
	 * @throws EmptyArrayException : if the array is empty
	 */
	public int clumpsInArray(int[] array) throws EmptyArrayException{
		int countClumps = 0;
		if(array.length == 0){
			throw new EmptyArrayException("The array cannot be empty");
		}
		boolean checkIfNextElementIsSame = false;
		for(int i = 0; i < array.length - 1; i++){
			if(array[i] == array[i + 1] && !checkIfNextElementIsSame){
				countClumps++;
				checkIfNextElementIsSame = true;
			}else if(array[i] != array[i + 1]){
				checkIfNextElementIsSame = false;
			}
		}
		return countClumps;
	}
	
	/**
	 * Method to find the mirrors in an array. Mirror means the sub-array from front is also present in the array 
	 * in reverse order.
	 * @param array : is 1-D array for storing the elements.
	 * @return : the maximum length of the mirror present in the array.
	 * @throws EmptyArrayException : if the array is empty
	 */
	public int maximumSizeOfMirror(int[] array) throws EmptyArrayException{
		if(array.length == 0){
			throw new EmptyArrayException("The array cannot be empty");
		}
		int[][] longestCommonSubsequence = new int[array.length + 1][array.length + 1];
		int outputValue = 0;
		for(int i = 0; i <= array.length; i++){
			for(int j = 0; j <= array.length; j++){
				if(i == 0 || j == 0){
					longestCommonSubsequence[i][j] = 0;
				}else if (array[i - 1] == array[array.length - j]){
					longestCommonSubsequence[i][j] = longestCommonSubsequence[i - 1][j - 1] + 1;
					outputValue = Math.max(outputValue,
							longestCommonSubsequence[i][j]);
				}else{
					longestCommonSubsequence[i][j] = 0;
				}
			}
		}
		return outputValue;
	}
	
	/**
	 * Method to fit two variables say X and Y in an array such that the Y occurs to the right of the 
	 * X and the number of X and Y must be equal and the X should not be present at the last index.
	 * @param array : is an 1-D array which stores the element and its size cannot be zero
	 * @param x : the values of X which is fixed in the array
	 * @param y : the values of Y which is to be placed to the right of X 
	 * @return : the new array after fixing the Y to the right of X in the array if possible otherwise -1.
	 * @throws EmptyArrayException 
	 */
	public int[] fixXYInArray(int[] array, int x, int y) throws EmptyArrayException{
		int[] newArray = array;
		if(array.length == 0){
			throw new EmptyArrayException("The array cannot be empty");
		}
		int countX = 0, countY = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] == x){
				countX++;
			}else if(array[i] == y){
				countY++;
			}
		}
		if(countX != countY){
			throw new AssertionError("Cannot fit X and Y");
		}
		if(array[array.length-1] == x){
			throw new AssertionError("Last element cannot be " + x);
		}
		for(int i = 0; i < array.length; i++){
			if(array[i] == x && array[i+1] == x){
				throw new AssertionError("Number " + x + " cannot be together");
			}
		}
		for(int i = 0; i < array.length - 1; i++){
			if(newArray[i] == x && newArray[i + 1] != y){
				for(int j = 0; j < array.length; j++){
					if (j == 0 && newArray[j] == y){
						newArray[j] = newArray[i + 1];
						newArray[i + 1] = y;
						break;
					}else if(newArray[j] == y && newArray[j - 1] != x){
						newArray[j] = newArray[i + 1];
						newArray[i + 1] = y;
						break;
					}
				}
			}
		}
		return newArray;
	}
	
	public static void main(String[] arg) throws EmptyArrayException{
		PerformingDifferentOperationOnArray array = new PerformingDifferentOperationOnArray();
		System.out.println(array.clumpsInArray((new int[]{})));
	}
}
