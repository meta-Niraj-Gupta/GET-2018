package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.EmployeeSkillsDAOImpl;
import com.metacube.training.EmployeePortal.model.EmployeeSkills;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

	@Autowired
	private EmployeeSkillsDAOImpl employeeSkillDao;

	public List<EmployeeSkills> getEmployeeSkills(Integer empCode) {
		return employeeSkillDao.getEmployeeSkills(empCode);
	}

	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		return employeeSkillDao.createEmployeeSkills(employeeSkills);
	}

	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		return employeeSkillDao.getSkillsOfEmployee(empCode);
	}

}
