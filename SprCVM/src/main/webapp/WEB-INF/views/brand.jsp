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
	<a href="/SprCVM/admin">На головну</a>
	<br>
	<br>
	<form method="post" action="${_csrf.parameterName}=${_csrf.token}">
		<input name="name">
		<input type="submit" value="Ok">
	</form>
	<table>
		<c:forEach var="brand" items="${brands}">
			<tr>
				<td>${brand.name}</td>
				<td><c:url value="/brand/${brand.id}" var="url"/><a href="${url}">delete</a></td>
			</tr>
		
		</c:forEach>
	
	</table>

</body>
</html>