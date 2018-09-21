package com.metacube.training.EmployeePortalWithSecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalWithSecurity.model.Skill;

public class SkillsMapper implements RowMapper<Skill> {

	public Skill mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Skill skills = new Skill();
		skills.setSkillId(resultSet.getInt("skillId"));
		skills.setSkillName(resultSet.getString("skillName"));
		return skills;
	}

}