<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
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
	width: 82%;
	height: 100%;
	text-align: center;
}

div.header_right {
	float: left;
	width: 18%;
	height: 100%;
	margin: auto;
}

div.header_right>a {
	margin-left: 10px;
	display: inline-block;
	margin-top: 16px;
	color: #525548;
}
</style>
</head>
<body>
	<div class="header">
		<div class="header_left">
			<a href="#">Чоловіче взуття</a>
			<a href="#">Жіноче взуття</a>

		</div>
		<div class="header_right">
			<a href="#"><i class="fa fa-truck"></i>Корзина</a> 
			<a href="login">Увійти</a>
			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value="/logout"/>">Вийти</a>
			</sec:authorize>
		</div>
	</div>
</body>
</html>