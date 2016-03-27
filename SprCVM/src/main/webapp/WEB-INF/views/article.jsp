<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
	border: 1px solid black;
	border-collapse: collapse;
	margin-top: 30px;
	}
	td{
	border: 1px solid black;
	padding-left: 10px;
	padding-right: 10px;
	}
	th{
	border: 1px solid black;
	padding-left: 10px;
	padding-right: 10px;
	}
</style>
</head>
<body>
	<a href="/SprCVM/admin">На головну</a>
	<br>
	<br>
	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
		<table>
			<tr>
				<td>Виберіть країну</td>
				<td><select name="countryId">
						<c:forEach var="country" items="${countries}">
							<option value="${country.id}">${country.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть категорію</td>
				<td><select name="categoryId">
						<c:forEach var="category" items="${categories}">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть бренд</td>
				<td><select name="brandId">
						<c:forEach var="brand" items="${brands}">
							<option value="${brand.id}">${brand.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть колір</td>
				<td><select name="colorId">
						<c:forEach var="color" items="${colors}">
							<option value="${color.id}">${color.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть сезон</td>
				<td><select name="seasonId">
						<c:forEach var="season" items="${seasons}">
							<option value="${season.id}">${season.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть стиль</td>
				<td><select name="styleId">
						<c:forEach var="style" items="${styles}">
							<option value="${style.id}">${style.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Ввідіть тип</td>
				<td><select name="typeId">
						<c:forEach var="type" items="${types}">
							<option value="${type.id}">${type.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть розмір</td>
				<td><select name="sizeId">
						<c:forEach var="size" items="${sizes}">
							<option value="${size.id}">${size.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Введіть імя</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>Введіть ціну</td>
				<td><input name="price"></td>
			</tr>
			<tr>
				<td>Введіть тип матеріалу</td>
				<td><input name="top"></td>
			</tr>
		</table>
		<input type="submit" value="Додати">
		<br>
		<br>
		<br>

	</form>
	<table>
		<tr>
			<th>Назва товару</th>
			<th>Країна виробник</th>
			<th>Категорія</th>
			<th>Бренд</th>
			<th>Колір</th>
			<th>Сезон</th>
			<th>Стиль</th>
			<th>Тип</th>
			<th>Розмір</th>
			<th>Ціна</th>
			<th>Тип матеріалу</th>
		</tr>
		<c:forEach var="article" items="${articles}">
			<tr>
				<td>${article.name}</td>
				<td>${article.country.name}</td>
				<td>${article.category.name}</td>
				<td>${article.brand.name}</td>
				<td>${article.color.name}</td>
				<td>${article.season.name}</td>
				<td>${article.style.name}</td>
				<td>${article.type.name}</td>
				<td>${article.size.name}</td>
				<td>${article.price}</td>
				<td>${article.top}</td>
				<td><c:url value="/article/${article.id}" var="url" /><a
					href="${url}">delete</a></td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>