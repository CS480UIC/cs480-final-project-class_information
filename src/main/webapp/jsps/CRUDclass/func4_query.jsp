<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">Instructor with Most Class Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Instructor ID</th>

	</tr>
<c:forEach items="${activeList}" var="instruct">
	<tr>
		<td>${instruct.getClassName()}</td>

	</tr>
</c:forEach>
</table>
</body>
</html>
