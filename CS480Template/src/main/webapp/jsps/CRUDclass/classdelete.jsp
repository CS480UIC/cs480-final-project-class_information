<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete class</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete class</h1>
<form action="<c:url value='/classServletDelete'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Delete ClassName   :<input type="text" name="ClassName" value="${form.ClassName }"/>
	<span style="color: red; font-weight: 900">${errors.ClassName }</span>
	<br/>
	<input type="submit" value="Delete class"/> 
</form>
  </body>
</html>
