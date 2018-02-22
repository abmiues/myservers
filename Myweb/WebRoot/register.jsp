<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="bt/css/indexstyle.css" type="text/css"></link>
  <link rel="stylesheet" href="bt/css/stylecss.css" type="text/css"></link>
  	<link type="text/css" href="js/uploadify.css" rel="stylesheet">
		<script src="js/jquery-1.11.2.min.js"></script>
		<script src="js/jquery.uploadify.min.js"></script>
		<script type="text/javascript">
function display_alert()
  {
  alert("I am an alert box!!")
  }
</script>
		<script type="text/javascript">
		
		$(function(){
		
		$("#uploadify").uploadify({  
                    'auto'           : true,  
                    'swf'            : '<%=path%>/js/uploadify.swf',  
                    'uploader'       : '<%=path%>/UploadServlet',//后台处理的请求  
                    'queueID'        : 'fileQueue',//与下面的id对应  
                    'queueSizeLimit' :1,  
                    'fileTypeDesc'   : 'rar文件或zip文件',  
                    'fileTypeExts'   : '*.jpg;*.png;*.gif;*.bmp;*.pic;*.tif', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc  
                    'multi'          : true,  
                    'buttonText'     : '上传',
                    'cancelImg'      : '<%=path%>/js/uploadify-cancel.png',
                     'onUploadSuccess': function(file,data,response){
                                      $("#i1").attr("src","<%=path%>/geedisk/"+data);
                                      $("#imgurl").val("/geedisk/"+data);
                                      alert(data);
                                      
                                   }
     });  
		
		});
		
		</script>
		 <script language="javascript"> 
    function delcfm() { 
        if (!confirm("注册成功！")) { 
            window.event.returnValue = false; 
        } 
    } 
</script>
  </head>
  
 
<body class="layout bg2">
  <!-- 导航条 -->
		<div class="nav1 ma_top2 ma-left">
		<img src="images/logo1.png" style="width:60px;" class="flo"></img>
		<div class="regn1 title ma_top2 flo">注册Gee Disk账号</div>
		<div class="flo2 ma_top2 ma-right">
			我已注册，现在就登录
		</div>
		</div>
	<div><img src="images/xian.PNG" style="width:1130px"></img></div>
		<!-- 导航条  end -->
  <div class="regi flo ">
    <form id="form1" name="form1" method="post" action=" ResAction " class="ma-left3">
	  <p class="register">
	    <label for="textfield">账 号：</label>
	    <input type="text" name="textID" id="textID" class="regn1"/>
	  </p>
	   <p class="register">
	    <label for="textfield2">昵 称：</label>
	    <input type="text" name="textUserName" id="textUserName" class="regn1"/>
	  </p>
	 <p class="register">
	    <label for="textfield2">密 码：</label>
	    <input type="text" name="textPaw" id="textPaw" class="regn1"/>
	  </p>
	  <p class="register">
	    <label for="textfield2">电  话：</label>
	    <input type="text" name="textPhone" id="textPhone" class="regn1"/>
	  </p>
	 <p class="register">
	    <label for="textfield2">邮 箱：</label>
	    <input type="text" name="textEmail" id="textEmail" class="regn1"/>
	  </p>
	  <p class="register">
	    <label for="textfield2">头 像：</label>
	     <input type="text" name="imgurl" id="imgurl" class="regn1"/>
	     </p>
	     <p class="regfile">
	     <div id="fileQueue"></div>  
						  <input type="file" name="uploadify" id="uploadify" />
			</p>			
						
	 
	  <p class="maina ma_top2 ma-left ma_bot">
		<input type="radio" name="radio" id="paw" value="paw" />
			阅读并接受《GeeDisk用户协议》
	</p>
	 
<p class="register"> 
 <form action="login.jsp" target="_blank" method="get"> 
<input type="submit" name="button" id="buttonReg" value="注册"  onClick="delcfm()" class="butt" /></form> 
</p> 
</form>
</div>
<div class="regimg flo">
<img src="images/re1.PNG"></img>
</div>

  </body>
</html>

