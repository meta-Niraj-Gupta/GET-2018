package com.metacube.training.model;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobdetailid")
	private Integer jobDetailId;
	@Column(name = "empcode")
	private Integer empCode;
	@Column(name = "dateofjoining")
	private Date dateOfJoining;
	@Column(name = "totalexp")
	private Integer totalExp;
	@Column(name = "jobcode")
	private Integer jobCode;
	@Column(name = "reportingmanager")
	private Integer reportingManager;
	@Column(name = "teamlead")
	private Integer teamLead;
	@Column(name = "currprojid")
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