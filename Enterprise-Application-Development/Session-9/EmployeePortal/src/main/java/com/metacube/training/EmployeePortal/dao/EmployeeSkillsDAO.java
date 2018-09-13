package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.EmployeeSkills;

public interface EmployeeSkillsDAO {
	List<EmployeeSkills> getEmployeeSkills(Integer skillCode);

	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);

}