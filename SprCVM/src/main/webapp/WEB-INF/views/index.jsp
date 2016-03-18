<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello</h2>
	<ul>
		<li><a href="country"> Посилання на країну</a></li>
		<li><a href="color"> Посилання на колір</a></li>
		<li><a href="brand"> Посилання на бренд</a></li>
		<li><a href="category"> Посилання на категорію</a></li>
		<li><a href="season"> Посилання на сезон</a></li>
		<li><a href="style"> Посилання на стиль</a></li>
		<li><a href="type"> Посилання на тип</a></li>
		<li><a href="article"> Посилання на товар</a></li>
		<li><a href="size"> Посилання на розмір</a></li>
	</ul>
	<form method="post">
		<table>
			<tr>
				<th>Age:</th>
				<td><input name="age" type="text" /></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="add" /></td>
			</tr>
		</table>
	</form>
	<table>
		<c:if test="${persons.size() ne 0}">
			<c:forEach begin="0" end="${persons.size()-1}" var="index">
				<tr>
					<td>${persons.get(index).getAge()}</td>
					<td>${persons.get(index).name}</td>
					<c:url value="/" var="url" />
					<td><a href="${url}${index}">delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${persons.size() eq 0}">
			<p>Nothing</p>
		</c:if>
	</table>
</body>
</html>