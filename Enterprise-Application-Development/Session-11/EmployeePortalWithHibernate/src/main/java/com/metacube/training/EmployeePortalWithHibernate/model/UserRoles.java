package com.metacube.training.EmployeePortalWithHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userroles")
public class UserRoles {
	@Id
	@Column(name = "userRoleId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleId;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "role", nullable = false, unique = true)
	private String role;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}