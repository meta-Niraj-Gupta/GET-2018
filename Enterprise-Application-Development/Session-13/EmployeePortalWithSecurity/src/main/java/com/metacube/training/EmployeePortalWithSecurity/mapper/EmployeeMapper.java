package com.metacube.training.EmployeePortalWithSecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSecurity.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		Employee employee = new Employee();
		employee.setEmpCode(resultSet.getInt("empCode"));
		employee.setFirstName(resultSet.getString("firstName"));
		employee.setLastName(resultSet.getString("lastName"));
		employee.setGender(resultSet.getString("gender"));
		employee.setActive(resultSet.getBoolean("isActive"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setEmailId(resultSet.getString("emailId"));
		employee.setPassword(resultSet.getString("password"));
		employee.setPrimaryContact(resultSet.getString("priamryContact"));
		employee.setSecondaryContact(resultSet.getString("secondaryContact"));
		employee.setProfilePicture(resultSet.getString("profilePicture"));
		employee.setSkypeId(resultSet.getString("skypeId"));
		return employee;
	}

}
