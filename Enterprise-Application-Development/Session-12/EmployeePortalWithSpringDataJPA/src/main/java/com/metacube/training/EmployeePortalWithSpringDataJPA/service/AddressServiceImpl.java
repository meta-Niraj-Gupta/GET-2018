package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Address;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public Address getById(Integer id) {
		return addressRepository.findById(id).get();
	}

	public Address getByEmployeeId(Integer id) {
		return addressRepository.findByEmpCode(id);
	}

	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	public boolean create(Address address) {
		addressRepository.save(address);
		return true;
	}

	public boolean update(Address address) {
		addressRepository.save(address);
		return true;
	}

	public boolean delete(Integer id) {
		addressRepository.deleteById(id);
		return false;
	}

}