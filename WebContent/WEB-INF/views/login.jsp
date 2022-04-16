<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	
<div class="container" style="color:black;  background-color: #f8f8f8; border:3px solid #EEEEEE;  margin-top: 100px; width:40%; margin-bottom: 100px;">
  <h2 style="text-align: center">Đăng nhập</h2>
  <form action="${pageContext.request.contextPath}/login" method="POST">
  
    <div class="form-group">
      <label for="username">Tên tài khoản:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter name" name="username">
    </div>
    
    <div class="form-group">
      <label for="password">Mật khẩu:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    
    <button type="submit" class="btn btn-default" style="width:100%">Đăng nhập</button>
  </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
	
<%-- 	<form action="${pageContext.request.contextPath}/login" method="POST" style = "color: black;">
			<div class="container">
				<label for="username"><b>Name</b></label>
	    			<input type="text" placeholder="Enter Username" name="username" required>
	    		<label for="passwors"><b>Password</b></label>
					<input type="password" placeholder="Enter Password" name="password" required>	
				<div>
					<button class="signupbtn" name="btn_submit" type="submit">Login</button>
				</div>	
			</div>
			
	</form> --%>

</body>
</html>