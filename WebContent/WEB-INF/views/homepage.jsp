<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
  .bg-1 { 
    background-color: #1abc9c; /* Green */
    color: #ffffff;
  }
</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid bg-1 text-center">
  <h3 class="margin">Who Am I?</h3>
  <img src="https://iamafoodblog.b-cdn.net/wp-content/uploads/2019/02/japanese-fluffy-pancakes-recipe-7077w-2-1024x683.jpg" class="img-responsive img-circle margin" style="display:inline" width="350" height="350">
  <h3>I am a food blog</h3>
</div>	

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>