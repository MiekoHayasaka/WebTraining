<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,model.*"%>
<%
	List<Room> list = (List<Room>)request.getAttribute("list");
	Date udate=new Date();
	java.sql.Date updated = new java.sql.Date(udate.getTime());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
  <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
  <div class="container">
  <div id="right">
		<a href="login.jsp">ログイン</a>
		<a href="signup.jsp">新規登録</a>
		</div>
    <header>
      <h1>キレイなお家</h1>
    </header>
    <nav>
        <a href="index.jsp">つかい方</a>
        <a href="/CleanUp/Create">おそうじ登録</a>
        <a href="">一覧表示</a>
        <a href="">完了・編集</a>
        <a href="">過去の記録</a>
    </nav>
    <div role="main">
<h2>掃除場所登録</h2>
<form action="/CleanUp/Create" method="post">
<table class="form-table">
<tr>
<th>掃除場所の入力</th>
<td>
<input type="text" name="name" list="room">
<datalist id="room">
<option value="リビング">リビング</option>
<option value="ダイニング">ダイニング</option>
<option value="キッチン">キッチン</option>
<option value="寝室">寝室</option>
<option value="バスルール">バスルーム</option>
<option value="トイレ">トイレ</option>
<option value="玄関">玄関</option>
<option value="ベランダ">ベランダ</option>
</datalist>
</td></tr>
<tr><td></td><td><button type="submit">部屋・エリア登録</button></td></tr>
</table>
</form>

<h2>タスク登録</h2>
<% if(list != null && list.size() > 0){ %>
<table class="list-table">

<tr><th>掃除場所</th><th>タスクの追加</th><th>掃除間隔</th><th>最後に掃除した日</th><th></th></tr>

<%for(Room r:list){ %>
<form action="/CleanUp/CreateTask" method="post">
<input type="hidden" name="room_id" value="<%=r.getId() %>">
<input type="hidden" name="rname" value="<%=r.getName() %>">
<tr>
<td><a href="/CleanUp/CreateTask?room_id=<%=r.getId()%>&rname=<%=r.getName()%>">
<%=r.getName() %></a></td>
<td><input type="text" name="name" size=30 placeholder="例：床掃除"></td>
<td><input type="number" name="day" min="1" max="31" placeholder="日数">
<select name="period">
<option value="日">日</option>
<option value="週">週</option>
<option value="ケ月">ケ月</option>
<option value="年">年</option>
</select>毎</td>
<td><input type="date" name="updated" value="<%=updated%>"></td>
<td><button type="submit">登録</button></td>
</tr>
</form>
<%} %>

</table>
<%} %>
</div>
    <footer>
      &copy;CleanUpProject
    </footer>
  </div>
</body>
</html>