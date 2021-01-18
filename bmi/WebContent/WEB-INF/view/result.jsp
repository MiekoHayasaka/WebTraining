<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BMI結果</h1>
<p>
身長:${health.height }<br>
体重:${health.weight }<br>
BMI:${health.bmi }<br>
体形:${health.bodyType }
</p>
<a href="/bmi/Main">戻る</a>
</body>
</html>