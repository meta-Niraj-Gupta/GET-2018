package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Employee;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployeeById(Integer employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public boolean deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return true;
	}

	public Integer createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee.getEmpCode();
	}

	public List<Employee> getEmployeeByName(String input) {
		return employeeRepository.findEmployeeByName("%"+input+"%");
	}

	public List<Employee> getEmployeeByProject(Integer projectId) {
		return employeeRepository.findEmployeeByProject(projectId);
	}

	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		return employeeRepository.findEmployeeByTotalExperience(totalExp);
	}

	public Employee getEmployeeByEmail(String emailId) {
		return employeeRepository.findByEmailId(emailId);
	}
}