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
<p><%=h.getRace() %>のボーナスが適用されました!</p>
<p><%=h %></p>
<form action="/selfapp/Third" method="post">
職業を選んでください
<input type="radio" name="cls" value="0">戦士
<input type="radio" name="cls" value="1">盗賊
<input type="radio" name="cls" value="2">僧侶
<input type="radio" name="cls" value="3">魔術師
<input type="hidden" name="name" value="<%=h.getName() %>">
<input type="hidden" name="race" value="<%=h.getRace() %>">
<input type="hidden" name="hp" value="<%=h.getHp() %>">
<input type="hidden" name="mp" value="<%=h.getMp() %>">
<input type="hidden" name="power" value="<%=h.getPower() %>">
<input type="hidden" name="dex" value="<%=h.getDex() %>">
<input type="hidden" name="agi" value="<%=h.getAgi() %>">
<button type="submit">送信</button>
</form>
</body>
</html>