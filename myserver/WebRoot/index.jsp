<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="qx.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" href="bt/css/bootstrap.min.css" type="text/css"></link>

<script type="text/javascript" src="bt/js/jquery-1.11.3.min.js">
</script>
		
		<script type="text/javascript" src="bt/js/bootstrap.min.js">
</script>
		<script type="text/javascript">
		function showdialog() {  
			alert("功能暂未开放");
			}; 

</script>
		

	</head>


	<body>

		<!-- 导航条 -->
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->

			<div class="navbar-header">
				<a class="" href="index.jsp"> <img alt="Brand" src="images/logo1.png"
						style="width: 50px; margin-top: 3px;"> </a>
			</div>

			<div class="navbar-header">
				<a class="" onclick="showdialog()"> <br> </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="index.jsp">主页<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a  onclick="showdialog()">分享</a>
					</li>
					<li>
						<a  onclick="showdialog()">应用</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">网盘 <span
							class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">Action</a>
							</li>
							<li>
								<a href="#">Another action</a>
							</li>
							<li>
								<a href="#">Something else here</a>
							</li>
							<li role="separator" class="divider"></li>
							<li>
								<a href="#">Separated link</a>
							</li>
							<li role="separator" class="divider"></li>
							<li>
								<a href="#">One more separated link</a>
							</li>
						</ul>
					</li>
				</ul>

				<form class="navbar-form navbar-left" role="search"
					action="">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="key">
					</div>
					<button type="submit" class="btn btn-default" onclick="showdialog()">
						搜索
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="UserServlet" style="color:#fff">${userid}</a>
					</li>
					<li>
						<a href="#">客户端下载</a>
					</li>
					<li>
						<a href="connect.jsp">远程</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">更多<span
							class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a  onclick="showdialog()">远程文件</a>
							</li>
							<li>
								<a  onclick="showdialog()">文件举报</a>
							</li>
							<li>
								<a  onclick="showdialog()">投诉建议</a>
							</li>
							<li role="separator" class="divider"></li>
							<li>
								<a  onclick="showdialog()">关于我们</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
		</nav>
		<!-- 导航条  end -->

		<!--内容 -->
		<div class="row">
			<div style="width: 40px; height: 500px; float: left;">
			</div>
			<div class="col-md-2">
				<%@ include file="filetype.jsp"%>
			</div>

			<div class="col-md-8">
				<%@ include file="main.jsp"%>
			</div>
		</div>
		<!--内容 end -->
	</body>
</html>
