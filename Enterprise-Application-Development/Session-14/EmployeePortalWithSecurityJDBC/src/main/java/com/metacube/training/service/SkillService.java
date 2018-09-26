package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {
	Skill getSkillById(Integer SkillId);

	List<Skill> getAllSkills();

	boolean deleteSkill(Integer id);

	boolean updateSkill(Skill Skill);

	boolean createSkill(Skill Skill);

	Skill getSkillByName(String skillName);

	List<Skill> getSkillByNameForEmployee(Integer empCode);
}