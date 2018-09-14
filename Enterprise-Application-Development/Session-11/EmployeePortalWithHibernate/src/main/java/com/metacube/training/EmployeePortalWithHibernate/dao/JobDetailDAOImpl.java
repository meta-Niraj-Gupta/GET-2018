package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.JobDetails;
import com.metacube.training.EmployeePortalWithHibernate.model.Project;

@Repository
@Transactional
public class JobDetailDAOImpl implements JobDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private static final String SQL_GET_ALL = "SELECT * FROM jobDetails";
	private static final String SQL_GET_BY_ID = "SELECT *FROM jobDetails WHERE jobDetailId = ?";
	private static final String SQL_GET_BY_EMP_ID = "SELECT *FROM jobDetails WHERE empCode = ?";
	private static final String SQL_INSERT = "INSERT INTO jobDetails (empCode, dateOfJoining, totalExp, jobCode, reportingManager, teamLead, currProjId) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE jobDetails SET dateOfJoining = ?, totalExp = ?, jobCode = ?, reportingManager = ?, teamLead = ?, currProjId = ?, empCode = ? WHERE jobDetailId = ?";
	private static final String SQL_DELETE = "DELETE FROM job_detail WHERE id = ?";

	public JobDetails getById(Integer id) {
		JobDetails jobDetails = (JobDetails) sessionFactory.getCurrentSession()
				.createCriteria(JobDetails.class)
				.add(Restrictions.eq("jobDetailId", id)).uniqueResult();
		return jobDetails;
	}

	public JobDetails getByEmployeeId(Integer empCode) {
		JobDetails jobDetails = (JobDetails) sessionFactory.getCurrentSession()
				.createCriteria(JobDetails.class)
				.add(Restrictions.eq("empCode", empCode)).uniqueResult();
		return jobDetails;
	}

	public List<JobDetails> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				JobDetails.class);
		return criteria.list();
	}

	public Integer create(JobDetails jobDetail) {
		sessionFactory.getCurrentSession().save(jobDetail);
		return jobDetail.getJobDetailId();
	}

	public boolean update(JobDetails jobDetail) {
		return false;
	}

	public boolean delete(Integer id) {
		return false;
	}
}