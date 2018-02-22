<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'filetype.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="bt/css/stylecss.css" type="text/css"></link>

	</head>

	<body>


		<a href="UpFileServlet" class="list-group-item "> <img
				src="images/Save_all_64px_583566_easyicon.net.png"
				style="width: 20px; margin-right: 10px;"></img>全部文件 </a>
		<div class="list-group">
			<c:forEach items="${fileTypeList}" var="lb">

				<a href="FileTypeServlet?lb=${lb.id}" class="list-group-item">
				<img
				src="images/${lb.typeimage }"
				style="width: 20px; margin-right: 10px;"></img>
				${lb.name}</a>

			</c:forEach>
		</div>
	</body>
</html>


