package com.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TutorialRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User users = new User();

		users.setId(rs.getInt("id"));
		users.setName(rs.getString("name"));
		users.setEmail(rs.getString("email"));
		return users;
	}
}
