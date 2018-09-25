package com.metacube.training.EmployeePortalWithSecurity.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSecurity.model.EmployeeSkills;

public interface EmployeeSkillsService {
	List<EmployeeSkills> getEmployeeSkills(Integer empCode);

	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);
}
