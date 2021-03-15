<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
    <%
	List<Room> list = (List<Room>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<a href="/CleanUp/Create">新規</a>
<% if(list != null && list.size() > 0){ %>
<table>
<%for(Room r:list){ %>
<tr>
<td>●<%=r.getName() %></td>
<td><a href="/CleanUp/Update?id=<%=r.getId() %>">更新</a>
<a href="/CleanUp/Delete?id=<%=r.getId() %>" onclick="return confirm('[<%=r.getName()%>]を削除してよろしいですか？');">削除</a>
</td>
</tr>
<%} %>
</table>
<%}else{ %>
<p>まだ場所の登録はされていません</p>
<%} %>
</body>
</html>