<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
</head>
<body>
<p>メニューから場所を選択、または、テキストボックスに場所を入力してください。</p>
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
<button type="submit">登録</button>
</form>
</body>
</html>