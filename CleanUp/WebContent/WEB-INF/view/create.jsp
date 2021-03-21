<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,model.*"%>
<%
	List<Room> list = (List<Room>)request.getAttribute("list");
	//Room room=(Room)request.getAttribute("room");
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
<p>セレクトメニューから場所を選択、または、テキストボックスに掃除エリアを入力してください。</p>
<form action="/CleanUp/Create" method="post">
お掃除場所：<select name="name">
<option value="">選択してください</option>
<option value="リビング">リビング</option>
<option value="ダイニング">ダイニング</option>
<option value="キッチン">キッチン</option>
<option value="寝室">寝室</option>
<option value="バスルール">バスルール</option>
<option value="トイレ">トイレ</option>
<option value="玄関">玄関</option>
<option value="ベランダ">ベランダ</option>
</select>
<input type="text" name="name" size=30 placeholder="セレクトメニューにない場所の入力">
<button type="submit">部屋・エリア登録</button>
</form>

<hr>
<% if(list != null && list.size() > 0){ %>
<table>
<thead>
<tr><th>お掃除場所</th><th>タスクの追加</th></tr>
</thead>
<tbody>
<%for(Room r:list){ %>
<form action="/CleanUp/CreateTask" method="post">
<input type="hidden" name="room_id" value="<%=r.getId() %>">
<input type="hidden" name="rname" value="<%=r.getName() %>">
<tr>
<td><a href="/CleanUp/CreateTask?room_id=<%=r.getId()%>&rname=<%=r.getName()%>">
<%=r.getName() %></a></td>
<td><input type="text" name="name" size=30 placeholder="タスクの入力">
<input type="number" name="day" placeholder="数字">
<select name="period">
<option value="日">日</option>
<option value="週">週</option>
<option value="カ月">カ月</option>
<option value="年">年</option>
</select>毎
<button type="submit">登録</button></td>
</tr>
</form>
<%} %>
</tbody>
</table>
<%} %>
</div>
    <footer>
      &copy;CleanUpProject
    </footer>
  </div>
</body>
</html>