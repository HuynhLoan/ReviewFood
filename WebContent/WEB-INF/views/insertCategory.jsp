<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Category</title>
</head>
<body>
<div class="container-fluid">
  <div class="row content">
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="col-sm-9">
	<h3>Thêm sản phẩm</h3>
	<hr>
	
	<div class="container" style="width:80%;">
	
		<form class="form-horizontal" action="${pageContext.request.contextPath}/insertCategory" method="POST">
			<div class="form-group">
      			<label class="col-sm-2 control-label">Tên danh muc:</label>
      			<div class="col-sm-10">
        			<input class="form-control" name="categoryname" id="focusedInput" type="text">
      			</div>
    		</div>
    		
    		<input type="submit" value="Thêm" class="btn btn-default" style="margin-left: 130px">
    		
		</form>
		
    </div>
   </div>
  </div>
</div>
</body>
</html>