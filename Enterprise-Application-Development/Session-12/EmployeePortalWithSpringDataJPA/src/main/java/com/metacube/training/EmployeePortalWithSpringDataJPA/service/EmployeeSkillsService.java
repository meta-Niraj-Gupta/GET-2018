package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.EmployeeSkills;

public interface EmployeeSkillsService {
	List<EmployeeSkills> getEmployeeSkills(Integer empCode);

	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);

}
