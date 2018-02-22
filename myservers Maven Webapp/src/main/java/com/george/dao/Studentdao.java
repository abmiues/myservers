package com.george.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;

public interface Studentdao {

	public void stu_registerdao(Student stu);//注册

	//public String stu_isExist(String stuid);//查找用户是否存在
	
	public String stu_login(String stuid);//登陆
	
	public ArrayList<Classes> stu_getclasses(String stuid);//学生获取添加的课
	
	public void stu_selectsite(Site site);
	
	public String stu_getname(String stuid);
	
	public int stu_answer(Answers answers);
	
	public ArrayList<Questions> stu_getquestions(HashMap<String ,Object> map);
	
	public Answers stu_getanswers(HashMap<String,Object> map); 
	
	public int addcourse(HashMap<String, Object>map);
}
