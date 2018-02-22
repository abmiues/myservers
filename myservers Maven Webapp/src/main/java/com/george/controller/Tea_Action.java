package com.george.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Course;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;
import com.george.pojo.Teacher;
import com.george.service.StudentService;
import com.george.service.TeacherService;


import org.springframework.stereotype.Controller;

@Controller  
@RequestMapping("tea") 
public class Tea_Action {
	@Resource  
	private TeacherService teacherService;
	@Resource
	private StudentService studentService;

	//[start]注册
	@RequestMapping(value="/register",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String register(
			@RequestParam(value="userid",required=true,defaultValue="")String userid,
			@RequestParam(value="schoolid",required=false,defaultValue="")String schoolid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,
			@RequestParam(value="email",required=false,defaultValue="")String email,
			@RequestParam(value="name",required=false,defaultValue="")String name
			)
	{

			Teacher teacher=new Teacher();
			teacher.setTeachername(name);
			teacher.setTeacherid(userid);
			teacher.setPwd(pwd);
			teacher.setSchoolid(schoolid);
			teacher.setEmail(email);
			return teacherService.teacher_register(teacher);


	}
	//[end]	
	//[start]登陆
	@RequestMapping(value="/login",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String login(
			@RequestParam(value="userid",required=true,defaultValue="")String userid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,HttpServletRequest request)
	{

			request.getSession().setAttribute("teacherid",userid);

			request.getSession().setAttribute("pwd", pwd);
			System.out.println("登陆:"+userid);
			return teacherService.teacher_login(userid,pwd);
		
		

	}
	//[end]
	//[start]自动登陆]
	@RequestMapping(value="/autologin",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String autologin(HttpServletRequest request)
	{
		
			return teacherService.teacher_login((String)request.getSession().getAttribute("teacherid"),(String)request.getSession().getAttribute("pwd"));
		
	
	}
	//[end]
	//[start]
	@RequestMapping(value="/addcourse",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String addcourse(@RequestParam(value="coursename")String coursename,
			@RequestParam(value="teacherid")String teacherid,
			HttpServletRequest request)
	{

		Course course=new Course();
		course.setCoursename(coursename);
		course.setTeacherid(teacherid);
		return String.valueOf(teacherService.addcourse(course));
	}
	//[end]

	//[start]
	@RequestMapping(value="/addquestion",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String addquestion(@RequestParam(value="classesid")Integer classesid,
			@RequestParam(value="title")String title,
			@RequestParam(value="week")String week,
			@RequestParam(value="content")String content,
			HttpServletRequest request)
			{
		Questions questions=new Questions();
		questions.setContent(content);
		questions.setClassesid(classesid);
		questions.setTitle(title);
		questions.setWeek(week);
		return teacherService.addquestion(questions);
			}
	//[end]
	
	//[start]
	@RequestMapping(value="/getquestions",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	ArrayList<Questions> getquestions(@RequestParam(value="classesid")Integer classesid,
			@RequestParam(value="week")String week,
			HttpServletRequest request)
			{
		return studentService.stu_getquestions(classesid, week);
			}
	//[end]

	
	//[start]
	@RequestMapping(value="/getanswers",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	ArrayList<Answers> getanswers(@RequestParam(value="questionid")Integer questionid,
			HttpServletRequest request)
			{
		return teacherService.getanswers(questionid);
			}
	//[end]
	

}
