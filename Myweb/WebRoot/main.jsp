<%@ page language="java" import="java.util.*,com.Myweb.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>My JSP 'main.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="bt/css/stylecss.css" type="text/css"></link>
		<link rel="stylesheet" href="bt/css/bootstrap.min.css" type="text/css"></link>
		<script type="text/javascript" src="bt/js/bootstrap.min.js">
</script>
		<script type="text/javascript" src="bt/js/bootstrap.js">
</script>
		<script type="text/javascript" src="bt/js/jquery-1.11.3.min.js">
</script>
		<script type="text/javascript" src="bt/js/jquery.min.js">
</script>



	</head>

	<body>
		<!-- 菜单条 -->
		<div class="btn-group" role="group" aria-label="...">

			<a href="TjlbAction">
				<button type="button" class="btn btn-default">
					上传文件
				</button> </a>

			<button type="button" class="btn btn-default">
				离线下载
			</button>

			<div class="btn-group" role="group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					我的设备
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li>
						<a href="#">任务列表</a>
					</li>
					<li>
						<a href="#">添加设备</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 菜单条  end -->
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				全部内容
			</div>

			<!-- Table -->
			<table class="table table_hover">
				<thead>
					<tr>
						<th>
							文件名
						</th>
						<th>
							大小
						</th>
						<th>
							修改日期
						</th>
						
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${filelist}" var="file">
						<tr>
							<td>
								<a href="DownServlet?fileid=${file.fileid}">${file.filename}</a>
							</td>
							<td>
								${file.filesize}
							</td>
							<td>
								${file.filetime}
							</td>
							
						</tr>


					</c:forEach>
				</tbody>
			</table>
		</div>

	</body>
</html>
