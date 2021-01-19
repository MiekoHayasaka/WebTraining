<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
.container{
padding-top:20px;
padding-bottom:60px;
}
td>img,.sampleImg{
width:200px;
}
input.form-control{
	width:500px;
}
table.table{
	width:70%;
}
.alert{
	width:46%;
}
</style>
</head>
<body>
<div class="container">
<form action="/donutshop/Admin/Update" method="Post" enctype="multipart/form-data">
<div class="form-group">
<label for="name">商品名</label>
<input type="text" name="name" id="name" class="form-control" value="${donut.name}" required>
</div>
<div class="form-group">
<label for="price">価格</label>
<input type="number" name="price" id="price" class="form-control" step="10" value="${donut.price}" required>
</div>
<img class="sampleImg" src="/donutshop/upload/${donut.imgname}"><br>
<div class="form-group">
<label for="imgname">商品画像</label>
<input type="file" name="imgname" class="form-control" id="imgname">
</div>
<input type="hidden" name="id" value="${donut.id}">
<input type="hidden" name="orgname" value="${donut.imgname}">
<button type="submit" class="btn btn-primary">更新</button>
</form>
</div>
</body>
</html>