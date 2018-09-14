package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.EmployeeSkills;

public interface EmployeeSkillsDAO {
	List<EmployeeSkills> getEmployeeSkills(Integer skillCode);

	boolean createEmployeeSkills(EmployeeSkills EmployeeSkills);

	List<EmployeeSkills> getSkillsOfEmployee(Integer empCode);

}