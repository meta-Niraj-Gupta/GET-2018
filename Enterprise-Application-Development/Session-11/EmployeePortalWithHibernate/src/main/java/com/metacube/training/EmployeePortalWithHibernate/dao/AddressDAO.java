package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.Address;

public interface AddressDAO {
	public Address getById(Integer id);

	public List<Address> getAll();

	public boolean create(Address address);

	public boolean update(Address address);

	public boolean delete(Integer id);

	Address getByEmployeeId(Integer id);
}