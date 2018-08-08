package CollectionOfEmployee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Niraj Gupta
 * Class to perfrom sorting on employee based on their names.
 *
 */
public class SortingBasedOnName{
	/**
	 * Method to perform sorting on the list of employees based on their names.
	 * @param employeeList : The details of the employees.
	 * @return : The sorted list of employees.
	 */
	public static List<Employee> sortByName(Map<String, Employee> employeeList){
		List<Employee> sortedListByName = new ArrayList<Employee>(employeeList.values());
		Collections.sort(sortedListByName, Employee.NameComparator);
		return sortedListByName;
	}
}
