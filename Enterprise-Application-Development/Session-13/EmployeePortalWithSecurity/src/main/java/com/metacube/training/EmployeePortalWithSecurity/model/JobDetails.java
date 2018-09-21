package com.metacube.training.EmployeePortalWithSecurity.model;

import java.sql.Date;

public class JobDetails {
	private Integer empCode, jobDetailId;
	private Date dateOfJoining;
	private Integer totalExp, jobCode, reportingManager, teamLead, currProjId;

	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	public Integer getJobDetailId() {
		return jobDetailId;
	}

	public void setJobDetailId(Integer jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(Integer totalExp) {
		this.totalExp = totalExp;
	}

	public Integer getJobCode() {
		return jobCode;
	}

	public void setJobCode(Integer jobCode) {
		this.jobCode = jobCode;
	}

	public Integer getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(Integer reportingManager) {
		this.reportingManager = reportingManager;
	}

	public Integer getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(Integer teamLead) {
		this.teamLead = teamLead;
	}

	public Integer getCurrProjId() {
		return currProjId;
	}

	public void setCurrProjId(Integer currProjId) {
		this.currProjId = currProjId;
	}
}