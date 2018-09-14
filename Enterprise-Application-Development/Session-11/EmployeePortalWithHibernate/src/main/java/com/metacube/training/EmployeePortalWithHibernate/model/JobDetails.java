package com.metacube.training.EmployeePortalWithHibernate.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobdetails")
public class JobDetails {
	@Column(name = "empCode", nullable = false)
	private Integer empCode;

	@Id
	@Column(name = "jobDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobDetailId;

	@Column(name = "dateOfJoining", nullable = false)
	private Date dateOfJoining;

	@Column(name = "totalExp", nullable = false)
	private short totalExp;

	@Column(name = "jobCode", nullable = false)
	private Integer jobCode;

	@Column(name = "reportingManager")
	private Integer reportingManager;

	@Column(name = "teamLead")
	private Integer teamLead;

	@Column(name = "currProjId")
	private Integer currProjId;

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

	public short getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(short totalExp) {
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