<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
	border: 1px solid black;
	border-collapse: collapse;
	margin-top: 30px;
	}
	td{
	border: 1px solid black;
	padding-left: 10px;
	padding-right: 10px;
	}
</style>
</head>
<body>
	<a href="/SprCVM/admin">На головну</a>
	<br>
	<br>
<!--
	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
		<input name="name">
		<input type="submit" value="Ok">
	</form>
 -->
 	<c:url value="/color" var="url"/>
 	<sf:form method="POST" modelAttribute="color" action="${url}">
 		<sf:input path="id" type="hidden"/>
 		<sf:input path="name"/>
 		<input type="submit" value="Додати">
 	</sf:form>
	<table>
	<c:forEach var="color" items="${colors}">
		<tr>
			<td>${color.name}</td>
			<td><c:url value="/color/${color.id}" var="url"/><a href="${url}">delete</a></td>
			<td><c:url value="/color/edit/${color.id}" var="url"/><a href="${url}">edit</a></td>
		</tr>
	</c:forEach>
	
	</table>

</body>
</html>