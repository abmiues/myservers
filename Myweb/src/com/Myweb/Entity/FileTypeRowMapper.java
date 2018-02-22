package com.Myweb.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileTypeRowMapper implements RowMapper<FileType> {

	public FileType mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		FileType dt=new FileType();
		dt.setId(rs.getInt("id"));
		dt.setName(rs.getString("type_name"));
		dt.setIsvalid(rs.getBoolean("type_isvalid"));
		dt.setComment(rs.getString("type_comment"));
		dt.setTypeimage(rs.getString("type_image"));
		return dt;
	}

}
