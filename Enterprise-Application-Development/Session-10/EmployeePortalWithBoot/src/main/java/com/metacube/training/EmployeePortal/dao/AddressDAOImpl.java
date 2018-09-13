package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortal.mapper.AddressMapper;
import com.metacube.training.EmployeePortal.model.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {
	private JdbcTemplate jdbcTemplate;

	public AddressDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_ADDRESS_BY_EMP = "select * from address where empCode = ?";
	private final String SQL_FIND_ADDRESS = "select * from address where addressId = ?";
	private final String SQL_UPDATE_ADDRESS = "update address set addLine1 = ?, addLine2 = ?,city = ?,state = ?,pincode = ? where addressId = ?";
	private final String SQL_INSERT_ADDRESS = "insert into address(empCode,addLine1,addLine2,city,state,pincode) values(?,?,?,?,?,?)";

	public Address getById(Integer id) {
		return jdbcTemplate.queryForObject(SQL_FIND_ADDRESS,
				new Object[] { id }, new AddressMapper());
	}

	public Address getByEmployeeId(Integer id) {
		System.out.println(id);
		return jdbcTemplate.queryForObject(SQL_FIND_ADDRESS_BY_EMP,
				new Object[] { id }, new AddressMapper());
	}

	public List<Address> getAll() {
		return null;
	}

	public boolean create(Address address) {
		return jdbcTemplate.update(SQL_INSERT_ADDRESS, address.getEmpCode(),
				address.getAddLine1(), address.getAddLine2(),
				address.getCity(), address.getState(), address.getPincode()) > 0;
	}

	public boolean update(Address address) {
		return jdbcTemplate.update(SQL_UPDATE_ADDRESS, address.getAddLine1(),
				address.getAddLine2(), address.getCity(), address.getState(),
				address.getPincode(), address.getAddressId()) > 0;
	}

	public boolean delete(Integer id) {
		return false;
	}

}