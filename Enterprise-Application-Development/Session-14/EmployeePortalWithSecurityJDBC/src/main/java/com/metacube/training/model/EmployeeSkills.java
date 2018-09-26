package com.metacube.training.model;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skillid")
	private Integer skillId;
	@Column(name = "empcode")
	private Integer empCode;
	@Column(name = "skillcode")
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
