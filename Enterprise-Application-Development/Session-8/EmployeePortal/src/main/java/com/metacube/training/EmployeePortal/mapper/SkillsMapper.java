package com.metacube.training.EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortal.model.Skill;


public class SkillsMapper implements RowMapper<Skill> {

	@Override
	public Skill mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Skill skills = new Skill();
		skills.setSkillId(resultSet.getInt("skillId"));
		skills.setSkillName(resultSet.getString("skillName"));
		return skills;
	}

}