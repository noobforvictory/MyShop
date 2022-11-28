package com.lcwd.store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lcwd.store.entities.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setAbout(rs.getString("about"));
		user.setEmail(rs.getString("email"));
		user.setGender(rs.getString("gender"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
