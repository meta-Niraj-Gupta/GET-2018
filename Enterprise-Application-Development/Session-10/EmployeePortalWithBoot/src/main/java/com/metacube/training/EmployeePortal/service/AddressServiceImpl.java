package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.AddressDAO;
import com.metacube.training.EmployeePortal.model.Address;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO addressDao;

	public Address getById(Integer id) {
		return addressDao.getById(id);
	}

	public Address getByEmployeeId(Integer id) {
		return addressDao.getByEmployeeId(id);
	}

	public List<Address> getAll() {
		return null;
	}

	public boolean create(Address address) {
		return addressDao.create(address);
	}

	public boolean update(Address address) {
		System.out.println(address.toString());
		return addressDao.update(address);
	}

	public boolean delete(Integer id) {
		return false;
	}

}