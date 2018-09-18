package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Project;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	Project findByDescription(String input);

}
