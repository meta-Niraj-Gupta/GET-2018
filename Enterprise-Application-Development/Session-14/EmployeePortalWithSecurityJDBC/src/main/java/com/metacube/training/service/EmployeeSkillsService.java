package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillsService {
	List<EmployeeSkills> getEmployeeSkills(Integer empCode);

	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);
}
