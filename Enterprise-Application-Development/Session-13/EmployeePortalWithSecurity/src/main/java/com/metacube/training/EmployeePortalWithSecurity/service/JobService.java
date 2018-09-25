package com.metacube.training.EmployeePortalWithSecurity.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithSecurity.model.Job;

public interface JobService {
	Job getJobById(Integer jobId);

	List<Job> getAllJobs();

	boolean deleteJob(Integer id);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}