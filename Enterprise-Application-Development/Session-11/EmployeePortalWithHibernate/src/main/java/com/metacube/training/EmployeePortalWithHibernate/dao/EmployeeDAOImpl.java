package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.Employee;
import com.metacube.training.EmployeePortalWithHibernate.model.EmployeeSkills;
import com.metacube.training.EmployeePortalWithHibernate.model.JobDetails;
import com.metacube.training.EmployeePortalWithHibernate.model.Project;
import com.metacube.training.EmployeePortalWithHibernate.model.Skill;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession()
				.createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employeeId))
				.add(Restrictions.eq("isActive", true)).uniqueResult();
		return employee;
	}

	public List<Employee> getAllEmployees() {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Employee.class)
				.add(Restrictions.eq("isActive", true));
		return criteria.list();
	}

	public boolean deleteEmployee(Employee employee) {
		Employee employeeToDelete = (Employee) sessionFactory
				.getCurrentSession().createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employee.getEmpCode()))
				.uniqueResult();
		sessionFactory.getCurrentSession().delete(employeeToDelete);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		Employee employeeToUpdate = (Employee) sessionFactory
				.getCurrentSession().createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employee.getEmpCode()))
				.add(Restrictions.eq("isActive", true)).uniqueResult();
		employeeToUpdate.setPrimaryContact(employee.getPrimaryContact());
		employeeToUpdate.setSecondaryContact(employee.getSecondaryContact());
		sessionFactory.getCurrentSession().update(employeeToUpdate);
		return true;
	}

	public Integer createEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return employee.getEmpCode();
	}

	public List<Employee> getEmployeeByName(String input) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Employee.class);
		Criterion firstname = Restrictions.ilike("firstName", input);
		Criterion lastname = Restrictions.ilike("lastName", input);
		
		LogicalExpression orExpression = Restrictions.or(firstname, lastname);
		criteria.add(orExpression);

		return criteria.add(Restrictions.eq("isActive", true)).list();
	}

	public List<Employee> getEmployeeByProject(Integer projectId) {
		List<JobDetails> empcodes = sessionFactory.getCurrentSession()
				.createCriteria(JobDetails.class)
				.add(Restrictions.eq("currProjId", projectId)).list();
		System.out.println(empcodes.toString());
		List<Employee> employees = new ArrayList<Employee>();
		for (JobDetails jobDetail : empcodes) {
			Employee employee = (Employee) sessionFactory.getCurrentSession()
					.createCriteria(Employee.class)
					.add(Restrictions.eq("empCode", jobDetail.getEmpCode()))
					.add(Restrictions.eq("isActive", true)).uniqueResult();
			employees.add(employee);
		}
		return employees;
	}

	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		List<JobDetails> empcodes = sessionFactory.getCurrentSession()
				.createCriteria(JobDetails.class)
				.add(Restrictions.ge("totalExp", totalExp)).list();
		List<Employee> employees = new ArrayList<Employee>();
		for (JobDetails jobDetail : empcodes) {
			Employee employee = (Employee) sessionFactory.getCurrentSession()
					.createCriteria(Employee.class)
					.add(Restrictions.eq("empCode", jobDetail.getEmpCode()))
					.add(Restrictions.eq("isActive", true)).uniqueResult();
			employees.add(employee);
		}
		return employees;
	}

	public Employee getEmployeeByEmail(String emailId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession()
				.createCriteria(Employee.class)
				.add(Restrictions.eq("emailId", emailId))
				.add(Restrictions.eq("isActive", true)).uniqueResult();
		return employee;
	}
}