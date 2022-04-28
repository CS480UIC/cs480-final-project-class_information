<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>Please select an option below</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>
    <br>
    <p>Simple Queries:</p>
 	<a href="<c:url value='/q1'/>" target="body">Please list all active Students in the table</a>
 	<br>
 	<a href="<c:url value='/q3'/>" target="body">Please list all active Class (Fall 2021) in the table</a>
 	<br>
 	
 	
 	<a href="<c:url value='/q2'/>" target="body">Please list all active Instructor UIDs in the table</a>
 	<br>
 	<p>Complex Queries:</p>
 	
    <a href="<c:url value='/q5'/>" target="body">Please list Average Grades in the table</a>
 	<br>
 	<a href="<c:url value='/q4'/>" target="body">Please list all classIDs with the number of students in the table</a>
 	<br>
  </body>
</html>
