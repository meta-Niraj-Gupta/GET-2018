package com.metacube.training.EmployeePortal.service;

import java.util.List;
import com.metacube.training.EmployeePortal.model.Address;

public interface AddressService {
	public Address getById(Integer id);

	public List<Address> getAll();

	public boolean create(Address address);

	public boolean update(Address address);

	public boolean delete(Integer id);

	Address getByEmployeeId(Integer id);
}
