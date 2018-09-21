package com.metacube.training.EmployeePortalWithSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSecurity.dao.JobDetailDAO;
import com.metacube.training.EmployeePortalWithSecurity.model.JobDetails;

@Service
public class JobDetailServiceImpl implements JobDetailService {

	@Autowired
	private JobDetailDAO jobDetailDao;

	public JobDetails getById(Integer id) {
		return null;
	}

	public List<JobDetails> getAll() {
		return null;
	}

	public JobDetails getByEmployeeId(Integer empCode) {
		return jobDetailDao.getByEmployeeId(empCode);
	}

	public Integer create(JobDetails jobDetail) {
		return jobDetailDao.create(jobDetail);
	}

	public boolean update(JobDetails jobDetail) {
		return false;
	}

	public boolean delete(Integer id) {
		return false;
	}

}
