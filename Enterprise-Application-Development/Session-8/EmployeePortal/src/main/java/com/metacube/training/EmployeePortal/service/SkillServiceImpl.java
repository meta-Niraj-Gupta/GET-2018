package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.SkillDAO;
import com.metacube.training.EmployeePortal.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDao;

	public Skill getSkillById(Integer skillId) {
		return skillDao.getSkillById(skillId);
	}

	public List<Skill> getAllSkills() {
		return skillDao.getAllSkills();
	}

	public boolean deleteSkill(Integer id) {
		Skill skill = skillDao.getSkillById(id);
		return skillDao.deleteSkill(skill);
	}

	public boolean updateSkill(Skill skill) {
		return skillDao.updateSkill(skill);
	}

	public boolean createSkill(Skill skill) {
		return skillDao.createSkill(skill);
	}
}
