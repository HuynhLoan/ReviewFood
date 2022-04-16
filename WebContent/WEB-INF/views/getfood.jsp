<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get All Food</title>
</head>
	
<body>
<jsp:include page="header.jsp"></jsp:include>

	<table>
	  <tr>
		<th>Id</th>
		<th>Image</th>
		<th>Name</th>
		<th>Price</th>
		<th>Review</th>
		<th>Categoryid</th>
		<th>Address</th>
		
	  </tr>
	  <c:forEach items="${foods}" var="food">
	  	<tr>
			<td>${food.id}</td>
			<td>
			<img src="image?imageName=${food.image}" width="100px">
			</td>
			<td>${food.name}</td>
			<td>${food.price}</td>
			<td>${food.review}</td>
			<td>${food.categoryid}</td>
			<td>${food.address}</td>
	  	</tr>
	  </c:forEach>
	</table>
</body>
</html>