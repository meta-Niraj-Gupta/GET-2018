package com.metacube.training.EmployeePortal.dao;

import java.util.List;
import com.metacube.training.EmployeePortal.model.JobDetails;

public interface JobDetailDAO {
	public JobDetails getById(Integer id);

	public List<JobDetails> getAll();

	public Integer create(JobDetails jobDetail);

	public boolean update(JobDetails jobDetail);

	public boolean delete(Integer id);

	JobDetails getByEmployeeId(Integer empCode);
}
