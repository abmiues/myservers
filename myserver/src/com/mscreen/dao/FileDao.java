package com.mscreen.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mscreen.bean.MyFile;


@Service
public class FileDao extends BaseDao{

	public ArrayList<String> gettypelist(String  userid)
	{
		//ArrayList<Map<String,String>> mapList= (ArrayList<Map<String, String>>) this.getSqlMapClientTemplate().queryForList("file.gettypelist");
		return (ArrayList<String>) this.getSqlMapClientTemplate().queryForList("file.gettypelist",userid);
	  //return null;
	} 

	public ArrayList<MyFile> getfilelist(String  userid)
	{
		//ArrayList<Map<String,String>> mapList= (ArrayList<Map<String, String>>) this.getSqlMapClientTemplate().queryForList("file.gettypelist");
		return (ArrayList<MyFile>) this.getSqlMapClientTemplate().queryForList("file.getfilelist",userid);
	  //return null;
	} 
	
	public void uploadfile(MyFile file)
	{
		System.out.println("插入文件信息至数据库");
		//ArrayList<Map<String,String>> mapList= (ArrayList<Map<String, String>>) this.getSqlMapClientTemplate().queryForList("file.gettypelist");
		this.getSqlMapClientTemplate().insert("file.uploadfile",file);
		
	  //return null;
	} 
	public String downloadfile(HashMap< String, String> map)
	{
		return (String) this.getSqlMapClientTemplate().queryForObject("file.downloadfile",map);
	}
	
	public ArrayList<String> fileisexist(String MD5)
	{
		System.out.println("查找MD5");
		return (ArrayList<String>) this.getSqlMapClientTemplate().queryForList("file.fileisexist",MD5);
	}
}
