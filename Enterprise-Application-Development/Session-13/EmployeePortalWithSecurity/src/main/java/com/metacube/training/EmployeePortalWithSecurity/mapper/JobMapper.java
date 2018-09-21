package com.metacube.training.EmployeePortalWithSecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSecurity.model.Job;

public class JobMapper implements RowMapper<Job> {

	public Job mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Job job = new Job();
		job.setJobCode(resultSet.getInt("jobCode"));
		job.setJobTitle(resultSet.getString("jobTitle"));
		return job;
	}

}
