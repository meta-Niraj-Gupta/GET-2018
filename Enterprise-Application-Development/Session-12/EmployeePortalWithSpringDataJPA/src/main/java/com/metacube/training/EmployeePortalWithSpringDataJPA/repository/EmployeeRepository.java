package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmailId(String emailId);

	@Query("SELECT e FROM Employee e WHERE CONCAT(e.firstName,' ',e.lastName) LIKE :input AND isActive=1")
	List<Employee> findEmployeeByName(@Param("input") String input);

	@Query("SELECT e FROM Employee e WHERE e.empCode IN (SELECT empCode FROM JobDetails WHERE currProjId= :projectId) AND isActive=1")
	List<Employee> findEmployeeByProject(@Param("projectId") Integer projectId);

	@Query("SELECT E FROM Employee e WHERE e.empCode IN (SELECT empCode FROM JobDetails WHERE totalExp >= :totalExp) AND isActive=1")
	List<Employee> findEmployeeByTotalExperience(@Param("totalExp") Integer totalExp);
}
