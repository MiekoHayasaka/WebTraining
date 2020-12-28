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
<p>初期ステータスが決定しました</p>
<p><%=h %></p>
<form action="/selfapp/Second" method="post">
種族を選んでください
<input type="radio" name="race" value="0">人間
<input type="radio" name="race" value="1">ハイエルフ
<input type="radio" name="race" value="2">トロル
<input type="radio" name="race" value="3">ノーム
<input type="hidden" name="name" value="<%=h.getName() %>">
<input type="hidden" name="hp" value="<%=h.getHp() %>">
<input type="hidden" name="mp" value="<%=h.getMp() %>">
<input type="hidden" name="power" value="<%=h.getPower() %>">
<input type="hidden" name="dex" value="<%=h.getDex() %>">
<input type="hidden" name="agi" value="<%=h.getAgi() %>">
<button type="submit">送信</button>
</form>
</body>
</html>