<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div.header {
	font-family: Lucida, sans-serif;
	width: 100%;
	height: 50px;
	background: #ffc926;
}

div.header_left {
	float: left;
	width: 90%;
	height: 100%;
}

div.header_right {
	float: left;
	width: 9%;
	height: 100%;
	border-left: 3px solid #ff8000
}

div.header_right>a {
	margin-left: 10px;
	display: inline-block;
	margin-top: 16px;
	color: #525548;
}

.header_left_menu>li {
	display: inline-block;
	margin-left: 10px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="header_left">
			<ul class="header_left_menu">
				<li><a href="/SprCVM/admin/article">Товар</a></li>
				<li><a href="country">Країна</a></li>
				<li><a href="color">Колір</a></li>
				<li><a href="brand">Бренд</a></li>
				<li><a href="category">Категорія</a></li>
				<li><a href="season">Сезон</a></li>
				<li><a href="style">Стиль</a></li>
				<li><a href="/SprCVM/admin/type">Тип</a></li>
				<li><a href="size">Розмір</a></li>
			</ul>
		</div>
		<div class="header_right">
			
			<sec:authorize access="isAuthenticated()">
				<a href="#">${user.login}</a>
				<a href="<c:url value="/logout"/>">Вийти</a>
			</sec:authorize>
		</div>
	</div>
</body>
</html>