<%@ page import = "omikuji.InputForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
<style>
	#input-form input{
		padding : 5px 10px;
		text-align : center;
	}
	p{
		color : red;
	}
</style>
</head>
<body>
	<%! String msg; %>
	<% request.getAttribute("msg"); %>
	
	<h1>Omikuji Web Service</h1>
	<form action = "<%= request.getContextPath()%>omkjinput" method = "POST" id = "input-form">
		<span>お誕生日を入力してください！</span>
		<input type = "text" name = "birthday" placeholder = "yyyyMMddの形式" />
		<input type = "submit" value = "確認" />
		<p><%= msg %></p>
	</form>
</body>
</html>
