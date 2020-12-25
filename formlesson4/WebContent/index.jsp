<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String[] names={"足立","石川","宇佐美","大野"};
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>
<% for(String name:names){ %>
<li><%=name %></li>
<%} %>
</ol>
</body>
</html>