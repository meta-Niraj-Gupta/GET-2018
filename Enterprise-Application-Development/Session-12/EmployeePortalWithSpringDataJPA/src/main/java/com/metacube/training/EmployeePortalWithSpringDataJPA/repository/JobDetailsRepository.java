package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.JobDetails;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer> {

	JobDetails findByEmpCode(Integer empCode);

}
