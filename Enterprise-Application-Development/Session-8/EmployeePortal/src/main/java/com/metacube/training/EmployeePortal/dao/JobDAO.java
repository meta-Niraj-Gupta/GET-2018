package com.metacube.training.EmployeePortal.dao;

import java.util.List;
import com.metacube.training.EmployeePortal.model.Job;

public interface JobDAO {

	Job getJobById(Integer id);

	List<Job> getAllJobs();

	boolean deleteJob(Job Job);

	boolean updateJob(Job Job);

	boolean createJob(Job Job);

}