package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortal.mapper.JobDetailsMapper;
import com.metacube.training.EmployeePortal.model.JobDetails;

@Repository
public class JobDetailDAOImpl implements JobDetailDAO {

	private JdbcTemplate jdbcTemplate;

	private static final String SQL_GET_ALL = "SELECT * FROM jobDetails";
	private static final String SQL_GET_BY_ID = "SELECT *FROM jobDetails WHERE jobDetailId = ?";
	private static final String SQL_GET_BY_EMP_ID = "SELECT *FROM jobDetails WHERE empCode = ?";
	private static final String SQL_INSERT = "INSERT INTO jobDetails (empCode, dateOfJoining, totalExp, jobCode, reportingManager, teamLead, currProjId) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE jobDetails SET dateOfJoining = ?, totalExp = ?, jobCode = ?, reportingManager = ?, teamLead = ?, currProjId = ?, empCode = ? WHERE jobDetailId = ?";
	private static final String SQL_DELETE = "DELETE FROM job_detail WHERE id = ?";

	@Autowired
	public JobDetailDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JobDetails getById(Integer id) {
		return jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id },
				new JobDetailsMapper());
	}

	public JobDetails getByEmployeeId(Integer empCode) {
		return jdbcTemplate.queryForObject(SQL_GET_BY_EMP_ID,
				new Object[] { empCode }, new JobDetailsMapper());
	}

	public List<JobDetails> getAll() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobDetailsMapper());
	}

	public Integer create(JobDetails jobDetail) {
		return jdbcTemplate.update(SQL_INSERT, jobDetail.getEmpCode(),
				jobDetail.getDateOfJoining(), jobDetail.getTotalExp(),
				jobDetail.getJobCode(), jobDetail.getReportingManager(),
				jobDetail.getTeamLead(), jobDetail.getCurrProjId());
	}

	public boolean update(JobDetails jobDetail) {
		return false;
	}

	public boolean delete(Integer id) {
		return false;
	}
}