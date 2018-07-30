package SearchingClass;

/**
 * @author Niraj Gupta
 * Class to search key element in an array by using linear or binary search. 
 */
public class SearchClass{
	
	/**
	 * Method to search for the key in an array by using linear search.
	 * @param array : is the memory space to store elements
	 * @param key : is the element to be searched in an array.
	 * @param index : is the location or position at which the key is present
	 * @return : the index of the key where the element is found otherwise it returns -1.
	 */
	public int linearSearch(int[] array, int key, int index){
		if(array.length == 0){
			throw new AssertionError("The array is empty");
		}
		if(index == array.length){
			return -1;
		}else if(array[index] == key){
			return  index+1;
		}else{
			return linearSearch(array, key, index+1);
		}
	}
	
	/**
	 * Method to search for key in an array by using binary search
	 * @param array : is the memory space to store different values
	 * @param key : is the element to be searched in the memory.
	 * @param start : is the starting index of the array 
	 * @param end : is the ending index of the array
	 * @return : the index at which the element is found otherwise it returns -1.
	 */
	public int binarySearch(int[] array, int key, int start, int end){
		if(array.length == 0){
			throw new AssertionError("The array is empty");
		}
		if(start <= end){
			int mid = (start + end) / 2;
			if(array[mid] == key){
				return mid + 1;
			}
			if(array[mid] < key){
				return binarySearch(array, key, mid + 1, end);
			}else{
				return binarySearch(array, key, start, mid - 1);
			}
		}
		return -1;
	}
}
