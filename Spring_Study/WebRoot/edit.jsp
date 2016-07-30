<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>前台属性与后台对象绑定，name与对象中属性名对应</h1>
  	<!-- 不是有basepath吗，为什么还要加request.getContextPath()，而且不加就会少了这部分 -->
    <form action="<%= request.getContextPath()%>/persons/save" method="post">
    	姓名：<input type="text" name="name"/><br/>
    	年龄：<input type="text" name="age"/><br/>
    	<input type="submit" value="提交"/><input type="reset" value="重置"/>
    </form>
    
    <h1>Spring文件上传</h1>
    <form action="<%= request.getContextPath()%>/persons/doUpload" method="post" enctype="multipart/form-data">
    	文件：<input type="file" name="file"/><br/>
    	<input type="submit" value="提交"/><input type="reset" value="重置"/>
    </form>
  </body>
</html>
