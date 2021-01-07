<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*,model.*"%>
<%
	List<Person> list=(List<Person>)application.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>名簿</title>
</head>
<body>
<div class="container">
<table class="table table-striped table-bordered table-dark">
<% for(Person p:list){ %>
<tr>
<td><%=p.getName() %></td>
<td><%=p.getKana() %></td>
<td><%=p.getGender() %></td>
<td><%=p.getBlood() %></td>
</tr>
<%} %>
</table>
</div>
</body>
</html>