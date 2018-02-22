<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
$(document).ready(function(){
	

  $("#form1").submit(function(){
	  
	  var s= $("#userid").val();
	  if(s=="")
		{alert("请输入账号");return false;}
	  else
		  {
		  var reg=/^[A-Za-z0-9]{6,16}$/;
		  if(!reg.test(s)){alert("账号不符合规范");return false;}
		  }
	  var s= $("#name").val();
	  if(s=="")
		{alert("请输入昵称");return false;}
	  else
		  {
		  var reg=/^[A-Za-z0-9]{1,16}$/;
		  if(!reg.test(s)){alert("昵称不符合规范");return false;}
		  }
	  var s= $("#pwd").val();
	  if(s=="")
		{alert("请输入密码");return false;}
	  else
		  {
		  var reg=/^([A-Za-z0-9_]|[^A-Za-z0-9_]){6,18}$/;
		  if(!reg.test(s)){alert("密码不符合规范");return false;}
		  }
	  var s= $("#pwd").val();
	  var cs= $("#chkpwd").val();
	  if(cs=="")
			{alert("请确认密码");return false;}
	  else if(s!=cs)
	  		{ alert("两次输入密码不一致");return false;}
	  var s= $("#email").val();
	    if(s=="")
		{alert("请输入邮箱");return false;}
		else
		 {
			 var reg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;;
			 if(!reg.test(s)){alert("邮箱格式不正确");return false;}
		 }
	  
	  
  	$.ajax(
  	{
  		 cache: true,
                type: "POST",
                url:"register",
               
                data:$("#form1").serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("服务器连接失败");
                },
                success: function(data) {
               		if(data=="111")
             	 	 {
             	 	 alert("注册成功,请登录邮箱激活账号");
             	 	window.location.href="index.jsp"; 
             	  
               		  }
          			else if(data=="100")
                	 alert("账号已存在");
            		else
               		  alert("服务器错误");
                }
  		}
  	);
  return false;});
});
</script>
  <script type="text/javascript">
  function veryuserid() {  
	  var s= $("#userid").val();
	  if(s=="")
		alert("请输入账号");
	  else
		  {
		  var reg=/^[A-Za-z0-9]{6,16}$/;
		  if(!reg.test(s)){alert("账号不符合规范");}
		  }
		}; 
		
  </script>
    <script type="text/javascript">
  function verynickname() {  
	  var s= $("#name").val();
	  if(s=="")
		alert("请输入昵称");
	  else
		  {
		  var reg=/^[A-Za-z0-9]{1,16}$/;
		  if(!reg.test(s)){alert("昵称不符合规范");}
		  }
		}; 
		
  </script>
  <script type="text/javascript">
  function verypwd() {  
	  var s= $("#pwd").val();
	  if(s=="")
		alert("请输入密码");
	  else
		  {
		  var reg=/^([A-Za-z0-9_]|[^A-Za-z0-9_]){6,18}$/;
		  if(!reg.test(s)){alert("密码不符合规范");}
		  }
		}; 
		
  </script>
   <script type="text/javascript">
  function checkpwd() {  
	  var s= $("#pwd").val();
	  var cs= $("#chkpwd").val();
	  if(cs=="")
			alert("请确认密码");
	  else if(s!=cs)
		  alert("两次输入密码不一致");
		
  }
  </script>
  
     <script type="text/javascript">
  function checkemail() {  
	  var s= $("#email").val();
	  if(s=="")
			alert("请输入邮箱");
		  else
			  {
			  var reg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;;
			  if(!reg.test(s)){alert("邮箱格式不正确");}
			  }
  }
  </script>
  
  
  </head>
  
 
<body class="layout bg2">
  <!-- 导航条 -->
		<div class="nav1 ma_top2 ma-left">
		<img src="images/logo1.png" style="width:60px;" class="flo"></img>
		<div class="regn1 title ma_top2 flo">注册MobileScreenk账号</div>
		<div class="flo2 ma_top2 ma-right">
			我已注册，现在就登录
		</div>
		</div>
	<div><img src="images/xian.PNG" style="width:1130px"></img></div>
		<!-- 导航条  end -->
  <div class="regi flo ">
    <form id="form1" name="form1" class="ma-left3">
	  <p class="register">
	    <label for="textfield">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
	    <input type="text" name="userid" id="userid" class="regn1" onChange="veryuserid()"/> 
	  </p>
	  <br>
	  <p ><font face=黑体 color=#949494 size=1>账号仅限输入大小写英文、数字，长度6-16个字符</font></p>
	   <p class="register">
	    <label for="textfield2">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
	    <input type="text" name="name" id="name" class="regn1" onChange="verynickname()" />
	  </p>
	  <br>
	  <p ><font face=黑体 color=#949494 size=1>昵称暂时仅限输入大小写英文、数字，长度不超过16字符</font></p>
	 <p class="register">
	    <label for="textfield2">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
	    <input type ="password" name="pwd" id="pwd" class="regn1" onChange="verypwd()"	/>
	   
	  </p>
	   <br>
	  <p ><font face=黑体 color=#949494 size=1>密码长度为6-18个字符</font></p>
	  <p class="register">
	    <label for="textfield2">确认密码：</label>
	    <input type ="password" name="chkpwd" id="chkpwd" class="regn1" onChange="checkpwd()"/>
	  </p>
	 <p class="register">
	    <label for="textfield2">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
	    <input type="text" name="email" id="email" class="regn1" onChange="checkemail()"/>
	  </p>		
						
	 
	  <p class="maina ma_top2 ma-left ma_bot">
		<input type="radio" name="radio" id="paw" value="paw" />
			阅读并接受《MobileScreen用户协议》
	</p>
	 
<p class="register"> 
<input type="submit" name="button" id="buttonReg" value="注册"  onClick="delcfm()" class="butt" /></p> 
</form> 

</div>
<div class="regimg flo">
<img src="images/re1.PNG"></img>
</div>

  </body>
</html>

