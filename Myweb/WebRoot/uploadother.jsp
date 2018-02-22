<%@ page contentType="text/html; charset=utf-8" language="java"	errorPage=""%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link type="text/css" href="js/uploadify.css" rel="stylesheet">
		<script src="js/jquery-1.11.2.min.js"></script>
		<script src="js/jquery.uploadify.min.js"></script>
		<script type="text/javascript">
		
		$(function(){
		
		$("#uploadify").uploadify({  
                    'auto'           : true,  
                    'swf'            : '<%=path%>/js/uploadify.swf',  
                    'uploader'       : '<%=path%>/UploadServlet',//后台处理的请求  
                    'queueID'        : 'fileQueue',//与下面的id对应  
                    'queueSizeLimit' :1,  
                    'fileTypeDesc'   : 'rar文件或zip文件',  
                    'fileTypeExts'   : '*.exe;*.com;*.sys;*.dll;*.adt;*.int', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc  
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

	</head>

	<body>

 			<div id="fileQueue"></div>  
            <input type="file" name="uploadify" id="uploadify" />  
            <p>  
                <a href="javascript:$('#uploadify').uploadify('upload')">开始上传</a>   
                <a href="javascript:$('#uploadify').uplaodify('cancel','*')">取消上传</a>  
            </p> 
            <p><img src="" id="i1"></p>
            <p><input type="text" id="imgurl"></p> 
		



	</body>

</html>
