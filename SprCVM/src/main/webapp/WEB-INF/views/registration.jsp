<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form method="post">
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
				<td><input type="password" name="password"></td>
			</tr>	
		</table>
		<br><input type="submit" value="Реєстрація">
	</form>
	</div>

</body>
</html>