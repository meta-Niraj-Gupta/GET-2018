package com.metacube.training.EmployeePortalWithSpringDataJPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeskills")
public class EmployeeSkills {
	@Id
	@Column(name = "skillId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skillId;

	@Column(name = "empCode", nullable = false)
	private Integer empCode;

	@Column(name = "skillCode", nullable = false)
	private Integer skillCode;

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	public Integer getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(Integer skillCode) {
		this.skillCode = skillCode;
	}
}
