package SetOperations;

/**
 * @author Niraj Gupta
 * Class to perform basic set operation like finding the union of two set, finding the complement of two set,
 * checking if the given item belong to the set or not, can also find the size of the set and it can also 
 * check if the given set is the subset of the parent set or not.
 * The set contains unique elements and is a immutable class. 
 *
 */
public final class IntSet {
	private static int[] universalSet;
	private final int[] set;
	private final static int MAX_LENGTH = 20;
	
	/**
	 * Default constructor
	 */
	public IntSet(){
		this.set = new int[0];
	}
	
	/**
	 * Method to remove the duplicates from the set.
	 * @param array : is the set containing duplicate elements
	 * @return : the set with distinct elements
	 */
	private int[] removeDuplicate(int[] array){
		array = sortSet(array);
		if(array.length == 0 || array.length == 1){
			return array;
		}
        int j = 0;
        for (int i = 0; i < array.length-1; i++)
            if (array[i] != array[i+1])
            	array[j++] = array[i];
      
        array[j++] = array[array.length-1];
        int[] newArray = new int[j];
        for(int m = 0; m < j; m++){
        	newArray[m] = array[m];
        }
        return newArray;
	}
	
	/**
	 * Parameterized constructor
	 * @param array : the set array which is converted into the IntSet object
	 */
	public IntSet(int[] array){
		for(int m = 0; m < array.length; m++){
			System.out.print(array[m] + " ");
		}
		System.out.println();
		this.set = removeDuplicate(array);		//Remove the duplicate elements from the set
		for(int m = 0; m < this.set.length; m++){
			System.out.print(this.set[m] + " ");
		}
		System.out.println();
		initializeUniversalset();		//Loads elements into the universal set
	}
	
	/**
	 * Utility method which allow the user to see the set elements
	 * @return : the set of unique elements
	 */
	public int[] getSet(){
		return this.set;
	}
	
	/**
	 * Method to load elements into the universal set
	 */
	private static void initializeUniversalset(){
		universalSet = new int[MAX_LENGTH];
		for(int i = 0; i < MAX_LENGTH; i++){
			universalSet[i] = i + 1;
		}
	}
	
	/**
	 * Method to get the size of the set
	 * @return : the length of the set
	 */
	public int size(){
		return this.set.length;
	}
	
	/**
	 * Method to check if the given item is member of the set or not
	 * @param item : the element to be checked whether it belongs to the set or not
	 * @return : true if the element belongs to set, false otherwise
	 */
	public boolean isMember(int item){
		if(this.set.length == 0){
			throw new AssertionError("The array is empty");
		}
		for(int i = 0; i < this.set.length; i++){
			if(this.set[i] == item){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to check if the given set is the subset of the parent set or not
	 * @param newSet : is the set which is to be checked for the subset
	 * @return : true is the given set is the subset of parent set, false otherwise
	 */
	public boolean isSubset(IntSet newSet){
		if(newSet.set.length == 0){
			throw new AssertionError("The array is empty");
		}
		if(this.size() < newSet.size()){
			return false;
		}else{
			for(int i = 0; i < newSet.size(); i++){
				int j = 0;
				for(; j < this.size(); j++){
					if(this.set[j] == newSet.set[i]){
						break;
					}
				}
				if(j == this.set.length){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Method to sort the set. It uses bubble sort to do so.
	 * @param array : the set which is to be sorted
	 * @return : the sorted set
	 */
	private int[] sortSet(int[] array){
		int[] newArray = array;
		for(int i = 0; i < newArray.length; i++){
			for(int j = i+1; j < newArray.length; j++){
				if(newArray[i] > newArray[j]){
					int swap = newArray[i];
					newArray[i] = newArray[j];
					newArray[j] = swap;
				}
			}
		}
		return newArray;
	}
	
	/**
	 * Method to find the union of two given sets
	 * @param firstSet : is the first set which is to be added to other set
	 * @param secondSet : the other set which is also added to other set
	 * @return : the new set which is combination of first and second set and contains unique elements
	 */
	public int[] union(IntSet firstSet, IntSet secondSet){
		if(firstSet.set.length == 0 && secondSet.set.length == 0){
			throw new AssertionError("The array is empty");
		}
		int[] firstArray = sortSet(firstSet.set);
		int[] secondArray = sortSet(secondSet.set);
		int[] thirdArray = new int[firstSet.size() + secondSet.size()];
		int i = 0, j = 0, k = 0;
		while(i < firstArray.length && j < secondArray.length){
			if(firstArray[i] == secondArray[j]){
				thirdArray[k++] = firstArray[i++];
				j++;
			}else if(firstArray[i] < secondArray[j]){
				thirdArray[k++] = firstArray[i++];
			}else if(firstArray[i] > secondArray[j]){
				thirdArray[k++] = secondArray[j++];
			}
		}
		while(i < firstArray.length){
			thirdArray[k++] = firstArray[i++];
		}
		while(j < secondArray.length){
			thirdArray[k++] = secondArray[j++];
		}
		firstArray = new int[k];
		for(int l = 0; l < k; l++){
			firstArray[l] = thirdArray[l];
		}
		return firstArray;
	}
	
	/**
	 * Method to find the complement of the set against the universal set
	 * @return : the complemented set.
	 */
	public int[] getComplement(){
		int[] copyArray = sortSet(this.set);
		int[] newArray = new int[universalSet.length];
		int i = 0, j = 0, k = 0;
		while(i < copyArray.length && j < universalSet.length){
			if(copyArray[i] == universalSet[j]){
				i++;
				j++;
			}else if(copyArray[i] > universalSet[j]){
				newArray[k++] = universalSet[j++];
			}else if(copyArray[i] < universalSet[j]){
				i++;
			}
		}
		while(j < universalSet.length){
			newArray[k++] = universalSet[j++];
		}
		copyArray = new int[k];
		for(int l = 0; l < k; l++){
			copyArray[l] = newArray[l];
		}
		return copyArray;
	}
}
