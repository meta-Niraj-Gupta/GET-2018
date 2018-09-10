package com.metacube.training.EmployeePortal.model;

public class EmployeeSkills {
	private Integer skillId;
	private Integer empCode;
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

	@Override
	public String toString() {
		return "EmployeeSkills [skillId=" + skillId + ", empCode=" + empCode
				+ ", skillCode=" + skillCode + "]";
	}

}
