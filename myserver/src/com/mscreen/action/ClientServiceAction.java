package com.mscreen.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Encoder;

import com.mscreen.bean.Equipment;
import com.mscreen.bean.MyFile;
import com.mscreen.bean.User;
import com.mscreen.dao.GetMD5;
import com.mscreen.email.Mail;
import com.mscreen.email.MailSenderInfo;
import com.mscreen.email.MailUtil;
import com.mscreen.email.SimpleMailSender;
import com.mscreen.service.UserService;
import com.mscreen.service.fileService;

@Controller
public class ClientServiceAction {

	@Autowired
	UserService userService;
	@Autowired
	fileService fileService;

	/** 日志实例 */
	private static final Logger logger = Logger.getLogger(ClientServiceAction.class);
	

	private FileItem getUploadFileItem(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if(!fileItem.isFormField()) {
				return fileItem;
			}
		}
		return null;
	}

	private String getUploadFileName(FileItem item) {
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);

		return filename;
	}

	//[start]例子
	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String hello() {
		return "你好！hello";
	}

	@RequestMapping(value = "/say",method=RequestMethod.GET)
	public @ResponseBody
	String say(@RequestParam(value = "filetype",required=true,defaultValue="") String msg) {
		System.out.println("xiaox"+msg);		return "[{\"msg\":\"you say:'" + msg + "'\"}]";
	}


	//[end]

	//[start]
	@RequestMapping(value="/register0",method=RequestMethod.POST)
	public @ResponseBody
	String register0(@RequestParam(value="email",required=true,defaultValue="")String email)
	{
		String checkcode="";
		Random r=new Random();
		for(int i=0;i<6;i++){
			checkcode+=String.valueOf(r.nextInt(10));    
		}
		System.out.println(email);
		System.out.println(checkcode);
		/*     //这个类主要是设置邮件   
		 SimpleEmail semail = new SimpleEmail();  
		 try{
	        semail.setHostName("smtp.qq.com");//邮件服务器    
	        //smtp认证的用户名和密码    
	        semail.setAuthentication("1632341887@qq.com", "henhao123,./");  
	        semail.addTo(email, "receiver");//收信者    
	        semail.setFrom("1632341887@qq.com", "Rowen");//发信者     
	        semail.setSubject("集中开票系统验证码");//标题    
	        semail.setCharset("UTF-8");//编码格式    
	        semail.setMsg("啦啦啦"+checkcode);//内容    //
	        semail.send(); 
	        }catch(Exception e)
	        {}*/

		/* Mail mail = new Mail();  
	        mail.setHost("smtp.sina.cn"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
	        mail.setSender("18758115248@sina.cn");  
	        mail.setReceiver(email); // 接收人  
	        mail.setUsername("18758115248@sina.cn"); // 登录账号,一般都是和邮箱名一样吧  
	        mail.setPassword("804640623"); // 发件人邮箱的登录密码  
	        mail.setSubject("aaaaaaaaa");  
	        mail.setMessage(checkcode);  
	        new MailUtil().send(mail); 
	        System.out.println("发送结束");*/

		/* MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost("smtp.sina.cn");    
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("18758115248@sina.cn");    
	      mailInfo.setPassword("804640623");//您的邮箱密码    
	      mailInfo.setFromAddress("18758115248@sina.cn");    
	      mailInfo.setToAddress(email);    
	      mailInfo.setSubject("集中开票系统验证码");    
	      mailInfo.setContent("啦啦啦"+checkcode);    
	         //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	          sms.sendTextMail(mailInfo);//发送文体格式    
		 */	         // sms.sendHtmlMail(mailInfo);//发送html格式    
		return checkcode;
	}
	//[end]



	//[start]注册
	@RequestMapping(value="/register",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public @ResponseBody
	String register(@RequestParam(value="userid",required=true,defaultValue="")String userid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,
			@RequestParam(value="email",required=false,defaultValue="")String email,
			@RequestParam(value="name",required=false,defaultValue="")String name,
			HttpServletRequest request)
	{
		
			System.out.println("名字:"+name);

		String checkcode="";
		Random r=new Random();
		for(int i=0;i<6;i++){
			checkcode+=String.valueOf(r.nextInt(10));    
		}
		User user=new User();
		user.setuserId(userid);
		user.setName(name);
		user.setEmail(email);
		user.setPwd(pwd);
		
		MessageDigest md5;
		try {
		md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
	    String hashcode=base64en.encode(md5.digest((userid+checkcode).getBytes("utf-8")));
	    user.setHashcode(hashcode);
	    System.out.println("加密后字段："+hashcode);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   String result=userService.register(user);
	   if(result.equals("111"))
	   {    
		   Mail mail = new Mail();  
	        mail.setHost("smtp.abmiues.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
	        mail.setSender("myteam@abmiues.com");  
	        mail.setReceiver(email); // 接收人  
	        mail.setUsername("myteam@abmiues.com"); // 登录账号,一般都是和邮箱名一样吧  
	        mail.setPassword("GeorgeXu120"); // 发件人邮箱的登录密码  
	        mail.setSubject("感谢注册MobileScreen");  
	        mail.setMessage("点击或复制一下链接激活账号："+
	        		"http://www.abmiues.com/act_user.jsp?hashcode="+user.getHashcode().replace("+", "%2B")+"&&usable=111");  
	        new MailUtil().send(mail); 
	        System.out.println("发送结束");
		 
		System.out.println("注册信息:"+user.getName()+" "+email+"checkcode:"+checkcode+" "+user.getHashcode().replace("+", "%2B"));
	   }
		return result; 

	}
	//[end]	

	//[start]注册
	@RequestMapping(value="/user_changestate",method=RequestMethod.POST)
	public @ResponseBody
	String user_changestate(@RequestParam(value="hashcode",required=true,defaultValue="")String hashcode,
			@RequestParam(value="usable",required=true,defaultValue="")String usable,
			HttpServletRequest request)
	{
		System.out.println("激活："+hashcode+" "+usable);
		return userService.user_changestate(usable, hashcode);

	}
	//[end]	

	//[start]登陆
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody
	String login(@RequestParam(value="userid",required=true,defaultValue="")String userid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,HttpServletRequest request)
	{
		request.getSession().setAttribute("userid",userid);
		request.getSession().setAttribute("pwd", pwd);
		System.out.println("登陆:"+userid);
		return userService.login(userid,pwd);

	}
	//[end
	//[start]自动登陆]
	@RequestMapping(value="/autologin",method=RequestMethod.POST)
	public @ResponseBody
	String autologin(HttpServletRequest request)
	{
		System.out.println("自动登陆:"+(String)request.getSession().getAttribute("userid"));
		return userService.login((String)request.getSession().getAttribute("userid"),(String)request.getSession().getAttribute("pwd"));
	}
	//[end]
	@RequestMapping(value="bdequipment",method=RequestMethod.POST)
	public @ResponseBody
	String bdequipment(
			@RequestParam(value="equipmentid",required=true,defaultValue="")String equipmentid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,
			@RequestParam(value="equipmentname",required=true,defaultValue="")String equipmentname,
			HttpServletRequest request)
	{
		System.out.println("添加设备"+equipmentid+" "+pwd+" "+equipmentname);
		return	userService.bdequipment((String)request.getSession().getAttribute("userid"),equipmentid,pwd,equipmentname);
	}


	@RequestMapping(value="/getequipment",method=RequestMethod.POST)
	public @ResponseBody
	ArrayList<Equipment>   getequipment(@RequestParam(value="userid",required=true,defaultValue="")String userid,HttpServletRequest request){
		System.out.println("获取设备");
		//return userService.getequipment((String)request.getSession().getAttribute("userid"));
		return userService.getequipment(userid);
	}

	@RequestMapping(value="/addequipment",method=RequestMethod.POST)
	public @ResponseBody
	String addequipment(
			@RequestParam(value="equipmentid",required=true,defaultValue="")String equipmentid,
			@RequestParam(value="pwd",required=true,defaultValue="")String pwd,
			@RequestParam(value="ip",required=true,defaultValue="")String ip,
			HttpServletRequest request){
		System.out.println(equipmentid+pwd+ip);
		return userService.addequipment(equipmentid, pwd, ip);
	}

	@RequestMapping(value="/updataip",method=RequestMethod.GET)
	public @ResponseBody
	void updataip(
			@RequestParam(value="equipmentid",required=true,defaultValue="")String equipmentid,
			@RequestParam(value="ip",required=true,defaultValue="")String ip,
			HttpServletRequest request){
		System.out.println(equipmentid+ip);
		userService.updataip(equipmentid, ip);
	}

	@RequestMapping(value="/getfiletype",method=RequestMethod.GET)
	public @ResponseBody
	ArrayList<String> getfiletype(@RequestParam(value="userid",required=true,defaultValue="")String userid,
			HttpServletRequest request){
		System.out.println("查找类型"+userid);
		return  fileService.getfiletype(userid);
		// return null;
		//return  fileService.getfiletype(request.getAttribute("userid").toString());
	}

	@RequestMapping(value="/getfilelist",method=RequestMethod.POST)
	public @ResponseBody
	ArrayList<MyFile> getfilelist(@RequestParam(value="userid",required=true,defaultValue="")String userid,
			HttpServletRequest request){
		System.out.println("查找文件"+userid);
		return  fileService.getfilelist(userid);
		// return null;
		//return  fileService.getfiletype(request.getAttribute("userid").toString());
	}

	@RequestMapping(value="/fileisexist",method=RequestMethod.POST)
	public @ResponseBody
	String  fileisexist(@RequestParam(value="MD5",required=true,defaultValue="")String MD5){
		return	fileService.fileisexist(MD5);
	}

	@RequestMapping(value="/upload_PC",method=RequestMethod.POST,produces = "multipart/form-data")
	public @ResponseBody
	String  uploadFile_PC(HttpServletRequest request){
		MyFile myFile = new MyFile();
		String webroot=request.getSession().getServletContext().getRealPath("/");
		String userid=request.getHeader("userid");
		String filename=request.getHeader("filename");
		String MD5=request.getHeader("MD5");
		String filesize=request.getHeader("filesize");	
		String filetype="";
		if(filename.lastIndexOf(".")==-1)
			filetype="未知类型";
		else 
			filetype=filename.substring(filename.lastIndexOf(".")+1);
		String uploadtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		System.out.println(request.getHeader("MD5"));
		System.out.println("文件储存位置："+webroot+"/uploadfile");

		try {

			FileOutputStream fileout=new FileOutputStream(new File(webroot+"/uploadfile/"+MD5));
			byte[]buff=new byte[1024];
			int length=0;
			//DataInputStream dataInputStream=new DataInputStream(request.getInputStream());
			InputStream dataInputStream=request.getInputStream();
			System.out.println(dataInputStream.read());
			while((length=dataInputStream.read(buff,0,buff.length))>0){
				fileout.write(buff, 0, length);
				fileout.flush();
			}
			System.out.println("接收完成");
			dataInputStream.close();
			fileout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myFile.setFilename(filename);
		myFile.setFilepath(webroot+"/uploadfile/"+MD5);
		myFile.setFilesize(filesize);
		myFile.setFiletype(filetype);
		myFile.setMD5(MD5);
		myFile.setUploadtime(uploadtime);
		myFile.setUseable("1");
		myFile.setUserid(userid);

		return  fileService.uploadfile(myFile);
	}

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public @ResponseBody
	String  uploadFile(HttpServletRequest request)
	{
		MyFile myFile = new MyFile();
		String userid= (String) request.getSession().getAttribute("userid");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 设置编码
		String webroot=request.getSession().getServletContext().getRealPath("/");

		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setRepository(new File(webroot+"/uploadfile_tmp"));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 提交上来的信息都在这个list里面
			// 这意味着可以上传多个文件
			// 请自行组织代码
			List<FileItem> list = upload.parseRequest(request);
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			// 获取文件名
			String filename = getUploadFileName(item);
			// 保存后的文件名
			String filetype="";
			if(filename.lastIndexOf(".")==-1)
				filetype="未知类型";
			else 
				filetype=filename.substring(filename.lastIndexOf(".")+1);
			String uploadtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			String saveName = new Date().getTime()+"."+filetype;
			// 保存后的浏览器访问路径
			String fileUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/uploadfile/"+saveName;

			System.out.println("存放目录:" + request.getContextPath()+"/uploadfile" );
			System.out.println("文件名:" + filename);
			System.out.println("浏览器访问路径:" + fileUrl);
			// 真正写到磁盘上
			item.write(new File(webroot+"/filesave_tmp", saveName)); // 第三方提供的

			//[start]获取文件大小
			String filesize="";
			NumberFormat format=NumberFormat.getNumberInstance();
			format.setMaximumFractionDigits(2);
			File oldFile=new File(webroot+"/filesave_tmp",saveName);
			long filesize_l=oldFile.length();
			if(filesize_l<(1024*1024))
				filesize=format.format(1.0*filesize_l/1024)+"kb";
			else if(filesize_l<(1024*1024*1024))
				filesize=format.format(1.0*(filesize_l/1024)/1024)+"Mb";
			else 
				filesize=format.format(1.0*(filesize_l/(1024*1024))/1024)+"Gb";
			//[end]

			String md5=GetMD5.getmd5(webroot+"/filesave_tmp/"+saveName);

			if(fileService.fileisexist(md5).equals("000"))
			{
				File newFile=new File(webroot+"/uploadfile",md5);
				oldFile.renameTo(newFile);
			}
			else oldFile.delete();

			myFile.setFilename(filename);
			myFile.setFilepath(webroot+"/uploadfile/"+md5);
			myFile.setFilesize(filesize);
			myFile.setFiletype(filetype);
			myFile.setMD5(md5);
			myFile.setUploadtime(uploadtime);
			myFile.setUseable("1");
			myFile.setUserid(userid);


		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  fileService.uploadfile(myFile);


		//System.out.println("文件上传来自:"+(String)request.getSession().getAttribute("id"));

		//return userService.login((String)request.getSession().getAttribute("id"),(String)request.getSession().getAttribute("pwd"));
	}

	@RequestMapping(value="/addfiletodb",method=RequestMethod.POST)
	public @ResponseBody
	String  addfiletodb(@RequestParam(value="MD5",required=true,defaultValue="")String MD5,
			@RequestParam(value="filename",required=true,defaultValue="")String filename,
			@RequestParam(value="filesize",required=true,defaultValue="")String filesize,
			@RequestParam(value="userid",required=true,defaultValue="")String userid,
			HttpServletRequest request){
		MyFile myFile = new MyFile();
		String webroot=request.getSession().getServletContext().getRealPath("/");
		String filetype="";
		if(filename.lastIndexOf(".")==-1)
			filetype="未知类型";
		else 
			filetype=filename.substring(filename.lastIndexOf(".")+1);
		String uploadtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		myFile.setFilename(filename);
		myFile.setFilepath(webroot+"/uploadfile/"+MD5);
		myFile.setFilesize(filesize);
		myFile.setFiletype(filetype);
		myFile.setMD5(MD5);
		myFile.setUploadtime(uploadtime);
		myFile.setUseable("1");
		myFile.setUserid(userid);
		return	fileService.fileisexist(MD5);
	}
	
	@RequestMapping(value="/getfilesize",method=RequestMethod.POST)
	public @ResponseBody
	long getfilesize(@RequestParam(value="MD5",required=true,defaultValue="")String MD5,
			HttpServletRequest request,HttpServletResponse response){
		String webroot=request.getSession().getServletContext().getRealPath("/");
		File file = new File(webroot+"/uploadfile",MD5);
		System.out.println("获取文件大小");
		return file.length();
	}

	@RequestMapping(value="/download",method=RequestMethod.GET)
	public 
	void download(@RequestParam(value="filename",required=true,defaultValue="")String filename,
			@RequestParam(value="uploadtime",required=true,defaultValue="")String uploadtime,
			HttpServletRequest request,HttpServletResponse response)
	{
		String userid=(String) request.getSession().getAttribute("userid");
		response.setCharacterEncoding("UTF-8");
		String webroot=request.getSession().getServletContext().getRealPath("/");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String md5=fileService.downloadfile(userid, filename, uploadtime);
		if(md5==null||md5=="")
			md5="";
		OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			//输出文件用的字节数组，每次向输出流发送600个字节  
			byte b[] = new byte[1024];  
			//要下载的文件  
			File fileload = new File(webroot+"/uploadfile",md5);       
			//客服端使用保存文件的对话框  
			response.setHeader("Content-disposition", "attachment;filename="+new String(filename.getBytes(),"ISO8859-1"));  
			// File fileload = new File("F:\\Program Files\\apache-tomcat-7.0.63\\webapps\\myserver\\uploadfile",fileService.downfile(userid, filename, uploadtime));       
			// response.setHeader("Content-disposition", "attachment;filename="+new String(filename.getBytes(),"ISO8859-1"));  

			//通知客服文件的MIME类型  
			response.setContentType("application/msword");  
			//通知客服文件的长度  
			long fileLength = fileload.length();  
			String length = String.valueOf(fileLength);  
			response.setHeader("Content_length", length);  
			//读取文件，并发送给客服端下载  
			FileInputStream inputStream;

			inputStream = new FileInputStream(fileload);
			int n = 0;  
			while((n=inputStream.read(b))!=-1){  
				outputStream.write(b,0,n);  
			}  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


	}

	@RequestMapping(value="/getinfo",method=RequestMethod.POST)
	public @ResponseBody
	String getinfo(@RequestParam(value="userid",required=true,defaultValue="")String userid,
			@RequestParam(value="funame",required=true,defaultValue="")String funame,
			@RequestParam(value="cmd",required=true,defaultValue="")String cmd,
			@RequestParam(value="opentime",required=true,defaultValue="")String opentime,
			@RequestParam(value="closetime",required=true,defaultValue="")String closetime,
			HttpServletRequest request,HttpServletResponse response){
		if(!opentime.equals("")||!closetime.equals(""))
		{
			System.out.println("收到来自用户:"+userid+" 的控制命令,家具名称:"+funame+"，开启时间："+opentime+",关闭时间："+closetime+",指令："+cmd);
		}
		else
		System.out.println("收到来自用户:"+userid+" 的控制命令,家具名称:"+funame+"，指令："+cmd);
		return "111";
	}
	
}
