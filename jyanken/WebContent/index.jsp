<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] pict={"gu.png","choki.png","pa.png"};
String[] handNames={"ぐー","ちょき","ぱー"};
String[] results={"あいこ","アナタのまけです...","アナタのかちです！"};
String hand=request.getParameter("hand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
<title>じゃんけんぽん</title>
</head>
<body>
<form method="post">
	<% for(int i=0;i<handNames.length;i++){ %>
		<input type="radio" name="hand" value="<%=i%>"><%=handNames[i] %><br>
	<%} %>
	<button type="submit">ショウブ</button>
</form>
<%if(hand != null){ %>
	<%
	int userHand=Integer.parseInt(hand);
	int pcHand=(int)(Math.random()*3);
	%>
	<div>
		<img src="images/<%=pict[userHand]%>">
		<img src="images/<%=pict[pcHand]%>">
	</div>
	<p><%=results[(userHand+3 -pcHand)%3] %></p>
<%} %>
</body>
</html>