package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.Address;
import com.metacube.training.EmployeePortalWithHibernate.model.Project;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Address getById(Integer id) {
		Address address = (Address) sessionFactory.getCurrentSession()
				.createCriteria(Address.class)
				.add(Restrictions.eq("addressId", id)).uniqueResult();
		return address;
	}

	public Address getByEmployeeId(Integer id) {
		Address address = (Address) sessionFactory.getCurrentSession()
				.createCriteria(Address.class)
				.add(Restrictions.eq("empCode", id)).uniqueResult();
		return address;
	}

	public List<Address> getAll() {
		return null;
	}

	public boolean create(Address address) {
		sessionFactory.getCurrentSession().save(address);
		return true;
	}

	public boolean update(Address address) {
		Address addressToUpdate = (Address) sessionFactory.getCurrentSession()
				.createCriteria(Address.class)
				.add(Restrictions.eq("addressId", address.getAddressId()))
				.uniqueResult();
		addressToUpdate.setAddLine1(address.getAddLine1());
		addressToUpdate.setAddLine2(address.getAddLine2());
		addressToUpdate.setCity(address.getCity());
		addressToUpdate.setPincode(address.getPincode());
		addressToUpdate.setState(address.getState());
		sessionFactory.getCurrentSession().update(addressToUpdate);
		return true;
	}

	public boolean delete(Integer id) {
		return false;
	}

}