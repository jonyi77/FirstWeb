<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/SprCVM">На головну</a>
	<br>
	<br>
	<form method="post">
		<input name="name">
		<input type="submit" value="Ok">
	</form>
	<table>
		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.name}</td>
				<td><c:url value="/category/${category.id}" var="url"/><a href="${url}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>