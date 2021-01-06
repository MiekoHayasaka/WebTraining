<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.InchToCm"%>
<%
	InchToCm num=(InchToCm)request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%=num.getInch() %>inchは<%=num.getCm() %>cmです。</p>
<a href="/mvcLesson/Main">戻る</a>
</body>
</html>