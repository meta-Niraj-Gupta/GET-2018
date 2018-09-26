package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService {
	Job getJobById(Integer jobId);

	List<Job> getAllJobs();

	boolean deleteJob(Integer id);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}