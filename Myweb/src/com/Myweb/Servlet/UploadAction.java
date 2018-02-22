package com.Myweb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Myweb.Entity.FileType;
import com.Myweb.Service.FileService;

public class UploadAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UploadAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
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

		 request.setCharacterEncoding("utf-8");
			
		 RequestDispatcher rd=null;
		 
		 FileService fs=new FileService();
		 String fileid=request.getParameter("fileid");
			HttpSession session = request.getSession(true);
			session.setAttribute("fileid", fileid);
			
			String userid=request.getParameter("username");
			String filename=request.getParameter("filename");
			String filetime=request.getParameter("filetime");
			String filesize=request.getParameter("filesize");
			String filepath=request.getParameter("filepath");
			String filetypeid = request.getParameter("filetypeid");
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	//String tjsj = df.format(filetime);
		
			
			
			 fs.addFile(fileid, userid,filename,filetime,filesize,filepath,Integer.parseInt(filetypeid));
			
			//转发
			
			request.setAttribute("message", "上传成功!");
			
			rd=request.getRequestDispatcher("/UpFileServlet");
				
			rd.forward(request, response);
			
        
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
