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
	<form action = "<%= request.getContextPath() %>/HalfResult.do" method = "POST">
		<br><input type = "submit" value = "過去半年の結果リスト" />
	</form>
	<!-- <form>
		<br><input type = "submit" value = "占い結果の割合" onclick = "location.href = '/struts/OmkjPercent.jsp'"/>
	</form> -->
</body>
</html>