package com.metacube.training.EmployeePortalWithHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithHibernate.dao.SkillDAO;
import com.metacube.training.EmployeePortalWithHibernate.model.Skill;

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

	public Skill getSkillByName(String skillName) {
		return skillDao.getSkillByName(skillName);
	}
	
	public List<Skill> getSkillByNameForEmployee(Integer empCode) {
		return skillDao.getSkillByNameForEmployee(empCode);
	}
}
