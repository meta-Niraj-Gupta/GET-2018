package com.metacube.training.EmployeePortalWithSecurity.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithSecurity.model.Skill;

public interface SkillDAO {
	Skill getSkillById(Integer id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Skill Skill);

	boolean updateSkill(Skill Skill);

	boolean createSkill(Skill Skill);

	Skill getSkillByName(String skillName);

	List<Skill> getSkillByNameForEmployee(Integer empCode);
}