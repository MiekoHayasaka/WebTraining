<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
Room room=(Room)request.getAttribute("room");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<p>やるべきタスクを入力してください。<br>
（例）キッチン　⇒　床掃除、シンク、コンロ回り、レンジ、など</p>
<form action="/CleanUp/CreateTask" method="post">
<%--
掃除する場所：<%=room.getName() %><br>
<input type="hidden" name="id" value="<%=room.getId() %>"><br>
やるべきタスク：<input type="text" name="name" size=30 placeholder="タスクの入力">
周期：<select name="day">
<% for(int i=1;i<=31;i++){ %>
<option value="<%= i %>"><%= i %></option>
<%} %>
</select>
--%>
<select name="period">
<option value="日">日</option>
<option value="週">週</option>
<option value="ケ月">ケ月</option>
<option value="年">年</option>
</select>
<button type="submit">登録</button>
</form>
</body>
</html>