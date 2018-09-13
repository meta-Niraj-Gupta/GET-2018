package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.JobDAO;
import com.metacube.training.EmployeePortal.model.Job;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobDAO jobDao;

	public Job getJobById(Integer jobId) {
		return jobDao.getJobById(jobId);
	}

	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}

	public boolean deleteJob(Integer id) {
		Job job = jobDao.getJobById(id);
		return jobDao.deleteJob(job);
	}

	public boolean updateJob(Job job) {
		return jobDao.updateJob(job);
	}

	public boolean createJob(Job job) {
		return jobDao.createJob(job);
	}

}