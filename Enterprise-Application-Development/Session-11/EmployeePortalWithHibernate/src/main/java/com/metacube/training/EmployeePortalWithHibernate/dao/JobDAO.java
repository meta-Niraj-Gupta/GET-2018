package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.Job;

public interface JobDAO {
	Job getJobById(Integer id);

	List<Job> getAllJobs();

	boolean deleteJob(Job Job);

	boolean updateJob(Job Job);

	boolean createJob(Job Job);
}