package com.metacube.training.EmployeePortalWithSecurity.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithSecurity.model.Project;

public interface ProjectDAO {
	Project getProjectById(Integer id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);

	Project getProjectByName(String input);
}
