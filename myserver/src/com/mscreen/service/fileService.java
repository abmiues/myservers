package com.mscreen.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscreen.bean.MyFile;
import com.mscreen.dao.FileDao;
import com.sun.corba.se.spi.activation.Server;

import sun.print.resources.serviceui;
@Service
public class fileService {
	@Autowired
	private FileDao filedao;
	public String deletfile(String userid,String MD5)
	{
		return "";
	}
	public String sendfile(String userid,String MD5,String equipmentid)
	{
		return "";
	}
	public ArrayList<String> getfiletype(String userid)
	{
		ArrayList<String> list= filedao.gettypelist(userid);
		System.out.println("类型查找完成");
		return list;
	}
	public ArrayList<MyFile> getfilelist(String userid)
	{
		ArrayList<MyFile> list=filedao.getfilelist(userid);
		System.out.println("文件查找完成");
		return list;
	}
	public String uploadfile(MyFile file)
	{
		filedao.uploadfile(file);
		HashMap<String,String> map=new HashMap<String,String>(); 
		map.put("userid", file.getUserid());
		map.put("filename",file.getFilename());
		map.put("uploadtime", file.getUploadtime());
		String isexist= filedao.downloadfile(map);
		if(isexist!=null&&isexist!="")
		{
			return "111";
		}
		else return "000";
		
	}
	public String downloadfile(String userid,String filename,String uploadtime)
	{
		HashMap<String,String> map=new HashMap<String,String>(); 
		map.put("userid", userid);
		map.put("filename",filename);
		map.put("uploadtime", uploadtime);
		return filedao.downloadfile(map);
	}
	public String fileisexist(String MD5)
	{
		ArrayList<String> md5list=filedao.fileisexist(MD5);
		if(md5list!=null&&md5list.size()!=0)
		{
			return "111";
		}
		else 
			return "000";
	}
}
