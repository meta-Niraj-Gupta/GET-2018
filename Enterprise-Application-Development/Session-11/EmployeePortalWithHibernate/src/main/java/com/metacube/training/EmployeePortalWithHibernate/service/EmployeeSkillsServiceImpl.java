package com.metacube.training.EmployeePortalWithHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithHibernate.dao.EmployeeSkillsDAO;
import com.metacube.training.EmployeePortalWithHibernate.model.EmployeeSkills;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {

	@Autowired
	private EmployeeSkillsDAO employeeSkillDao;

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
