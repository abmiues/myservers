package com.Myweb.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/***
 * 数据库表 跟 实体类 之间的映射
 * 
 * @author Administrator
 * 
 */
public class FileRowMapper implements RowMapper<UpFile> {

	public UpFile mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		UpFile file = new UpFile();
		file.setId(rs.getInt("id"));
		file.setFileid(rs.getString("file_id"));
		file.setUserid(rs.getString("user_id"));
		file.setFilename(rs.getString("file_name"));
		file.setFiletime(rs.getString("file_time"));
		file.setFilesize(rs.getString("file_size"));
		file.setFilepath(rs.getString("file_path"));
		file.setFiletypeid(rs.getInt("file_typeid"));

		return file;
	}

}
