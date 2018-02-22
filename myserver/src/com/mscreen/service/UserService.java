package com.mscreen.service;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscreen.bean.User;
import com.mscreen.bean.Equipment;
import com.mscreen.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;


	public String register(User user)//注册
	{
		String isexit;
		isexit=userdao.user_isExist(user.getuserId());//判断是否存在
		if(isexit!=null&&isexit!="")
			return "100";//账户已存在
		else
		{
			if(userdao.registerdao(user).equals("000"))
				return "111";//写入数据成功
			else return "000";//写入失败
		}
	}
	public String user_changestate(String usable, String hashcode)//修改状态
	{

			String isexit=userdao.isExist_hashcode(hashcode);
			if(isexit==null||isexit=="")
				return "000";//用户不存在
			else if(isexit.equals("111"))
				return "101";
			else
			{
				HashMap<String, String> map=new HashMap<String, String>();
				map.put("usable", usable);
				map.put("hashcode", hashcode);
				userdao.user_changestate(map);
				if(userdao.isExist_hashcode(hashcode).equals(usable))
					return "111";//修改成功
				else return "000";//修改失败
			}
		
	}
	
	public String login(String userid,String pwd)
	{

		String usable,q_pwd;
		usable=userdao.user_isExist(userid);//获取可用状态
		if(usable==null||usable.equals(""))
		{
			return "100";//用户不存在
		}
		else if(usable.equals("000"))
		{
			return "011";//用户未激活
		}
		else if(usable.equals("111"))
		{
			q_pwd=userdao.login(userid);
			if(q_pwd.equals(pwd))
			{
				return "111";//登陆成功
			}
			else 
			{
				return "000";//账户密码错误	
			}
		}
		else 
		{
			return "101";//账户被禁用
		}

	}

	public String bdequipment(String userid,String equipmentid,String pwd,String equipmentname)
	{//TODO
		return userdao.bdequipment(userid, equipmentid, pwd, equipmentname);
	}
	public ArrayList<Equipment>  getequipment(String userid)
	{
		return userdao.getEquipment(userid);
	}
	public void updataip(String equipmentid,String ip)
	{
		userdao.updataip(equipmentid, ip);
	}
	public String addequipment(String equipmentid,String pwd,String ip)
	{return userdao.addequipment(equipmentid, pwd, ip);}
}
