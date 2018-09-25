package com.metacube.training.EmployeePortalWithSecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSecurity.model.EmployeeSkills;

public class EmployeeSkillsMapper implements RowMapper<EmployeeSkills> {

	public EmployeeSkills mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		EmployeeSkills employeeSkills = new EmployeeSkills();
		employeeSkills.setEmpCode(resultSet.getInt("empCode"));
		employeeSkills.setSkillCode(resultSet.getInt("skillCode"));
		employeeSkills.setSkillId(resultSet.getInt("skillId"));
		return employeeSkills;
	}
}
