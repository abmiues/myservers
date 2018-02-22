package com.Myweb.Entity;

public class UpFile {
	private int id;
	private String fileid;//
	private String userid;
	private String filename;// 文件真实的名字
	private String filetime;
	private String filesize;
	private String filepath;
	private int filetypeid;

	public int getFiletypeid() {
		return filetypeid;
	}

	public void setFiletypeid(int filetypeid) {
		this.filetypeid = filetypeid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletime() {
		return filetime;
	}

	public void setFiletime(String filetime) {
		this.filetime = filetime;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
