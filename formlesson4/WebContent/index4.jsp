<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (request.getParameter("btn") == null){ %>
<form>
<p>お使いのOSを選んでください</p>
<input type="checkbox" name="os" value="win">Win
<input type="checkbox" name="os" value="mac">Mac
<input type="checkbox" name="os" value="linux">Linux
<input type="submit" name="btn" value="送信">
</form>
<%}else{
	String[] oss=request.getParameterValues("os");
	String result=oss==null ? "[選択なし]":String.join(",",oss);
%>
<p><%=result %></p>
<%} %>
</body>
</html>