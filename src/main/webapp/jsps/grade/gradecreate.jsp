<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>create grade</title>
    
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
  <h1>grade Create</h1>
<form action="<c:url value='/gradeServletAll'/>" method="post">
<input type="hidden" name="method" value="create"/>
	StudentUID    :<input type="text" name="StudentUID" value="${form.StudentUID }"/>
	<span style="color: red; font-weight: 900">${errors.StudentUID }</span>
	<br/>
	AssignmentID：<input type="text" name="AssignmentID" value="${form.AssignmentID }"/>
	<span style="color: red; font-weight: 900">${errors.AssignmentID }</span>
	<br/>
	TotalPoints    :<input type="text" name="TotalPoints" value="${form.TotalPoints }"/>
	<span style="color: red; font-weight: 900">${errors.TotalPoints }</span>
	<br/>
	PointsEarned：<input type="text" name="PointsEarned" value="${form.PointsEarned }"/>
	<span style="color: red; font-weight: 900">${errors.PointsEarned }</span>
	<br/>
	
	<input type="submit" value="Create Grade"/> 
</form>
  </body>
</html>
