package CollectionOfEmployee;

import java.util.Comparator;

/**
 * @author Niraj Gupta
 * Class to represent an Employee with id, name and address.
 * It also implements the comparable interface for sorting employee.
 */
public class Employee implements Comparable<Employee>{
	private String name;
	private String id;
	private String address;

	/**
	 * Parameterized Constructor
	 * @param id : The unique id given to an employee.
	 * @param name : The name of the employee.
	 * @param address : The address of the employee.
	 */
	public Employee(String id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getAddress(){
		return address;
	}

	/**
	 * Method to Compare Employee based in their ID.
	 */
	@Override
	public int compareTo(Employee employee){
		return id.compareTo(employee.getId());
	}

	/**
	 * Comparator class to sort employee based on their name.
	 */
	public static Comparator<Employee> NameComparator = new Comparator<Employee>(){

		/**
		 * Method to perform the comparison based on employee name.
		 */
		@Override
		public int compare(Employee e1, Employee e2){
			return e1.getName().compareTo(e2.getName());
		}
	};

	/**
	 * Method to convert the object details into string.
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", address=" + address
				+ "]";
	} 


}
