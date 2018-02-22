<%@ page language="java" import="java.util.*,com.Myweb.*"
	pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String userid=(String)session.getAttribute("userid");
if(userid==null)
response.sendRedirect("login.jsp");

%>
