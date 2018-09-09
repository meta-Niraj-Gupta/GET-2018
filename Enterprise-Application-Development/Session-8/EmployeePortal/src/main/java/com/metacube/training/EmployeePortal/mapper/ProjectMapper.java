package com.metacube.training.EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortal.model.Project;

public class ProjectMapper implements RowMapper<Project> {

	public Project mapRow(ResultSet result, int arg1) throws SQLException {
		Project project = new Project();
		project.setId(result.getInt("id"));
		project.setEndDate(result.getDate("end_date"));
		project.setStartDate(result.getDate("start_date"));
		project.setDescription(result.getString("description"));
		project.setProjectLogo(result.getString("project_logo"));
		return project;
	}
}
