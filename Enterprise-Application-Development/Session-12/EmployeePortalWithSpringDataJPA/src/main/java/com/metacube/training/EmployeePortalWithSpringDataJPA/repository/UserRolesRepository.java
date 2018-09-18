package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

}
