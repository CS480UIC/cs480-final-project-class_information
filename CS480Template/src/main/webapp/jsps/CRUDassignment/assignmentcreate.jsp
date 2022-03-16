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
  <h1>Assignment Create</h1>
<form action="<c:url value=''/>" method="post">
	ClassID    :<input type="text" name="ClassID" value="${form.class_id}"/>
	<span style="color: red; font-weight: 900">${errors.class_id}</span>
	<br/>
	Title：<input type="text" name="title" value="${form.title}"/>
	<span style="color: red; font-weight: 900">${errors.class_id}</span>
	<br/>
	Description	：<input type="text" name="description" value="${form.description}"/>
	<span style="color: red; font-weight: 900">${errors.class_id}</span>
	<br/>
	Due Date	：<input type="text" name="due_date" value="${form.due_date}"/>
	<span style="color: red; font-weight: 900">${errors.class_id}</span>
	<br/>
	Upload File	：<input type="text" name="upload_file" value="${form.upload_file}"/>
	<span style="color: red; font-weight: 900">${errors.class_id}</span>
	<br/>
	<input type="submit" value="Create Assignment"/>
</form>
  </body>
</html>
