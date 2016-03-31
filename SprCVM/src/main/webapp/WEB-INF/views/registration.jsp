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
	.registr {
	width:385px;
	padding: 20px;
	border: solid 1px black;
	text-align: center;
	margin: auto;
	margin-top: 90px;
	}
</style>
</head>
<body>
	<div class="registr">
<!-- 	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
		<table>
			<tr>
				<td>Введіть своє ім'я</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>Введіть логін користувача</td>
				<td><input name="login"></td>
			</tr>
			<tr>
				<td>Введіть контактний телефон</td>
				<td><input name="phone"></td>
			</tr>
			<tr>
				<td>Введіть Email</td>
				<td><input name="email"></td>
			</tr>
			<tr>
				<td>Введіть пароль користувача</td>
				<td><input name="password"></td>
			</tr>	
		</table>
		<br><input type="submit" value="Реєстрація">
	</form>
-->
	<sf:form method="POST" modelAttribute="user">
		<table>
			<tr>
				<td>Введіть своє ім'я</td>
				<td><sf:input path="name"/></td>
			</tr>
			<tr>
				<td>Введіть логін користувача</td>
				<td><sf:input path="login"/></td>
			</tr>
			<tr>
				<td>Введіть контактний телефон</td>
				<td><sf:input path="phone"/></td>
			</tr>
			<tr>
				<td>Введіть Email</td>
				<td><sf:input path="email"/></td>
			</tr>
			<tr>
				<td>Введіть пароль користувача</td>
				<td><sf:input path="password"/></td>
			</tr>
			
		</table>
		<br><input type="submit" value="Реєстрація">
	</sf:form>
	</div>

</body>
</html>