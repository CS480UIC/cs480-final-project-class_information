<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Student</title>
    
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
  <h1>student Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	ClassID    :<input type="text" name="ClassID" value="${form.ClassID}"/>
	<span style="color: red; font-weight: 900">${errors.ClassID }</span>
	<br/>
	StudentUID：<input type="text" name="StudentUID" value="${form.StudentUID}"/>
	<span style="color: red; font-weight: 900">${errors.Title }</span>
	<br/>
	Enrolled	：<input type="text" name="Enrolled" value="${form.enrolled}"/>
	<span style="color: red; font-weight: 900">${errors.Description }</span>
	<br/>
	Degree Type	：<input type="text" name="degree_type" value="${form.degree_type}"/>
	<span style="color: red; font-weight: 900">${errors.Due_Date }</span>
	<br/>

	<input type="submit" value="Create Student"/>
</form>
  </body>
</html>
