<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteEV" %>
<%
SiteEV siteEV = (SiteEV)application.getAttribute("siteEV");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>湊君のページ</title>
</head>
<body>
<h1>湊君のページへようこそ</h1>
<p>
<a href="/applicationLesson/MinatoIndex?action=like">よいね</a>
<%= siteEV.getLike() %>人
<a href="/applicationLesson/MinatoIndex?action=dislike">よくないね</a>
<%= siteEV.getDislike() %>人
</p>
<h2>湊君とは！？</h2>
<p>．．．</p>
</body>
</html>