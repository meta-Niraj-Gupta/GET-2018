package CollectionOfEmployee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Niraj Gupta
 * Class to perfrom natural sorting.
 *
 */
public class NaturalSorting{
	/**
	 * Method to perform natural sorting on the list of employees.
	 * @param employees : The details of the employees.
	 * @return : The sorted list of employees.
	 */
	public static List<Employee> naturalSort(Map<String, Employee> employees){
		List<Employee> sortedList = new ArrayList<Employee>(employees.values());
		Collections.sort(sortedList);
		return sortedList;
	}
}
