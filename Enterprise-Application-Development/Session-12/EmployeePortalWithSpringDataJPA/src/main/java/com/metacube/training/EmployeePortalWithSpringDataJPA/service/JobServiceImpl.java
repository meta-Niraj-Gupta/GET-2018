package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Job;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobRepository jobRepository;

	public Job getJobById(Integer jobId) {
		return jobRepository.findById(jobId).get();
	}

	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	public boolean deleteJob(Integer id) {
		jobRepository.deleteById(id);
		return true;
	}

	public boolean updateJob(Job job) {
		jobRepository.save(job);
		return true;
	}

	public boolean createJob(Job job) {
		jobRepository.save(job);
		return true;
	}

}