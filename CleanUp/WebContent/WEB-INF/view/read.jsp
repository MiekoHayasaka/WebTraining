<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<%
	List<Task> list = (List<Task>)request.getAttribute("list");
	Room room=(Room)request.getAttribute("room");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<a href="/CleanUp/Create">新規</a>
<p><%=room.getName() %></p>
<% if(list != null && list.size() > 0){ %>
<table>
<%for(Task t:list){ %>
<tr>
<td>●<%=t.getName() %></td>
<td><%=t.getDay() %></td>
<td><%=t.getPeriod() %>毎</td>
<td><a href="/CleanUp/Update?id=<%=t.getId() %>">更新</a>
<a href="/CleanUp/Delete?id=<%=t.getId() %>" onclick="return confirm('[<%=t.getName()%>]を削除してよろしいですか？');">削除</a>
</td>
</tr>
<%} %>
</table>
<%}else{ %>
<p>まだタスクの登録はされていません</p>
<%} %>
</body>
</html>