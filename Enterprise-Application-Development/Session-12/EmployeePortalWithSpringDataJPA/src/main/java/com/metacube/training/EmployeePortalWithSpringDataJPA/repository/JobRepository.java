package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
