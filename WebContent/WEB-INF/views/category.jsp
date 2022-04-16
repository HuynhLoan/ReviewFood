<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
</head>
<body>
<div class="container-fluid">
  <div class="row content">
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="col-sm-9">
	<h3>Quản lý danh mục</h3>
	<hr>
	<a href="insertCategory">
		<button data-toggle="modal" class="pull-right btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Thêm</button>
	</a>
	<div style="margin-top:10px;">
		<table class="table table-striped table-bordered">
			<thead>
				<th>ID</th>
				<th>Tên danh muc</th>
				<th>Tùy chọn</th>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
	  				<tr>
						<td>${category.id}</td>
						<td>${category.categoryname}</td>
						<td>
							<a href="updateCategory?id=${category.id}" data-toggle="modal" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-pencil"></span> Edit </a> ||
							<a href="deleteCategory?id=${category.id}" data-toggle="modal" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span> Delete </a>
						</td>
	  				</tr>
	  			</c:forEach>
		    </tbody>
	    </table>
	  </div>
	</div>
  </div>
</div>
<footer class="container-fluid">
  	<p style="text-align: center">Footer Text</p>
</footer>
</body>
</html>