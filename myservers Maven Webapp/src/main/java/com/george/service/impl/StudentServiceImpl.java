package com.george.service.impl;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  

import com.george.pojo.Answers;
import com.george.pojo.Classes;
import com.george.pojo.Questions;
import com.george.pojo.Site;
import com.george.pojo.Student;
import com.george.pojo.Teacher;
import com.george.service.StudentService;
import com.george.dao.Studentdao;



@Service("StudentService")  
public class StudentServiceImpl implements StudentService {  
	@Resource
	private Studentdao studentdao;
	@Override
	public String stu_register (Student stu)
	{
		String isexit;
		isexit=studentdao.stu_login(stu.getStuid());
		if(isexit!=null&&isexit!="")
			return "100";
		else
		{
			studentdao.stu_registerdao(stu);
			if(stu.getPwd().equals(studentdao.stu_login(stu.getStuid())))
				return "111";
			else return "000";
		}
	}
	@Override
	public String stu_login(String stuid,String pwd)
	{
		String resultpwd=studentdao.stu_login(stuid);
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
	public ArrayList<Classes> stu_getclasses(String stuid) {
		System.out.println("server"+stuid);
		return studentdao.stu_getclasses(stuid);

	}
	@Override
	public int stu_selectsite(Site site) {
		studentdao.stu_selectsite(site);
		return 0;
	}
	@Override
	public String stu_getname(String stuid) {
		return studentdao.stu_getname(stuid);
	}
	@Override
	public String stu_answer(Answers answers) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("questionid", answers.getQuestionid());
		map.put("stuid", answers.getStuid());
		if(studentdao.stu_getanswers(map)!=null)
			return "100";
		else
		{
			if(studentdao.stu_answer(answers)!=0)
				return "111";
			else
				return "000";
		}

	}
	@Override
	public ArrayList<Questions> stu_getquestions(int classesid, String week) {

		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("classesid", classesid);
		map.put("week", week);
		return studentdao.stu_getquestions(map);
	}
	@Override
	public String addcourse(String stuid, int courseid) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id",-1);
		map.put("stuid", stuid);
		map.put("courseid", courseid);
		studentdao.addcourse(map);
		System.out.println(map.get("id").toString());
		if(Integer.valueOf(map.get("id").toString())!=-1)
		{
			return "111";
		}
		else return "000";
	}

}