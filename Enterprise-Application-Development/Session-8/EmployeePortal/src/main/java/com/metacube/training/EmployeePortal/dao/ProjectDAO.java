package com.metacube.training.EmployeePortal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.EmployeePortal.mapper.ProjectMapper;
import com.metacube.training.EmployeePortal.model.Project;

public class ProjectDAO {

	private static final String INSERT_PROJECT = "INSERT INTO project(description, start_date, end_date, project_logo) VALUES(?,?,?,?)";
	private static final String SELECT_ALL_PROJECT = "SELECT description, start_date, end_date, project_logo FROM project";
	private static final String SELECT_PROJECT_BY_ID = "SELECT description, start_date, end_date, project_logo FROM project WHERE id = ?";
	private static final String UPDATE_PROJECT = "UPDATE project SET description = ?, start_date = ?, end_date = ?, project_logo = ? WHERE id = ?";
	private static final String DELETE_PROJECT = "DELETE FROM project WHERE id = ?";

	@Autowired
	private Connection connection;

	public void createProject(Project project) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(INSERT_PROJECT);
		stmt.setString(1, project.getDescription());
		stmt.setDate(2, project.getStartDate());
		stmt.setDate(3, project.getEndDate());
		stmt.setString(4, project.getProjectLogo());
		stmt.setInt(5, project.getId());
		stmt.executeUpdate();
	}

	public void updateProject(Project project) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_PROJECT);
		stmt.setString(1, project.getDescription());
		stmt.setDate(2, project.getStartDate());
		stmt.setDate(3, project.getEndDate());
		stmt.setString(4, project.getProjectLogo());
		stmt.setInt(5, project.getId());
		stmt.executeUpdate();
	}

	public Object getAllProjects() throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SELECT_PROJECT_BY_ID);
		ResultSet set = stmt.executeQuery();
		if (set.next()) {
			return new ProjectMapper().mapRow(set, 0);
		}
		return null;
	}

	public Object getProjectById(int id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(SELECT_PROJECT_BY_ID);
		stmt.setInt(1, id);
		ResultSet set = stmt.executeQuery();
		if (set.next()) {
			return new ProjectMapper().mapRow(set, 0);
		}
		return null;
	}

	public void deleteProject(int id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(DELETE_PROJECT);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
}
