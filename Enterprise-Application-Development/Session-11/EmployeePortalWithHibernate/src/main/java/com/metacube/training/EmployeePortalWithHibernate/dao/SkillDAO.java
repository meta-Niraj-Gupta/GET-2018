package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalWithHibernate.model.Skill;

public interface SkillDAO {
	Skill getSkillById(Integer id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Skill Skill);

	boolean updateSkill(Skill Skill);

	boolean createSkill(Skill Skill);

	Skill getSkillByName(String skillName);

	List<Skill> getSkillByNameForEmployee(Integer empCode);
}