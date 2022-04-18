<%@ page import = "omikuji.ResultForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
<style>
	body {
		text-align : center;
	}
	#list {
		display : flex;
		justify-content : center;
	}
</style>
</head>
<body>
	<h1>今日の運勢はどうですか？</h1>
	今日の運勢は「<%= ResultForm.getUnsei() %>」です!
	<div id = "list">
		<ul>
			<li>願い事 : <%= ResultForm.getNegaigoto() %> </li>
			<li>商い : <%= ResultForm.getAkinai() %> </li>
			<li>学問 : <%= ResultForm.getGakumon() %> </li>
		</ul>
	</div>
	<br><input type = "button" value = "戻る" onclick = "location.href = '/struts/OmkjInput.jsp'">
</body>
</html>