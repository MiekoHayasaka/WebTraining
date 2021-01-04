<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] results={
		"活動的な日。美術館・映画館などが吉",
		"習い事、新しいことを始めるとよい。",
		"ゆっくりお風呂に入るのがよい。",
		"身の回りをスッキリさせる。水場が吉",
    };
    String[] colors={"class='red'","class='blue'","class='green'","class='yellow'"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="css/main.css">
<title>カラー占い</title>
</head>
<body>
<% if (request.getParameter("btn") == null){ %>
<form method="post">
  <p>好きな色を選んでね</p>
<br>
<label class="red"><input type="radio" name="color" value="0" checked>赤</label>
<label class="blue"><input type="radio" name="color" value="1">青</label>
<label class="green"><input type="radio" name="color" value="2">緑</label>
<label class="yellow"><input type="radio" name="color" value="3">黄色</label><br><br>
<p align="center"><input type="submit" name="btn" value="送信"></p>
</form>
<%}else{ %>
	<%
	String index=request.getParameter("color");
	%>
<p <%=colors[Integer.parseInt(index)] %>><%=results[Integer.parseInt(index)] %></p>
<br><br>
<a href="/colorapp/">戻る</a>
<%} %>
</body>
</html>