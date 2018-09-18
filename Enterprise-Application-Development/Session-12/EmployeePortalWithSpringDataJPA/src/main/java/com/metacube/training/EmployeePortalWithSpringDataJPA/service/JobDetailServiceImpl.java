package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.JobDetails;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.JobDetailsRepository;

@Service
public class JobDetailServiceImpl implements JobDetailService {
	@Autowired
	private JobDetailsRepository jobDetailsRepository;

	public JobDetails getById(Integer id) {
		return jobDetailsRepository.findById(id).get();
	}

	public List<JobDetails> getAll() {
		return jobDetailsRepository.findAll();
	}

	public JobDetails getByEmployeeId(Integer empCode) {
		return jobDetailsRepository.findByEmpCode(empCode);
	}

	public Integer create(JobDetails jobDetail) {
		jobDetailsRepository.save(jobDetail);
		return jobDetail.getJobCode();
	}

	public boolean update(JobDetails jobDetail) {
		jobDetailsRepository.save(jobDetail);
		return true;
	}

	public boolean delete(Integer id) {
		jobDetailsRepository.deleteById(id);
		return true;
	}

}
