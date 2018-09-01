package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.DatabaseConnector;
import com.pojo.Employee;

public class ConnectingEmployeeDatabase{
	private Connection connection;
	
	public ConnectingEmployeeDatabase() throws ClassNotFoundException, SQLException{
		connection = DatabaseConnector.getConnection();
	}
	
	public Employee getEmployeeById(int employeeId) throws SQLException{
		PreparedStatement statement = connection.prepareStatement("SELECT id, firstname, lastname, age, email FROM employee_detail WHERE id = ?");
		statement.setInt(1, employeeId);
		ResultSet res = statement.executeQuery();
		if (res.next()){
			return new Employee(employeeId, res.getString("firstname"), res.getString("lastname"), res.getString("email"), res.getInt("age"));
		}
		return null;
	}
	
	public int addEmployeeDetails(Employee employee) throws SQLException{
		PreparedStatement statement = connection.prepareStatement("INSERT INTO employee_detail (firstname, lastname, age, email) VALUES (?,?,?,?)");
		statement.setString(1, employee.getFirstName());
		statement.setString(2, employee.getLastName());
		statement.setInt(3, employee.getAge());
		statement.setString(4, employee.getEmail());
		return statement.executeUpdate();
	}
	
	public int updateEmployeeDetails(Employee employee) throws SQLException{
		PreparedStatement statement = connection.prepareStatement("UPDATE employee_detail SET firstname = ?, lastname = ?, age = ?, email = ? WHERE id = ?");
		statement.setString(1, employee.getFirstName());
		statement.setString(2, employee.getLastName());
		statement.setInt(3, employee.getAge());
		statement.setString(4, employee.getEmail());
		statement.setInt(5, employee.getId());
		return statement.executeUpdate();
	}
	
	public List<Employee> getEmployeeDetails() throws SQLException{
		PreparedStatement statement = connection.prepareStatement("SELECT id, firstname, lastname, age, email FROM employee_detail");
		ResultSet resultSet = statement.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (resultSet.next()){
			employees.add(new Employee(
					resultSet.getInt("id"), 
					resultSet.getString("firstname"), 
					resultSet.getString("lastname"), 
					resultSet.getString("email"), 
					resultSet.getInt("age")));
		}
		return employees;
	}
	
	public List<Employee> getEmployeeByName(String name) throws SQLException{
		PreparedStatement statement = connection.prepareStatement("SELECT id, firstname, lastname, age, email FROM employee_detail WHERE firstname LIKE ? OR lastname LIKE ?");
		statement.setString(1, "%"+name+"%");
		statement.setString(2, "%"+name+"%");
		ResultSet resultSet = statement.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (resultSet.next()){
			employees.add(new Employee(
					resultSet.getInt("id"), 
					resultSet.getString("firstname"), 
					resultSet.getString("lastname"), 
					resultSet.getString("email"), 
					resultSet.getInt("age")));
		}
		return employees;
	}
}
