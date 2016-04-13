<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="resources/css/bootstrap.min.css" var="bootstrap"/>
 <link href="${bootstrap}" rel="stylesheet"/>
<c:url value="resources/js/bootstrap.min.js" var="bootsScript"/>
<script type="text/javascript" src="${bootsScript}"><jsp:text/></script>
<style type="text/css">
.main{
	width:90%;
	height:800px;
	border: 1px solid black;
	padding:10px;
	margin:auto;
	
}
.inp{
	width:40%;
	height:200px;
	border: 1px solid black;
	float:left;
	margin:5px;
	padding:5px;
}
.logo{
	height:100%;
	width:49%;
	border: 1px solid black;
	float:left;
}
img{
	width:100%;
}
.descr{
	height:100%;
	width:49%;
	border: 1px solid black;
	float:left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello it is a main page</h2>
	<div class="main">
			<c:forEach var="article" items="${articles}">
				<div class="inp">
					<div class="logo">
							<img src="${article.imageUrl}"></img>
					</div>
					<div class="descr">	
						${article.name}
						${article.price}
					</div>	
				</div>
			</c:forEach>

	</div>

</body>
</html>