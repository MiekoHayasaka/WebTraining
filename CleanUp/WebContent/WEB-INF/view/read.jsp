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
<h3>【 場所：<%=room.getName() %> 】</h3>
<form action="/CleanUp/CreateTask" method="post">
<input type="hidden" name="room_id" value="<%=room.getId() %>">
<input type="hidden" name="rname" value="<%=room.getName() %>">
<input type="text" name="name" size=30 placeholder="タスクの入力">
<input type="number" name="day" min="1" max="31" placeholder="日数">
<select name="period">
<option value="日">日</option>
<option value="週">週</option>
<option value="カ月">カ月</option>
<option value="年">年</option>
</select>毎
<button type="submit">タスク登録</button>
</form>
<hr>
<h3>今の状態</h3>
<% if(list != null && list.size() > 0){ %>
<table>
<thead>
<tr><th>タスク名</th><th>掃除の間隔</th><th>予定日まであと</th><th>掃除完了</th><th>更新</th><th>削除</th></tr>
</thead>
<tbody>
<%for(Task t:list){ %>
<form action="/CleanUp/Complete" method="post">
<input type="hidden" name="status" value="<%=t.getStatus()%>">
<input type="hidden" name="id" value="<%=t.getId()%>">
<input type="hidden" name="room_id" value="<%=room.getId()%>">
<tr><td><%=t.getName() %></td>
<td><%=t.getDay() %> <%=t.getPeriod() %>毎</td>
<td><%=t.getStatus()%>日</td>
<td><button type="submit">完了！</button></td>
</form>
<td><a href="/CleanUp/Update?id=<%=t.getId() %>&room_id=<%=room.getId()%>">更新</a></td>
<td><a href="/CleanUp/Delete?id=<%=t.getId() %>&room_id=<%=room.getId()%>&rname=<%=room.getName()%>" onclick="return confirm('[<%=t.getName()%>]を削除してよろしいですか？');">削除</a>
</td>
</tr>
<%} %>
</tbody>
</table>
<%}else{ %>
<p>まだタスクの登録はされていません</p>
<%} %>
</div>
    <footer>
      &copy;CleanUpProject
    </footer>
  </div>
</body>
</html>