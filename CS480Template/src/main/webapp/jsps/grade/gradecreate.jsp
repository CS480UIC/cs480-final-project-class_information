<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Entity1 Create</title>
    
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
  <h1>Grade Create</h1>
<form action="<c:url value=''/>" method="post">
	StudentID    :<input type="text" name="StudentID" value="${form.StudentID }"/>
	<span style="color: red; font-weight: 900">${errors.StudentID }</span>
	<br/>
	AssignmentID<input type="text" name="AssignmentID" value="${form.AssignmentID }"/>
	<span style="color: red; font-weight: 900">${errors.AssignmentID }</span>
	<br/>
	Points Earned	：<input type="text" name="points_earned" value="${form.points_earned }"/>
	<span style="color: red; font-weight: 900">${errors.points_earned }</span>
	<br/>
    Points Total    :<input type="text" name="points_total" value="${form.points_total }"/>
	<span style="color: red; font-weight: 900">${errors.points_total }</span>
	<br/>
	<input type="submit" value="Create Grade"/>
</form>
  </body>
</html>
