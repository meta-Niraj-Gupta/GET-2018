package com.metacube.training.EmployeePortalWithSpringDataJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Skill;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.EmployeeSkillsRepository;
import com.metacube.training.EmployeePortalWithSpringDataJPA.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private EmployeeSkillsRepository employeeSkillsRepository;

	public Skill getSkillById(Integer skillId) {
		return skillRepository.findById(skillId).get();
	}

	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	public boolean deleteSkill(Integer id) {
		skillRepository.deleteById(id);
		return true;
	}

	public boolean updateSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

	public Skill getSkillByName(String skillName) {
		return skillRepository.findBySkillName(skillName);
	}

	public List<Skill> getSkillByNameForEmployee(Integer empCode) {
		return skillRepository.findEmployeeSkill(empCode);
	}
}
