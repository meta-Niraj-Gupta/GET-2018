package com.metacube.training.EmployeePortalWithHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithHibernate.dao.EmployeeDAO;
import com.metacube.training.EmployeePortalWithHibernate.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	public Employee getEmployeeById(Integer employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public boolean deleteEmployee(Integer id) {
		Employee employee = employeeDao.getEmployeeById(id);
		return employeeDao.deleteEmployee(employee);
	}

	public boolean updateEmployee(Employee employee) {
		System.out.println(employee.toString());
		return employeeDao.updateEmployee(employee);
	}

	public Integer createEmployee(Employee employee) {
		return employeeDao.createEmployee(employee);
	}

	public List<Employee> getEmployeeByName(String input) {
		return employeeDao.getEmployeeByName(input);
	}

	public List<Employee> getEmployeeByProject(Integer projectId) {
		return employeeDao.getEmployeeByProject(projectId);
	}

	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		return employeeDao.getEmployeeByTotalExperience(totalExp);
	}

	public Employee getEmployeeByEmail(String emailId) {
		return employeeDao.getEmployeeByEmail(emailId);
	}
}