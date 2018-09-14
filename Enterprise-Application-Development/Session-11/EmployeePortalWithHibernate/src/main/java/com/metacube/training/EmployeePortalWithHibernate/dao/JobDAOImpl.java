package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Job getJobById(Integer jobId) {
		Job job = (Job) sessionFactory.getCurrentSession()
				.createCriteria(Job.class)
				.add(Restrictions.eq("jobCode", jobId)).uniqueResult();
		return job;
	}

	public List<Job> getAllJobs() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Job.class);
		return criteria.list();
	}

	public boolean deleteJob(Job job) {
		Job jobToDelete = (Job) sessionFactory.getCurrentSession()
				.createCriteria(Job.class)
				.add(Restrictions.eq("jobCode", job.getJobCode()))
				.uniqueResult();
		sessionFactory.getCurrentSession().delete(jobToDelete);
		return true;
	}

	public boolean updateJob(Job job) {
		Job jobToUpdate = (Job) sessionFactory.getCurrentSession()
				.createCriteria(Job.class)
				.add(Restrictions.eq("id", job.getJobCode())).uniqueResult();
		jobToUpdate.setJobTitle(job.getJobTitle());
		sessionFactory.getCurrentSession().update(jobToUpdate);
		return true;
	}

	public boolean createJob(Job job) {
		sessionFactory.getCurrentSession().save(job);
		return true;
	}
}