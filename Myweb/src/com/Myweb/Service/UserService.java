package com.Myweb.Service;

import javax.ejb.DuplicateKeyException;

import com.Myweb.Entity.User;
import com.Myweb.Entity.UserRowMapper;

public class UserService extends BaseService {
	/***
	 * 用户登录时进行数据库检验
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) {

		String sql = "select count(*) from t_user where user_id=? and  user_password=?";
		int r = this.jdbcTemplate.queryForInt(sql, username, password);
		if (r > 0)
			return true;
		else
			return false;

	}

	/***
	 * 验证用户名是否正确
	 * 
	 * @param name
	 * @return
	 */
	public boolean UsernameCheck(String name) {
		String sql = "select count(*) from t_user where user_id=?";
		int r = this.jdbcTemplate.queryForInt(sql, name);
		if (r > 0)
			return true;
		else
			return false;

	}

	/***
	 * 根据id来查找用户
	 * 
	 * @param id
	 * @return
	 */

	public User getUserByuserId(String id) {

		String sql = "select * from t_user where user_id=?";

		return this.jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
	}

	/***
	 * 添加用户
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @param images
	 */
	public void addUser(String id, String username, String password,
			String email, String phone, String images) {
		String sql = "insert into t_user(user_id,user_name,user_password,user_email,user_phone,user_image)values(?,?,?,?,?,?)";
		this.jdbcTemplate.update(sql, id, username, password, email, phone,
				images);

	}

	/***
	 * 根据用户的id来修改用户的密码
	 * 
	 * @param id
	 * @param password
	 */
	public void UpdatePass(String id, String password) {
		String sql = "update t_user set user_password=? where user_id=?";
		this.jdbcTemplate.update(sql, password, id);

	}
}
