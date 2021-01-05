<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Num" %>
<%
    Num num=(Num) request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数字アプリ</title>
</head>
<body>
<p>元の文字列：<%= num.getSnum() %></p>
<p>要素数：<%= num.getCount() %></p>
<p>最大値：<%= num.getMax() %></p>
<p>最小値：<%= num.getMin() %></p>
<p>合計：<%= num.getSum() %></p>
<a href="/numapp2/Main">戻る</a>
</body>
</html>