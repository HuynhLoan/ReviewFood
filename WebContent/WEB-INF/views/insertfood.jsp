<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Food</title>
</head>
<body>
<div class="container-fluid">
  <div class="row content">
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="col-sm-9">
	<h3>Thêm sản phẩm</h3>
	<hr>
	
	<div class="container" style="width:70%;">

  		<form class="form-horizontal" action="${pageContext.request.contextPath}/insertFood" method="POST" enctype="multipart/form-data">
    		<div class="form-group">
      			<label class="col-sm-2 control-label">Tên món:</label>
      			<div class="col-sm-10">
        			<input class="form-control" name="name" id="focusedInput" type="text">
      			</div>
    		</div>
    
    		<div class="form-group">
      			<label class="col-sm-2 control-label">Giá tiền:</label>
      			<div class="col-sm-10">
        			<input class="form-control" name="price" id="focusedInput" type="number">
      			</div>
    		</div>
    
   			<div class="form-group">
      			<label class="col-sm-2 control-label">Giới thiệu:</label>
      			<div class="col-sm-10">
        			<input class="form-control" name="review" id="focusedInput" type="text">
      			</div>
    		</div>
    
    		<div class="form-group">
    		  	<label class="col-sm-2 control-label">Danh mục:</label>
      			<div class="col-sm-10">
        			<input class="form-control" name="categoryid" id="focusedInput" type="number">
      			</div>
    		</div>
    
    		<div class="form-group">
      			<label class="col-sm-2 control-label">Địa chỉ:</label>
      			<div class="col-sm-10">
        			<input class="form-control" name="address" id="focusedInput" type="text">
      			</div>
    		</div>
    
    		<div class="form-group">
      			<label class="col-sm-2 control-label">Hình ảnh:</label>
      			<div class="col-sm-10">
       				<input name="image" type="file">
      			</div>
    		</div>
    
    		<input type="submit" value="Thêm" class="btn btn-default" style="margin-left: 120px">
    
  </form>
</div>
	
		
		</div>
	</div>
</div>
<footer class="container-fluid">
  	<p style="text-align: center">Footer Text</p>
</footer>
</body>
</html>