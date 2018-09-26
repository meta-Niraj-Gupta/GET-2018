package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectService {
	Project getProjectById(Integer ProjectId);

	List<Project> getAllProjects();

	boolean deleteProject(Integer id);

	boolean updateProject(Project Project);

	boolean createProject(Project Project);

	Project getProjectByName(String input);
}
