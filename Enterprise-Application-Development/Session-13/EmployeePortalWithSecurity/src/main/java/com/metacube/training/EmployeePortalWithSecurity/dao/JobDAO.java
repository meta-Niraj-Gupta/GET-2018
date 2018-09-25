package com.metacube.training.EmployeePortalWithSecurity.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithSecurity.model.Job;

public interface JobDAO {
	Job getJobById(Integer id);

	List<Job> getAllJobs();

	boolean deleteJob(Job Job);

	boolean updateJob(Job Job);

	boolean createJob(Job Job);
}