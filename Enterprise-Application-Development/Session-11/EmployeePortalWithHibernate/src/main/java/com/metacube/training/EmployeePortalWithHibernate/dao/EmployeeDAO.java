package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.Employee;

public interface EmployeeDAO {
	Employee getEmployeeById(Integer employeeId);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	Integer createEmployee(Employee employee);

	List<Employee> getEmployeeByName(String input);

	List<Employee> getEmployeeByProject(Integer projectId);

	List<Employee> getEmployeeByTotalExperience(Integer totalExp);

	Employee getEmployeeByEmail(String emailId);
}
