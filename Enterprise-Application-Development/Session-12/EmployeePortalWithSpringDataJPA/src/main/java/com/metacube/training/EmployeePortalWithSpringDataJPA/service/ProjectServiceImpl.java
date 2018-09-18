package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Project;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	public Project getProjectById(Integer id) {
		return projectRepository.findById(id).get();
	}

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public boolean deleteProject(Integer id) {
		projectRepository.deleteById(id);
		return true;
	}

	public boolean updateProject(Project project) {
		projectRepository.save(project);
		return false;
	}

	public boolean createProject(Project project) {
		projectRepository.save(project);
		return false;
	}

	public Project getProjectByName(String input) {
		return projectRepository.findByDescription(input);
	}
}
