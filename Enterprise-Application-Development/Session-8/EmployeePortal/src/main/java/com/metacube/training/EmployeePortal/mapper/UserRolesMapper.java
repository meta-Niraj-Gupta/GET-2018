
package com.metacube.training.EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortal.model.UserRoles;

public class UserRolesMapper implements RowMapper<UserRoles> {

	@Override
	public UserRoles mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		UserRoles userRoles = new UserRoles();
		userRoles.setRole(resultSet.getString("role"));
		userRoles.setUsername(resultSet.getString("username"));
		userRoles.setUserRoleId(resultSet.getInt("userRoleId"));
		return null;
	}

}
