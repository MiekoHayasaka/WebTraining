<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,model.*"%>
<%
	List<Room> list = (List<Room>)request.getAttribute("list");
	Room room=(Room)request.getAttribute("room");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<p>１．メニューから場所を選択、または、テキストボックスに掃除エリアを入力してください。</p>
<form action="/CleanUp/Create" method="post">
掃除する場所：<select name="name">
<option value=""></option>
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

<p>２．登録した場所で行うタスクを追加し、設定を行ってください。<br>
(例)バスルーム ⇒ 洗面台磨き、１週間毎など</p>
<form action="/CleanUp/CreateTask" method="post">
<% if(list != null && list.size() > 0){ %>
<table>
<%for(Room r:list){ %>
<tr>
<td>●<%=r.getName() %></td>
<td><input type="text" name="name" size=30 placeholder="タスクの入力"></td>
<td><input type="number" name="day" placeholder="数字"></td>
<td><select name="period">
<option value="日">日</option>
<option value="週">週</option>
<option value="月">カ月</option>
<option value="年">年</option>
</select>毎</td>
<td><input type="hidden" name="room_id" value="<%=r.getId() %>"></td>
<td><button type="submit">タスク登録</button></td>
</td>
</tr>
<%} %>
</table>
<%} %>
</form>
</body>
</html>