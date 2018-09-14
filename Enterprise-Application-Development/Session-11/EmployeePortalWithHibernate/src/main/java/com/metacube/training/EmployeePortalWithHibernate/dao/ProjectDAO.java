package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.Project;

public interface ProjectDAO {
	Project getProjectById(Integer id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);

	Project getProjectByName(String input);
}
