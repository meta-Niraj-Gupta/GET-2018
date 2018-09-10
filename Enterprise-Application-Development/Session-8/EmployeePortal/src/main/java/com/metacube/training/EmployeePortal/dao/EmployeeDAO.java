package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(Integer employeeId);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
}
