package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

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

	boolean resetPassword(Employee employee);

	List<Employee> getAllEmployeesForAdmin();

	boolean enableEmployee(Integer id);
}
