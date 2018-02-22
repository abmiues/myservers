package com.george.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Course;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;
import com.george.pojo.Teacher;


public interface Teacherdao {

	
	public void teacher_registerdao(Teacher teacher);//注册

	//public String teacher_isExist(String teacherid);//查找用户是否存在

	public String teacher_login(String teacherid);//登陆
	public int addcourse(Course course);//教师添加课程
	public int addclass(Classes classes);//教师添加单节课
	public ArrayList<Course> teacher_getcourse(String teacherid);//教师获取添加的课程
	public ArrayList<Classes> teacher_getclasses(String teacherid);//教师获取添加的课

	public ArrayList<Site> getsitemap(int classesid);
	
	public int addquestion (Questions questions);
	
	public ArrayList<Answers> getanswers(int questionid);
	
}
