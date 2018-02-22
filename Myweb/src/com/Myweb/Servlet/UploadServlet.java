package com.Myweb.Servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.Myweb.Entity.*;
import com.Myweb.Service.FileService;



public class UploadServlet extends HttpServlet {

	 private static final long serialVersionUID = 1L;    
	
	    /**  
	     * ʵ�ֶ��ļ���ͬʱ�ϴ�  
	     */     
	    public void doGet(HttpServletRequest request,    
	            HttpServletResponse response) throws ServletException, IOException {    
	            
	        //���ý��յı����ʽ    
	        request.setCharacterEncoding("UTF-8");    
	       
	        Date date = new Date();//��ȡ��ǰʱ�� ��Ϊ�ļ���   
	        
	        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmss");    
  
	        String newfileName = sdfFileName.format(date);//�ļ����    
	        
	        String fileRealPath = "";//�ļ������ʵ��ַ    
	            
	        String fileRealResistPath = "";//�ļ������ʵ���·��    
	            
	        //���  ������� ���� ��request ����һ��..��������    
	        //String name = request.getParameter("name");    
	                
	             
	        String firstFileName="";    
	       
	        // ����������ϴ��ļ������ڵ�����·��    
	        String savePath = this.getServletConfig().getServletContext().getRealPath("/") + "myweb\\";    
	                                                                 
	        
	        System.out.println(savePath);    
	        
	        File file = new File(savePath);    
	        
	        if (!file.isDirectory()) {    
	            file.mkdirs();    
	        }    
	    
	        try {   
	        	
	            DiskFileItemFactory fac = new DiskFileItemFactory();    
	            ServletFileUpload upload = new ServletFileUpload(fac);    
	            upload.setHeaderEncoding("UTF-8");    
	            // ��ȡ����ϴ��ļ�    
	            List fileList = upload.parseRequest(request);    
	            // �����ϴ��ļ�д�����    
	            Iterator it = fileList.iterator();    
	            while (it.hasNext()) {    
	                Object obit = it.next();  
	                if(obit instanceof DiskFileItem){  
	                    System.out.println("xxxxxxxxxxxxx");  
	                    DiskFileItem item = (DiskFileItem) obit;    
	                        
	                    // ���item���ļ��ϴ��?��       
	                    // ����ļ���·��       
	                    String fileName = item.getName();   
	                 
	                    System.out.println(fileName); 
	                    if (fileName != null) {    
	                        firstFileName=item.getName().substring(item.getName().lastIndexOf("\\")+1);    
	                        String formatName = firstFileName.substring(firstFileName.lastIndexOf("."));//��ȡ�ļ���׺��    
	                        String savefname=getUUID(fileName);
	                      String savefilename=new String(savefname.getBytes(),"utf-8");
	                     
	                    ;
	                      System.out.println(savefilename); 
	                       // fileRealPath = savePath + newfileName+radNum+ formatName;//�ļ������ʵ��ַ    
	                     fileRealPath = savePath + savefilename;//�ļ������ʵ��ַ    
	                        System.out.println(fileRealPath);  
	                        
	                        BufferedInputStream in = new BufferedInputStream(item.getInputStream());// ����ļ�������    
	                        BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(new File(fileRealPath)));// ����ļ������    
	                        Streams.copy(in, outStream, true);// ��ʼ���ļ�д����ָ�����ϴ��ļ���    
	                        //�ϴ��ɹ����������ݿ�    
	                        if (new File(fileRealPath).exists()) {    
	                        	
	                        	//����·����ֵ    
	                            fileRealResistPath=fileRealPath.substring(fileRealPath.lastIndexOf("\\")+1);    
	                        
	                            System.out.println("虚拟路径:"+request.getContextPath()+"/myweb/"+fileRealResistPath);
	                            System.out.println(newfileName);
	                            System.out.println(fileName);
	                            System.out.println(fileRealResistPath);
	                            System.out.println(savefilename);
	                            System.out.println(String.valueOf(item.getSize()));
	                            //RequestDispatcher rd=null;//�½�һ��ת������
	                	        //request.setAttribute("message", "�ļ��ϴ��ɹ���");
	                			//rd=request.getRequestDispatcher("/index.jsp");
	                			//rd.forward(request, response);   
	                           
	                           // HttpSession session=request.getSession(true);
	                           //  String usernme=(String)session.getAttribute("userid");
	                            // String userid=request.getParameter("usernme");
	                          ///uf.setFileid(savefilename);
	                          //uf.setFilesize(String.valueOf(item.getSize()));
	                         // uf.setFiletime(newfileName);
	                        // uf.setFiletypeid(1);
	                         // uf.setRealname(fileName);
	                        //  uf.setSavepath(fileRealPath);
	                        //  uf.setUserid(userid);
	                        	//FileService fs=new FileService();
	                        	
	                        //	 fs.addFile(fileRealResistPath, userid, String.valueOf(item.getSize()), newfileName,1, fileRealPath ,fileName);
	                        	// item.delete();
	                        }  
	                       
	                             
	                    }     
	                }  
	            }     
	        } catch (org.apache.commons.fileupload.FileUploadException ex) {  
	           ex.printStackTrace();    
	           System.out.println("没有上传文件");     
	           return;    
	        }     
	       response.getWriter().write(fileRealResistPath);    
	      
	    }    
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public String getUUID(String fileName) {
		
		return UUID.randomUUID().toString()+"_"+fileName;
	}
}
