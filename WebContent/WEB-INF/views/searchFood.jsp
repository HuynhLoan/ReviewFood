<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="searchFood" method="POST" style="margin-left:850px; margin-top:10px">
	<input type="text" name="textSearch" style="color:black;">
	<input type="submit" value="Search" style="color:black;">
</form>
	<c:if test="${not empty foods}">
	<h4>Size = ${books.size()}</h4>
		<div class="container-fluid bg-3 text-center">    
  			<h3 class="margin">Ở đây có món ngon!!!</h3><br>
  				<div class="row">
      				<c:forEach items="${foods}" var="food">
      					<div class="col-sm-4">
							<p><img src="image?imageName=${food.image}" width="250px"></p>
							<a href="getFoodById?id=${food.id}" style="text-decoration: none">${food.name}</a>
							<p>Giá tiền: ${food.price} VND</p>
	  					</div>
	  				</c:forEach>
  				</div>
		</div>
	</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>