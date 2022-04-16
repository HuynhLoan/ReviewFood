<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách món ăn</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'></c:url>">
<style>
	.bg-3 { 
    background-color: #ffffff; /* White */
    color: #555555;
  }
  
</style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	   
<form action="searchFood" method="POST" style="margin-left:850px; margin-top:10px">
	<input type="text" name="textSearch" style="color:black;">
	<input type="submit" value="Search" style="color:black;">
</form>
	 
<div class="container-fluid bg-3 text-center">    
  <h3 class="margin">Ở đây có món ngon!!!</h3><br>
  <div class="row">
    
      <c:forEach items="${foods}" var="food">
      <div class="col-sm-4">
			<p><img src="image?imageName=${food.image}" width="300px"></p>
			<a href="getFoodById?id=${food.id}" style="text-decoration: none">${food.name}</a>
			<p>Giá tiền: ${food.price} VND</p>
	  	</div>
	  </c:forEach>
    
    
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>