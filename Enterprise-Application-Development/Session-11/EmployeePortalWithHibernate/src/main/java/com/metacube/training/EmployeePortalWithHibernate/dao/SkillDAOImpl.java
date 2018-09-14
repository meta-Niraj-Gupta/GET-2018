package com.metacube.training.EmployeePortalWithHibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalWithHibernate.model.EmployeeSkills;
import com.metacube.training.EmployeePortalWithHibernate.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Skill getSkillById(Integer skillId) {
		Skill skill = (Skill) sessionFactory.getCurrentSession()
				.createCriteria(Skill.class)
				.add(Restrictions.eq("skillId", skillId)).uniqueResult();
		return skill;
	}

	@Override
	public Skill getSkillByName(String skillName) {
		Skill skill = (Skill) sessionFactory.getCurrentSession()
				.createCriteria(Skill.class)
				.add(Restrictions.eq("skillName", skillName)).uniqueResult();
		return skill;
	}

	@Override
	public List<Skill> getSkillByNameForEmployee(Integer empCode) {
		List<EmployeeSkills> skillCodes = sessionFactory.getCurrentSession()
				.createCriteria(EmployeeSkills.class)
				.add(Restrictions.eq("empCode", empCode)).list();
		List<Skill> skillName = new ArrayList<Skill>();
		for (EmployeeSkills employeeSkillCode : skillCodes) {
			Skill skill = (Skill) sessionFactory
					.getCurrentSession()
					.createCriteria(Skill.class)
					.add(Restrictions.ne("skillId",
							employeeSkillCode.getSkillCode()));
			skillName.add(skill);
		}
		return skillName;
	}

	@Override
	public List<Skill> getAllSkills() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Skill.class);
		return criteria.list();
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		Skill skillToDelete = (Skill) sessionFactory.getCurrentSession()
				.createCriteria(Skill.class)
				.add(Restrictions.eq("skillId", skill.getSkillId()))
				.uniqueResult();
		sessionFactory.getCurrentSession().delete(skillToDelete);
		return true;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		Skill skillToUpdate = (Skill) sessionFactory.getCurrentSession()
				.createCriteria(Skill.class)
				.add(Restrictions.eq("skillId", skill.getSkillId()))
				.uniqueResult();
		skillToUpdate.setSkillName(skill.getSkillName());
		sessionFactory.getCurrentSession().update(skillToUpdate);
		return true;
	}

	@Override
	public boolean createSkill(Skill skill) {
		sessionFactory.getCurrentSession().save(skill);
		return true;
	}

}