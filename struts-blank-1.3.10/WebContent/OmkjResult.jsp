<%@ page import = "omikuji.ResultForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
</head>
<body>
	<h1>今日の運勢はどうですか？</h1>
	<p>
		今日の運勢は <%= ResultForm.getUnsei() %>　です!
		<br>願い事 : <%= ResultForm.getNegaigoto() %> 
		<br>商い : <%= ResultForm.getAkinai() %>
		<br>学問 : <%= ResultForm.getGakumon() %>
		<br><input type = "button" value = "戻る" onclick = "location.href = '/struts/OmkjInput.jsp'">
		<br><input type = "button" value = "結果をもっと見る.." onclick = "location.href = '/struts/SelectView.jsp'"/>
	</p>
</body>
</html>