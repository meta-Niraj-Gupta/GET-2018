package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.EmployeeSkills;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService {
	@Autowired
	private EmployeeSkillsRepository employeeSkillsRepository;

	public List<EmployeeSkills> getEmployeeSkills(Integer skillCode) {
		return employeeSkillsRepository.findBySkillCode(skillCode);
	}

	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		employeeSkillsRepository.save(employeeSkills);
		return true;
	}

	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		return employeeSkillsRepository.findByEmpCode(empCode);
	}

}
