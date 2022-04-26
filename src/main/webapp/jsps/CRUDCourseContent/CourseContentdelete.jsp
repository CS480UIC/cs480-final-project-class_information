<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Course Content</title>
    
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
  <h1>Delete Course Content</h1>
<form action="<c:url value='/Entity1ServletDelete'/>" method="post">
	<input type="hidden" name="method" value="search"/>
		
	FileID    :<input type="text" name="FileID" value="${form.FileID }"/>
	<span style="color: red; font-weight: 900">${errors.FileID }</span>
	<br/>
	File：<input type="text" name="File" value="${form.File }"/>
	<span style="color: red; font-weight: 900">${errors.File }</span>
	<br/>
	Description    :<input type="text" name="Description" value="${form.Description }"/>
	<span style="color: red; font-weight: 900">${errors.Description }</span>
	<br/>
	LectureDate    :<input type="text" name="LectureDate Date" value="${form.LectureDate }"/>
	<span style="color: red; font-weight: 900">${errors.LectureDate }</span>
	<br/>
	LectureID    :<input type="text" name="LectureID" value="${form.LectureID }"/>
	<span style="color: red; font-weight: 900">${errors.LectureID }</span>
	<br/>
	ContentType    :<input type="text" name="ContentType" value="${form.ContentType }"/>
	<span style="color: red; font-weight: 900">${errors.ContentType }</span>
	<br/>
	ClassID    :<input type="text" name="ClassID" value="${form.ClassID }"/>
	<span style="color: red; font-weight: 900">${errors.ClassID }</span>
	<br/>
	
	<input type="submit" value="Delete Course Content"/> 
</form>
  </body>
</html>
