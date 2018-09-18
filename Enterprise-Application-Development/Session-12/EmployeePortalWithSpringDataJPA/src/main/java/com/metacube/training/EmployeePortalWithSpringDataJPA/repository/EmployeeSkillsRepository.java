package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.EmployeeSkills;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Integer> {

	List<EmployeeSkills> findByEmpCode(Integer empCode);

	List<EmployeeSkills> findBySkillCode(Integer skillCode);

}
