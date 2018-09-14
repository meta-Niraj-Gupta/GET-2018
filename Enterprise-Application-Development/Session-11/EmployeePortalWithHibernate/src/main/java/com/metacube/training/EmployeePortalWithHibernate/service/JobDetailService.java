package com.metacube.training.EmployeePortalWithHibernate.service;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.JobDetails;

public interface JobDetailService {
	public JobDetails getById(Integer id);

	public List<JobDetails> getAll();

	public Integer create(JobDetails jobDetail);

	public boolean update(JobDetails jobDetail);

	public boolean delete(Integer id);

	JobDetails getByEmployeeId(Integer empCode);
}