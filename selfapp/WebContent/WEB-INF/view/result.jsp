<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Hero"%>
<%
   Hero h=(Hero)request.getAttribute("hero");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介APP</title>
</head>
<body>
<p><%=h.getCls() %>のボーナスが適用されました!</p>
<p><%=h %></p>
<p>***作戦成功***</p>
<p>私は<%=h.getCls() %> の<%=h.getRace() %>、<%=h.getName() %>です。</p>
<p>能力値(<%=h.getTotal() %>)を高い順に並べると<p>
<ol>
<%for(String line:h.getOrdered()){ %>
<li><%=line %></li>
<%} %>
</ol>
<p>です。今後ともよろしく...</p>
</body>
</html>