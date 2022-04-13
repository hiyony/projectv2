<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Button</title>
</head>
<body>
	<h1>Omikuji Web Service</h1>
	<h4>~ Select button that you want to check ~</h4>
	
	<br><input type = "button" value = "過去半年の結果リスト" onclick = "location.href = '/struts/OmkjHalfresult.jsp'"/>
	<br><input type = "button" value = "占い結果の割合" onclick = "location.href = '/struts/OmkjPercent.jsp'"/>
</body>
</html>