<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>class Create</title>
    
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
  <h1>class Create</h1>
<form action="<c:url value='/classServletCreate'/>" method="post">
	ClassID    :<input type="text" name="ClassID" value="${form.ClassID }"/>
	<span style="color: red; font-weight: 900">${errors.ClassID }</span>
	<br/>
	ClassName：<input type="text" name="ClassName" value="${form.ClassName }"/>
	<span style="color: red; font-weight: 900">${errors.ClassName }</span>
	<br/>
	InstructorID    :<input type="text" name="InstructorID" value="${form.InstructorID }"/>
	<span style="color: red; font-weight: 900">${errors.InstructorID }</span>
	<br/>
	Semester：<input type="text" name="Semester" value="${form.Semester }"/>
	<span style="color: red; font-weight: 900">${errors.Semester }</span>
	<br/>
	
	<input type="submit" value="Create class"/> 
</form>
  </body>
</html>
