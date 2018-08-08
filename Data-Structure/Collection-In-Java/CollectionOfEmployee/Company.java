package CollectionOfEmployee;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Niraj Gupta
 * Class to represent the company which have employee.
 *
 */
public class Company{
	private Map<String, Employee> company = new HashMap<String, Employee>();

	/**
	 * Method to add employee to the company database.
	 * @param empId : The unique id given to the employee.
	 * @param name : The name of the employee.
	 * @param address : The address of the employee.
	 * @return : True if the addition of employee to the database is successful, false otherwise.
	 */
	public boolean addEmployee(String empId, String name, String address){
		boolean isAdded = false;
		if(company.containsKey(empId)){
			throw new AssertionError("Employee is already added.");
		}else{
			company.put(empId, new Employee(empId, name, address));
			isAdded = true;
		}
		return isAdded;
	}

	/**
	 * Method to get the employee details from the database.
	 * @return : The details of the employees.
	 */
	public Map<String, Employee> getEmployeeDetails() {
		return company;
	}
}
