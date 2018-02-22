<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="bt/css/stylecss.css" type="text/css"></link>
		<script type="text/javascript" src="bt/js/jquery-1.11.3.min.js">
</script>
		<script type="text/javascript" src="bt/js/jquery.min.js">
</script>
		<link rel="stylesheet" href="bt/css/indexstyle.css" type="text/css"></link>
		<script type="text/javascript" src="bt/js/focusjquery.js">
</script>

		<script type="text/javascript" src="bt/js/bootstrap.js">
</script>
		<script type="text/javascript" src="bt/js/bootstrap.min.js">
</script>
		<link rel="stylesheet" href="bt/css/bootstrap.min.css" type="text/css"></link>
		
	</head>

	<body class="login" background="images/bg4.png">
		<!-- 导航条 -->
		<div class="nav1 ma-left">
		<img src="images/logo1.png" style="width:60px;" class="flo"></img>&nbsp;
		<div class="">
			<ul>
				<li>关于我们</li>
				<li>在线注册</li>
				<li>官方微博</li>
				<li>客户端下载</li>
			</ul>
		</div>
		</div>
		<!-- 导航条  end -->

		<!--滚动图-->
		<div class="wrapper">
			<div id="focus">
				<ul>
					<li style="background-image: url(images/01.jpg)"></li>
					<li style="background-image: url(images/02.jpg)"></li>
					<li style="background-image: url(images/03.jpg)"></li>
					<li style="background-image: url(images/04.jpg)"></li>
					<li style="background-image: url(images/05.jpg)"></li>
				</ul>

			</div>
			<div class=" main">
				<div class="bg"></div>
				<div class="indexReg ">
					<p class="title ma-left">
						登录Mobile Screen账号
					</p>
					<form id="form1" name="form1" method="post" action="LoginAction "  onSubmit="return Check()">
						<div class="for ma-left">
							<p class="renshu">
								<label for="textfield">
									用户名：
								</label>
								<input type="text" name="textUser" id="textUser" />
							</p>
							<p class="renshu">
								<label for="textfield2">
									密&nbsp;&nbsp;&nbsp;&nbsp;码：
								</label>
								<input type="text" name="textPaw" id="textPaw" />
							</p>
						</div>
						<div class="maina ma_top flo ma-left ma_bot">
							<input type="radio" name="radio" id="paw" value="paw" />
							下次自动登录
							<a href="forgetmm.jsp" class="mal">忘记密码</a>
						</div>

						<div class="ma_top2 ma-left">
							<input type="submit" name="btLogin" id="btLogin" value="登录"
								class="butt" />
						</div>
					</form>
					<div class="maina ma_top2 flo ma-left">
						可以使用以下方式登录
					</div>
					<div class="maina ma_top2 flo ma-left">
						<img src="images/tu1.png" style="width: 241px; height: 44px;"></img>
					</div>
					<div class="reg ma_top2 te-al2 flo">
						没有Gee Disk账号？
					</div>
					<div class=" ma_top2 flo">
						<a href="register.jsp">
						<input type="submit" name="btRegist" id="btRegist" value="立即注册账号" class="buttreg" />
						</a>
					</div>

				</div>
			</div>
		</div>
		<!--滚动图 end-->
		<div class="flo">
			<img src="images/tu2.PNG"></img>
		</div>
		<div class="flo foot ma_top2">
			©2015 浙江财经大学 | 软件工程 | 技术支持 | 陈薇 | 付静 | 杨弯弯
		</div>
	</body>
</html>
