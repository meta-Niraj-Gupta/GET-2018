package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.ProjectDAO;
import com.metacube.training.EmployeePortal.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	public Project getProjectById(Integer id) {
		return projectDAO.getProjectById(id);
	}

	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	public boolean deleteProject(Integer id) {
		Project project = projectDAO.getProjectById(id);
		return projectDAO.deleteProject(project);
	}

	public boolean updateProject(Project project) {
		return projectDAO.updateProject(project);
	}

	public boolean createProject(Project project) {
		return projectDAO.createProject(project);
	}

}
