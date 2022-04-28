<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Class Output</title>
    
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
  <h1>Read Content Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	FileID    :<input type="text" name="FileID" value="${entity1.getFileID()}" disabled/>
	<br/>
	File    :<input type="text" name="File" value="${entity1.getFile()}" disabled/>
	<br/>
	Description    :<input type="text" name="Description" value="${entity1.getDescription()}" disabled/>
	<br/>
	LectureDate    :<input type="text" name="LectureDate" value="${entity1.getLectureDate()}" disabled/>
	<br/>
	LectureID    :<input type="text" name="LectureID" value="${entity1.getLectureID()}" disabled/>
	<br/>
	ContentType    :<input type="text" name="ContentType" value="${entity1.getContentType()}" disabled/>
	<br/>
	ClassID：<input type="text" name="ClassID" value="${entity1.getClassID()}" disabled/>
	<br/>
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>