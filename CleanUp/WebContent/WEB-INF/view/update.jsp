<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Room room=(Room)request.getAttribute("room");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<form action="/CleanUp/Update" method="post">
掃除する場所:<input type="text" name="name" value="<%=room.getName() %>"><br>
<input type="hidden" name="id" value="<%=room.getId() %>"><br>
<button type="submit">更新</button>
</form>
</body>
</html>