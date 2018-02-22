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
@RequestMapping("stu") 
public class Stu_Action {
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
		
		
			Student stu=new Student();
			stu.setStuid(userid);
			stu.setStuname(name);
			stu.setPwd(pwd);
			stu.setSchoolid(schoolid);
			stu.setEmail(email);
			return studentService.stu_register(stu);
	

	}
	//[end]	
	//[start]登陆
	@RequestMapping(value="/login",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String login(
			@RequestParam(value="userid",required=true,defaultValue="")String userid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,HttpServletRequest request)
	{
	
		
		
			request.getSession().setAttribute("stuid",userid);
			request.getSession().setAttribute("stuname", studentService.stu_getname(userid));
			request.getSession().setAttribute("pwd", pwd);
			System.out.println("登陆:"+userid);
			return studentService.stu_login(userid,pwd);	
		

	}
	//[end]
	//[start]自动登陆]
	@RequestMapping(value="/autologin",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String autologin(
			HttpServletRequest request)
	{

			return studentService.stu_login((String)request.getSession().getAttribute("stuid"),(String)request.getSession().getAttribute("pwd"));
	}
	//[end]


	//[start]
	@RequestMapping(value="/stu_addcourse",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String stu_selectsite0(@RequestParam(value="courseid")Integer courseid,
			@RequestParam(value="stuid")String stuid)
	{
		
		return studentService.addcourse(stuid, courseid);
	}
	//[end]

	//[start]
	@RequestMapping(value="/stu_getclasses",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	ArrayList<Classes> stu_getclasses(@RequestParam(value="stuid")String stuid,
			HttpServletRequest request)
			{
		System.out.println("获取课程："+stuid);
		return studentService.stu_getclasses(stuid);
			}
	//[end]
	//[start]
	@RequestMapping(value="/stu_selectsite0",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	int stu_selectsite0(@RequestParam(value="classesid")Integer classesid,
			@RequestParam(value="layouot")String layout,
			@RequestParam(value="week")String week,
			HttpServletRequest request)
	{
		Site site=new Site();
		site.setClassesid(classesid);
		site.setStuid(request.getSession().getAttribute("stuid").toString());
		site.setStuname(request.getSession().getAttribute("stuname").toString());
		site.setLayout(layout);
		site.setWeek(week);
		return studentService.stu_selectsite(site);
	}
	//[end]

	@RequestMapping(value="/stu_selectsite",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	int stu_selectsite(
			@RequestParam(value="stuid")String stuid,
			@RequestParam(value="stuname")String stuname,
			@RequestParam(value="classesid")Integer classesid,
			@RequestParam(value="layout")String layout,
			@RequestParam(value="week")String week,
			HttpServletRequest request)
	{
		Site site=new Site();
		site.setClassesid(classesid);
		site.setStuid(stuid);
		site.setStuname(stuname);
		site.setLayout(layout);
		site.setWeek(week);
		//System.out.println(classesid);
		return studentService.stu_selectsite(site);
	}
	//[end]
	
	//[start]
	@RequestMapping(value="/getsitemap",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	ArrayList<Site> getsitemap(@RequestParam(value="classesid")Integer classesid,
			HttpServletRequest request)
			{
		return teacherService.getsitemap(classesid);
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
	@RequestMapping(value="/stu_answer",method=RequestMethod.GET,produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String stu_answer(@RequestParam(value="questionid")Integer questionid,
			@RequestParam(value="stuid")String stuid,
			@RequestParam(value="stuname")String stuname,
			@RequestParam(value="content")String content,
			HttpServletRequest request)
			{
		Answers answers=new Answers();
		answers.setContent(content);
		answers.setQuestionid(questionid);
		answers.setStuid(stuid);
		answers.setStuname(stuname);
		//System.out.println(questionid+" "+stuid);
		return studentService.stu_answer(answers);
			}
	//[end]
	

	

}
