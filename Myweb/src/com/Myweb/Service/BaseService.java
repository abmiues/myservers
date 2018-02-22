package com.Myweb.Service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class BaseService {
	protected JdbcTemplate jdbcTemplate;
	public BaseService() {
		 MysqlDataSource dataSource = new MysqlDataSource();

		  dataSource.setUrl("jdbc:mysql://139.129.119.93:3306/db_11");
		  dataSource.setUser("sa");
		  dataSource.setPassword("123321");
		  
		  this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
