<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Room room=(Room)request.getAttribute("room");
Task task=(Task)request.getAttribute("task");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<a href="/CleanUp/CreateTask?room_id=<%=room.getId()%>&rname=<%=room.getName()%>">タスク一覧</a><br>
<p>タスクの更新を行います。</p>
<form action="/CleanUp/Update" method="post">
<p>【 場所： <%=room.getName() %> 】</p>
タスク名:<input type="text" name="name" value="<%=task.getName() %>">
<input type="number" name="day" value="<%=task.getDay() %>">
<select name="period">
<% switch(task.getPeriod()){
case "日":%>
<option value="日" selected>日</option>
<option value="週">週</option>
<option value="ケ月">ケ月</option>
<option value="年">年</option>
<% break;
case "週": %>
<option value="日">日</option>
<option value="週" selected>週</option>
<option value="ケ月">ケ月</option>
<option value="年">年</option>
<% break;
case "ケ月": %>
<option value="日">日</option>
<option value="週">週</option>
<option value="ケ月" selected>カ月</option>
<option value="年">年</option>
<% break;
case "年": %>
<option value="日">日</option>
<option value="週">週</option>
<option value="ケ月">カ月</option>
<option value="年" selected>年</option>
<% break;}%>
</select>毎
<input type="hidden" name="id" value="<%=task.getId() %>">
<input type="hidden" name="updated" value="<%=task.getUpdated() %>">
<input type="hidden" name="status" value="<%=task.getStatus() %>">
<input type="hidden" name="room_id" value="<%=room.getId() %>">
<input type="hidden" name="rname" value="<%=room.getName() %>">
<button type="submit">更新</button>
</form>
</body>
</html>