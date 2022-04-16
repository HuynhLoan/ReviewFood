<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'></c:url>">
  <style>
  body {
    font: 20px Montserrat, sans-serif;
    line-height: 1.8;
    color: #f5f6f7;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}

  .container-fluid {
    padding-top: 70px;
    padding-bottom: 70px;
  }
  .navbar {
    padding-top: 15px;
    padding-bottom: 15px;
    border: 0;
    border-radius: 0;
    margin-bottom: 0;
    font-size: 15px;
    letter-spacing: 2px;
  }
  .navbar-nav  li a:hover {
    color: #1abc9c !important;
  }
  </style>
</head>

<body class="header">

<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="homeServlet">HealthFood</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    	
      <ul class="nav navbar-nav navbar-right">
      		<li class="dropdown">
		  	<button class="navbar navbar-default" name="category" type="button" data-toggle="dropdown" style="margin-top:2px; color:#c8a97e;; padding-top: 10px;">Danh mục</button>
		  	<ul class="dropdown-menu">
		  		<c:forEach items="${categories}" var="category">
		  			<li><a class="dropdown-item" href="getFoodByCategory?id=${category.id}">${category.categoryname}</a></li>
		  			<%-- <button class="dropdown-item" value="${category.categoryname}" >${category.categoryname }</button> --%>
		  		</c:forEach>
		  	 
		  	 </ul>
		  </li>
		  
		  <li><a href="indexAdmin">Admin</a></li>
		  
        <c:if test="${empty sessionScope.username}">
			<li><a href="login">Đăng nhập</a></li>
		</c:if>
        
        
        <li><a href="register">Đăng ký</a></li>
      
        <c:if test="${not empty sessionScope.username}">
			<li><a href="logout">Đăng xuất</a></li>
			<li><p style="color:red; padding: 10px 15px;">Hello ${sessionScope.username}</p></li>
			
		</c:if>
      </ul>
     
    
    </div>
     
  </div>
</nav>


</body>
</html>