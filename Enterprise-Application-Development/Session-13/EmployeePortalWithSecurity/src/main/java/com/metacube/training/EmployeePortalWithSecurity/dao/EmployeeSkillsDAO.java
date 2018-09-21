package com.metacube.training.EmployeePortalWithSecurity.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithSecurity.model.EmployeeSkills;

public interface EmployeeSkillsDAO {
	List<EmployeeSkills> getEmployeeSkills(Integer skillCode);

	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);

}