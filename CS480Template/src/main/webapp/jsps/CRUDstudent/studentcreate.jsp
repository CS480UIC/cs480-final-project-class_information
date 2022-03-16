<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Assignment</title>
    
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
  <h1>assignment Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	ClassID    :<input type="text" name="ClassID" value="${form.ClassID }"/>
	<span style="color: red; font-weight: 900">${errors.ClassID }</span>
	<br/>
	Title：<input type="text" name="Title" value="${form.Title }"/>
	<span style="color: red; font-weight: 900">${errors.Title }</span>
	<br/>
	Description	：<input type="text" name="Description" value="${form.Description }"/>
	<span style="color: red; font-weight: 900">${errors.Description }</span>
	<br/>
	Due_Date	：<input type="text" name="Due Date" value="${form.Due_Date }"/>
	<span style="color: red; font-weight: 900">${errors.Due_Date }</span>
	<br/>
	Upload_File	：<input type="text" name="Upload File" value="${form.Upload_File }"/>
	<span style="color: red; font-weight: 900">${errors.Upload_File }</span>
	<br/>
	<input type="submit" value="Create assignment"/>
</form>
  </body>
</html>