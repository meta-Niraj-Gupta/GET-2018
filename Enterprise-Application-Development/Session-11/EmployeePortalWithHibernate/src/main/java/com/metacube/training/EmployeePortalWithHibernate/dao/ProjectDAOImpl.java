package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Project getProjectById(Integer id) {
		Project project = (Project) sessionFactory.getCurrentSession()
				.createCriteria(Project.class).add(Restrictions.eq("id", id))
				.uniqueResult();
		return project;
	}

	public List<Project> getAllProjects() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Project.class);
		return criteria.list();
	}

	public boolean deleteProject(Project project) {
		Project projectToDelete = (Project) sessionFactory.getCurrentSession()
				.createCriteria(Project.class)
				.add(Restrictions.eq("id", project.getId())).uniqueResult();
		sessionFactory.getCurrentSession().delete(projectToDelete);
		return true;
	}

	public boolean updateProject(Project project) {
		Project projectToUpdate = (Project) sessionFactory.getCurrentSession()
				.createCriteria(Project.class)
				.add(Restrictions.eq("id", project.getId())).uniqueResult();
		projectToUpdate.setDescription(project.getDescription());
		projectToUpdate.setEndDate(project.getEndDate());
		projectToUpdate.setStartDate(project.getStartDate());
		sessionFactory.getCurrentSession().update(projectToUpdate);
		return true;
	}

	public boolean createProject(Project project) {
		sessionFactory.getCurrentSession().save(project);
		return true;
	}

	public Project getProjectByName(String input) {
		Project project = (Project) sessionFactory.getCurrentSession()
				.createCriteria(Project.class)
				.add(Restrictions.eq("description", input)).uniqueResult();
		return project;
	}

}