package com.metacube.training.EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortal.model.Job;

public class JobMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Job job = new Job();
		job.setJobCode(resultSet.getInt("jobCode"));
		job.setJobTitle(resultSet.getString("jobTitle"));
		return job;
	}

}
