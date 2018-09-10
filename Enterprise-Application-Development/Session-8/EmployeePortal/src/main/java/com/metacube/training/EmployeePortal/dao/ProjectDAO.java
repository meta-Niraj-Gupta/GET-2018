package com.metacube.training.EmployeePortal.dao;

import java.util.List;
import com.metacube.training.EmployeePortal.model.Project;

public interface ProjectDAO {

	Project getProjectById(Integer id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);
}
