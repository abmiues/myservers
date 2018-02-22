package com.Myweb.Entity;

/***
 * 文件的类型实体类
 * 
 * @author USER
 * 
 */
public class FileType {
	private int id;
	private String name;
	private String comment;
	private boolean isvalid;
	private String typeimage;
	public String getTypeimage() {
		return typeimage;
	}
	public void setTypeimage(String typeimage) {
		this.typeimage = typeimage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isIsvalid() {
		return isvalid;
	}
	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}
}
