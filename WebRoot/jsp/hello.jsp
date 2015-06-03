<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hello.jsp' starting page</title>
    
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
    <h1 align="center">用户信息</h1> <hr style="border-style:dashed;border-color:#665533"><br> 
<!--    para:<%=request.getAttribute("paraKey") %><br>
  	para-username:${parameters.username[0]}<br>
  	para-age:${parameters.age[0]}<br>
  	
    request-username:<%=request.getParameter("username") %><br>
   -->   
    request:<%=request.getAttribute("requestKey") %><br> <!-- 读取成功 说明requestMap为 request attributeMap -->
    <%=request.getParameter("username") %>
  </body>
</html>
