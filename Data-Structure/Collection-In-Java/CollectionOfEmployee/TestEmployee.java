package CollectionOfEmployee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEmployee{
	private Company company;
	
	@Before
	public void setUp(){
		company = new Company();
	}
	
	@Test
	public void addEmployee_HappyFlow(){
		assertTrue(company.addEmployee("2", "Jai", "Jaipur"));
		assertTrue(company.addEmployee("3", "Niraj", "Ajmer"));
		assertTrue(company.addEmployee("1", "Abhay", "Jodhpur"));
		assertTrue(company.addEmployee("5", "Twinkle", "Sikar"));
		assertTrue(company.addEmployee("4", "Namrata", "Delhi"));
	}
	
	@Test(expected = AssertionError.class)
	public void addEmployee_Exception_IfTheEmployeeAlreadyExist(){
		company.addEmployee("1", "Niraj", "Jaipur");
		company.addEmployee("1", "Jai", "Jaipur");
	}
	
	@Test
	public void sortByName_HappyFlow(){
		Company employees = new Company();
		employees.addEmployee("2", "Jai", "Jaipur");
		employees.addEmployee("3", "Niraj", "Ajmer");
		employees.addEmployee("1", "Abhay", "Jodhpur");
		employees.addEmployee("5", "Twinkle", "Sikar");
		employees.addEmployee("4", "Namrata", "Delhi");
		
		
		
		List<Employee> sortedList = SortingBasedOnName.sortByName(employees.getEmployeeDetails());
		
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee("1", "Abhay", "Jodhpur"));
		expectedResult.add(new Employee("2", "Jai", "Jaipur"));
		expectedResult.add(new Employee("4", "Namrata", "Delhi"));
		expectedResult.add(new Employee("3", "Niraj", "Ajmer"));
		expectedResult.add(new Employee("5", "Twinkle", "Sikar"));
		
		for(int i=0;i<expectedResult.size();i++){
			assertEquals(expectedResult.get(i).toString(), sortedList.get(i).toString());
		}
		
	}
	
	@Test
	public void naturalSorting_HappyFlow(){
		Company employees = new Company();
		employees.addEmployee("2", "Jai", "Jaipur");
		employees.addEmployee("3", "Niraj", "Ajmer");
		employees.addEmployee("1", "Abhay", "Jodhpur");
		employees.addEmployee("5", "Twinkle", "Sikar");
		employees.addEmployee("4", "Namrata", "Delhi");
		
		
		
		List<Employee> sortedList = NaturalSorting.naturalSort(employees.getEmployeeDetails());
		
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee("1", "Abhay", "Jodhpur"));
		expectedResult.add(new Employee("2", "Jai", "Jaipur"));
		expectedResult.add(new Employee("3", "Niraj", "Ajmer"));
		expectedResult.add(new Employee("4", "Namrata", "Delhi"));
		expectedResult.add(new Employee("5", "Twinkle", "Sikar"));
		
		for(int i=0;i<expectedResult.size();i++){
			assertEquals(expectedResult.get(i).toString(), sortedList.get(i).toString());
		}
		
	}

}
