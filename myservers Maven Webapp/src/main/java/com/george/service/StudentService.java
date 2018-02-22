package com.george.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;
import com.george.pojo.Teacher;

public interface StudentService {  
	public String stu_register (Student stu);

	public String stu_login(String stuid,String pwd);
	
	public ArrayList<Classes> stu_getclasses(String stuid);
	
	public int stu_selectsite(Site site);
	
	public String stu_getname(String stuid);
	
	public String stu_answer(Answers answers);
	
	public ArrayList<Questions> stu_getquestions(int classesid,String week);
	
	public String addcourse(String stuid,int courseid);
	}
