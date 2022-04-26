<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Student</title>
    
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
  <h1>Delete Student</h1>
<form action="<c:url value='/StudentServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
	UID:<input type="text" name="UID" value="${form.UID}"/>
	<span style="color: red; font-weight: 900">${errors.UID}</span>
	<br/>
	
	ClassID:<input type="text" name="ClassID" value="${form.ClassID}"/>
	<span style="color: red; font-weight: 900">${errors.ClassID}</span>
	<br/>
	<input type="submit" value="Delete Student"/>
</form>
  </body>
</html>
