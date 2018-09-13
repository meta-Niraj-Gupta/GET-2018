package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortal.mapper.JobMapper;
import com.metacube.training.EmployeePortal.model.Job;

@Repository
public class JobDAOImpl implements JobDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_JOB = "select * from jobtitlemaster where jobCode = ?";
	private final String SQL_DELETE_JOB = "delete from jobtitlemaster where jobCode = ?";
	private final String SQL_UPDATE_JOB = "update jobtitlemaster set jobTitle = ? where jobCode = ?";
	private final String SQL_GET_ALL = "select * from jobtitlemaster";
	private final String SQL_INSERT_JOB = "insert into jobtitlemaster(jobTitle) values(?)";

	public Job getJobById(Integer jobId) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOB,
				new Object[] { jobId }, new JobMapper());
	}

	public List<Job> getAllJobs() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
	}

	public boolean deleteJob(Job job) {
		return jdbcTemplate.update(SQL_DELETE_JOB, job.getJobCode()) > 0;
	}

	public boolean updateJob(Job job) {
		return jdbcTemplate.update(SQL_UPDATE_JOB, job.getJobTitle(),
				job.getJobCode()) > 0;
	}

	public boolean createJob(Job job) {
		return jdbcTemplate.update(SQL_INSERT_JOB, job.getJobTitle()) > 0;
	}
}