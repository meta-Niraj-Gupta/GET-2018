package com.metacube.training.EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.EmployeePortal.model.JobDetails;

public class JobDetailsMapper implements RowMapper<JobDetails> {

	public JobDetails mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setCurrProjId(resultSet.getInt("currProjId"));
		jobDetails.setDateOfJoining(resultSet.getDate("dateOfJoining"));
		jobDetails.setEmpCode(resultSet.getInt("empCode"));
		jobDetails.setJobCode(resultSet.getInt("jobCode"));
		jobDetails.setJobDetailId(resultSet.getInt("jobDetailId"));
		jobDetails.setReportingManager(resultSet.getInt("reportingManager"));
		jobDetails.setTeamLead(resultSet.getInt("teamLead"));
		jobDetails.setTotalExp(resultSet.getInt("totalExp"));
		return jobDetails;
	}

}
