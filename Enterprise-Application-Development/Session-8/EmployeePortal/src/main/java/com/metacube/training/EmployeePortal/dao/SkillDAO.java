package com.metacube.training.EmployeePortal.dao;

import java.util.List;
import com.metacube.training.EmployeePortal.model.Skill;

public interface SkillDAO {

	Skill getSkillById(Integer id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Skill Skill);

	boolean updateSkill(Skill Skill);

	boolean createSkill(Skill Skill);
}