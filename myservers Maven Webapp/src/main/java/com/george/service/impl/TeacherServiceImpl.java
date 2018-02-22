package com.george.service.impl;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Course;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;
import com.george.pojo.Teacher;
import com.george.service.TeacherService;
import com.george.dao.Studentdao;
import com.george.dao.Teacherdao;



@Service("TeacherService")  
public class TeacherServiceImpl implements TeacherService {  
	@Resource
	private Teacherdao teacherdao;
	
	@Override
	public String teacher_register (Teacher teacher)
	{
		String isexit;
		isexit=teacherdao.teacher_login(teacher.getTeacherid());
		if(isexit!=null&&isexit!="")
			return "100";
		else
		{
			teacherdao.teacher_login(teacher.getTeacherid());
			teacherdao.teacher_registerdao(teacher);
			if(teacher.getPwd().equals(teacherdao.teacher_login(teacher.getTeacherid())))
				return "111";
			else return "000";
		}
	}
	@Override
	public String teacher_login(String teacherid,String pwd)
	{

		String resultpwd=teacherdao.teacher_login(teacherid);
		if(resultpwd==null||resultpwd=="")
		{
			return "100";//账号不存在
		}
		else 
		{

			if(resultpwd.equals(pwd))
			{
				return "111";//登陆成功
			}
			else
			{

				return "000";//账号或密码错误
			}

		}
	}
	@Override
	public ArrayList<Course> teacher_getcourse(String teacherid) {
		return teacherdao.teacher_getcourse(teacherid);
	}
	@Override
	public ArrayList<Classes> teacher_getclasses(String teacherid) {
		return teacherdao.teacher_getclasses(teacherid);
	}
	@Override
	public int addcourse(Course course) {
		teacherdao.addcourse(course);
		return course.getCourseid();
	}
	@Override
	public int addclasses(Classes classes) {
		teacherdao.addclass(classes);
		return classes.getClassesid();
	}
	@Override
	public ArrayList<Site> getsitemap(int classesid) {
		return teacherdao.getsitemap(classesid);
	}
	@Override
	public String addquestion(Questions questions) {
		if(teacherdao.addquestion(questions)!=0)
			return "111";
		else return "000";
	}
	@Override
	public ArrayList<Answers> getanswers(int questionid) {
		return teacherdao.getanswers(questionid);
	}
}