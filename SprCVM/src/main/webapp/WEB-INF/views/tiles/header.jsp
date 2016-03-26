<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
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
	width: 85%;
	height: 100%;
}

div.header_right {
	float: left;
	width: 15%;
	height: 100%;
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
		<div class="header_left"></div>
		<div class="header_right">
			<a href="#"><i class="fa fa-truck"></i>Корзина</a> <a href="login">Увійти</a>
		</div>
	</div>
</body>
</html>