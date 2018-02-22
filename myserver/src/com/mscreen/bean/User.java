package com.mscreen.bean;

public class User {
	private String userid;
	private String pwd;
	private String name;
	private String email;
	private String pathsize;
	private String money;
	private String level;
	private String img;
	private String hashcode;
	
	public String getHashcode() {
		return hashcode;
	}
	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPathsize() {
		return pathsize;
	}
	public void setPathsize(String pathsize) {
		this.pathsize = pathsize;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public String getuserId() {
		return userid;
	}
	public void setuserId(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}