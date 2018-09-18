package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findByEmpCode(Integer id);
}
