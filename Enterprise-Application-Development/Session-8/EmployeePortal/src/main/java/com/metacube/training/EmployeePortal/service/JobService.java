package com.metacube.training.EmployeePortal.service;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Job;

public interface JobService {

	Job getJobById(Integer jobId);

	List<Job> getAllJobs();

	boolean deleteJob(Integer id);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}