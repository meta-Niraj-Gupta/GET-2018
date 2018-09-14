package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.EmployeeSkills;

@Repository
@Transactional
public class EmployeeSkillsDAOImpl implements EmployeeSkillsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<EmployeeSkills> getEmployeeSkills(Integer skillCode) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(EmployeeSkills.class)
				.add(Restrictions.eq("skillCode", skillCode));
		return criteria.list();
	}

	public List<EmployeeSkills> getSkillsOfEmployee(Integer empCode) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(EmployeeSkills.class)
				.add(Restrictions.eq("empCode", empCode));
		return criteria.list();
	}

	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		sessionFactory.getCurrentSession().save(employeeSkills);
		return true;
	}
}
