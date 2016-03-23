<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.registr {
	width:350px;
	padding: 20px;
	border: solid 1px black;
	text-align: center;
	margin: auto;
	margin-top: 90px;
	}
</style>
</head>
<body>
	<div class = "registr">
		<form action="?${_csrf.parameterName}=${_csrf.token}" method="post">
			<label>Введіть логін</label>
			<input name="username"><br><br>
			<label>Введіть пароль</label>
			<input type="password" name="password"><br><br>
			<input type="submit" value="Вхід">
		</form>
	</div>

</body>
</html>