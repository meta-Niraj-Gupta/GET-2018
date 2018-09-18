package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Employee;

public interface EmployeeService {
	Employee getEmployeeById(Integer employeeId);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(Integer id);

	boolean updateEmployee(Employee employee);

	Integer createEmployee(Employee employee);

	List<Employee> getEmployeeByName(String input);

	List<Employee> getEmployeeByProject(Integer projectId);

	List<Employee> getEmployeeByTotalExperience(Integer totalExp);

	Employee getEmployeeByEmail(String emailId);
}
