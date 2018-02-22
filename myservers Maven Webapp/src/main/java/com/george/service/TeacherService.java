package com.george.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Course;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;
import com.george.pojo.Teacher;

public interface TeacherService {  

	public String teacher_register (Teacher teacher);

	public String teacher_login(String teacherid,String pwd);

	public ArrayList<Course> teacher_getcourse(String teacherid);

	public ArrayList<Classes> teacher_getclasses(String teacherid);

	public int addcourse(Course course);

	public int addclasses(Classes classes);

	public ArrayList<Site> getsitemap(int classesid);

	public String addquestion(Questions questions);

	public ArrayList<Answers> getanswers(int questionid);

	
}
