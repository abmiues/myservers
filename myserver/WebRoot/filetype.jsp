<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String filetype=request.getParameter("filetype");
	String userids=(String)session.getAttribute("userid");
request.setAttribute("filetype", filetype);

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

<script type="text/javascript">
var alldata;
$(document).ready(function(){

	 $.ajax(
             	  	{
             	  		 cache: true,
              			 type: "GET",
              			 contentType: "application/x-www-form-urlencoded; charset=utf-8",
               			 url:"getfiletype",
               			 data:{userid:<%=userids%>},
               			 /* data:{userid:$("input[name='userid']").val() }, */
               			 async: false,
              			 error: function(request) {
                    	 alert("2服务器连接失败");
              				 },
              			 success:function(datas)
              			 {
              			 $("#typelist").empty();  
              			 /*  $("#typelist").html("<a href='#' class='list-group-item'><img src='images/"+datas[0]+"' style='width: 20px; margin-right: 10px;'></img>"+datas[0]+"</a>"); */
              			 var htmlstr="";
              			 for(var i=0;i<datas.length;i++)
              			 {
              			 htmlstr+="<a href='javascript:selectbytype(\""+datas[i]+"\")' class='list-group-item'><img src='images/"+datas[i]+"' style='width: 20px; margin-right: 10px;'></img>"+datas[i]+"</a>";
              			 } 
						 $("#typelist").html(htmlstr);
              			 
              			 
              			 
							
							
							/* $.each(datas.items,function(i,n){
							alert(n.sku);//测试 这是我得到的一个数组 是可以得到的 
							
							 });	*/	 
              			 
              			 
              			 }
             	  		});
         $.ajax(
             	  	{
             	  		 cache: true,
              			 type: "POST",
              			 contentType: "application/x-www-form-urlencoded; charset=utf-8",
               			 url:"getfilelist",
               			data:{userid:<%=userids%>},
               			 /* data:{userid:$("input[name='userid']").val() }, */
               			 async: false,
              			 error: function(request) {
                    	 alert("2服务器连接失败");
              				 },
              			 success:function(datas)
              			 {
              			
              			 	alldata=datas;
               				$("#filelist").empty(); 
               				var htmlstr="";
               				for(var i=0;i<datas.length;i++)
               				{
               				htmlstr+="<tr><td><a href='download?filename="+datas[i].filename+"&&uploadtime="+datas[i].uploadtime+"'>"+datas[i].filename+"</a></td><td>"+datas[i].filesize+"</td><td>"+datas[i].uploadtime+"</td></tr>";
               				}		 
              			 $("#filelist").html(htmlstr);
              			 
              			 }
             	  		});
	});
	
	
		function selectbytype(type)
	{
	
		var htmlstr="";
		if(type!="all")
		{
			for(var i=0;i<alldata.length;i++)
			{
				if(alldata[i].filetype==type)
				{
					htmlstr+="<tr><td><a href='download?filename="+alldata[i].filename+"&&uploadtime="+alldata[i].uploadtime+"'>"+alldata[i].filename+"</a></td><td>"+alldata[i].filesize+"</td><td>"+alldata[i].uploadtime+"</td></tr>";
				}
			}
			$("#filelist").empty(); 
			$("#filelist").html(htmlstr);
			
		}
		else
		{
			for(var i=0;i<alldata.length;i++)
			{
				htmlstr+="<tr><td><a href='download?filename="+alldata[i].filename+"&&uploadtime="+alldata[i].uploadtime+"'>"+alldata[i].filename+"</a></td><td>"+alldata[i].filesize+"</td><td>"+alldata[i].uploadtime+"</td></tr>";
			}
			$("#filelist").empty(); 
			$("#filelist").html(htmlstr);
		}
	} 
</script>
	
	
	</head>

	<body>

		<a href="javascript:selectbytype('all')" class="list-group-item "> <img
				src="images/Save_all_64px_583566_easyicon.net.png"
				style="width: 20px; margin-right: 10px;"></img>全部文件 </a>
		<div class="list-group" id="typelist">
			<%-- <c:forEach items="${filetype}" var="lb">

				<a href="#" class="list-group-item">
				<img
				src="images/${lb }"
				style="width: 20px; margin-right: 10px;"></img>
				${lb}</a>

			</c:forEach> --%>
		</div>
	</body>
</html>


