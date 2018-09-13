package com.metacube.training.EmployeePortal.service;

import java.util.List;
import com.metacube.training.EmployeePortal.model.Project;

public interface ProjectService {
	Project getProjectById(Integer ProjectId);

	List<Project> getAllProjects();

	boolean deleteProject(Integer id);

	boolean updateProject(Project Project);

	boolean createProject(Project Project);

	Project getProjectByName(String input);

}
