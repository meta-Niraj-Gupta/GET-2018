package com.metacube.training.EmployeePortalWithSpringDataJPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobtitlemaster")
public class Job {
	@Id
	@Column(name = "jobCode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobCode;

	@Column(name = "jobTitle", nullable = false, unique = true)
	private String jobTitle;

	public Integer getJobCode() {
		return jobCode;
	}

	public void setJobCode(Integer jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
