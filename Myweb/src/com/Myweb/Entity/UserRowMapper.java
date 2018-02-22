package com.Myweb.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		User us = new User();
		us.setId(rs.getInt("id"));
		us.setUserid(rs.getString("user_id"));
		us.setUsername(rs.getString("user_name"));
		us.setUserpassword(rs.getString("user_password"));
		us.setUserphone(rs.getString("user_phone"));
		us.setUseremail(rs.getString("user_email"));
		us.setUserimages(rs.getString("user_image"));

		return us;
	}

}