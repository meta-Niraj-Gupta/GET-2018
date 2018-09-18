package com.metacube.training.EmployeePortalWithSpringDataJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.EmployeePortalWithSpringDataJPA.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	Skill findBySkillName(String skillName);

	@Query("select s from Skill s where s.skillId NOT IN(select skillCode from EmployeeSkills where empCode= :empCode)")
	List<Skill> findEmployeeSkill(@Param("empCode") Integer empCode);

}
