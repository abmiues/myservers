<%@ page contentType="text/html; charset=utf-8" import="java.text.*"
	language="java" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link type="text/css" href="js/uploadify.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="bt/css/bootstrap.min.css" />
		<script src="js/jquery-1.11.2.min.js">
</script>
		<script src="js/jquery.validate.min.js">
</script>
		<script src="bt/bootstrap.min.js">
</script>
		<script src="js/jquery.uploadify.min.js">
</script>
 <script language="javascript"> 
    function delcfm() { 
        if (!confirm("文件上传成功！")) { 
            window.event.returnValue = false; 
        } 
    } 
</script>
		<script type="text/javascript">

$(function() {

	$("#uploadify")
			.uploadify(
					{
						'auto' : true,
						'swf' : '<%=path%>/js/uploadify.swf',
						'uploader' : '<%=path%>/UploadServlet',//后台处理的请求  
						'queueID' : 'fileQueue',//与下面的id对应  
						'queueSizeLimit' : 1,
						progressData : 'all',
						'fileTypeDesc' : 'rar文件或zip文件',
						'fileTypeExts' : '*.rar;*.zip;*.arj;*.jpg;*.png;*.gif;*.bmp;*.pic;*.tif;*.avi ;*.rmvb; *.rm; *.asf; *.divx; *.mpg; *.mpeg; *.mpe;*.exe;*.com;*.sys;*.dll;*.adt;*.int;*.mp3;*.wav;*.aif;*.au;*.ram;*.mmf;*.amr;*.aac;*.flac;*.docx;*.txt;*.doc;*.wps;*.html;*.rtf;*.hlp;*.pdf;*.ppt;*.xls', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc  
						'multi' : true,
						'buttonText' : '上传',
						'cancelImg' : '<%=path%>/js/uploadify-cancel.png',
						'onUploadSuccess' : function(file, data, response) {
							$("#i1").attr("src", "<%=path%>/geedisk/" + data);
							$("#fileid").val(data);
							$("#filepath").val("/geedisk/" + data);
							$("#filename").val(file.name);
							$("#filetime").val(file.creationdate);
							$("#filetype").val(file.type);
							$("#filesize").val(file.size);

							alert(data);

						}
					});

});
</script>

	</head>

	<body>
		<!-- 导航条 -->
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->

			<div class="navbar-header">
				<a class="" href="#"> <img alt="Brand" src="images/logo1.png"
						style="width: 50px; margin-top: 3px;"> </a>
			</div>

			<div class="navbar-header">
				<a class="" href="#"> <img alt="Brand" src="images/logo.png"
						style="width: 110px; margin-left: 10px;"> </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="#">主页<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a href="#">分享</a>
					</li>
					<li>
						<a href="#">应用</a>
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
					action="FileQuery">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="key">
					</div>
					<button type="submit" class="btn btn-default">
						搜索
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="UserServlet">${userid }</a>
					</li>
					<li>
						<a href="#">客户端下载</a>
					</li>
					<li>
						<a href="#">通知</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">更多<span
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
		
			</div>

			<div class="col-md-8">
				

		

					<div class="panel panel-default">
						<div class="panel-body">

							<form class="form-horizontal" method="post" action="UploadAction">
								<div class="row">

									<div class="col-sm-8">
										<p>
											<input type="hidden" id="fileid" name="fileid">
										</p>
										<p>
											<input type="hidden" id="filepath" name="filepath">
										</p>

										<p>
											<input type="hidden" id="filetime" name="filetime">
										</p>
										<p>
											<input type="hidden" id="filetype" name="filetype">
										</p>

										<p>
											<input type="hidden" id="filesize" name="filesize">
										</p>


										<div class="form-group">
											<label for="input2" class="col-sm-3 control-label">
												用户名：
											</label>
											<div class="col-sm-9">
												<input type="text" id="username" name="username">
											</div>
										</div>
										<div class="form-group">
											<label for="input2" class="col-sm-3 control-label">
												文件名：
											</label>
											<div class="col-sm-9">
												<input type="text" id="filename" name="filename">
											</div>
										</div>


										<div class="form-group">
											<label class="col-sm-3 control-label">
												所属类别
											</label>
											<div class="col-sm-4">
												<select class="form-control" name="filetypeid"
													id="filetypeid">
													<c:forEach items="${fileTypeList}" var="lb">
														<option value="${lb.id}">
															${lb.name}
														</option>
													</c:forEach>
												</select>
											</div>
										</div>

									<div class="form-group">
									<div class="col-sm-3">
									</div>
										<div class="col-sm-4">
											<div id="fileQueue"></div>
											<p></p>
											<p>
												<input type="file" name="uploadify" id="uploadify" />
											</p>

										</div>
									</div>

										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-8">
											 <form action="index.jsp" target="_blank" method="get"> 
<input type="submit" name="button" id="buttonReg" value="提交"  onClick="delcfm()" class="btn" /></form> 
												
											</div>
										</div>
									</div>
								
								</div>

							</form>
						</div>

					</div>
			</div>
		</div>
		<!--内容 end -->

	</body>

</html>
