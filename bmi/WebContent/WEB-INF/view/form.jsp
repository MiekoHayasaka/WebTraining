<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bmi/Main" method="post">
身長：<input type="text" name="height" step="0.1"required>(cm)<br>
体重：<input type="text" name="weight" step="0.1"required>(kg)<br>
<input type="submit" value="計算">
</form>
</body>
</html>