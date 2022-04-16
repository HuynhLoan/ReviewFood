<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiet mon an</title>
<style>
.bg-3 { 
    background-color: #ffffff; /* White */
    color: #555555;
   }
</style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid bg-3 text-center"> 
	<table>
	  <c:forEach items="${foods}" var="food">	
			<p style="font-weight: bold;">${food.name}</p>
			<p>Giá tiền: ${food.price} VND</p>
			<p>
			<img src="image?imageName=${food.image}"  width="400px">
			</p>
			<p style="text-align: justify;">${food.review}</p>
			<p>Địa chỉ: ${food.address}</p>
	  </c:forEach>
	</table>
	
	<div class="container-fluid">
	<div class="row content">
	 <b>Leave a Comment:</b>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      </div>
      </div>
	
<%-- 	<h1>Comment Form</h1>
	<form action="${pageContext.request.contextPath}/comment" method="POST">
		Enter Comment:<br/>
		<input type="text" name="comment" style="width:300px;height:100px" required><br/>
		Enter Email:<br/>
		<input type="text" name="email" required/><br/><br/>

		<input type="submit" value="Post Comment">
	</form>

	<c:forEach items="${comments}" var="postcomment">
		<tr>
			<td>${postcomment.comment} </td>
		</tr>
	</c:forEach> --%>
	
	
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>