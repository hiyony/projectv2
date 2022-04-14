<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="omikuji.PercentForm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
</head>
<body>
	<%
		PercentForm pform = new PercentForm();
		ResultSet rs = (ResultSet) request.getAttribute("result"); 
	%>
	<h1>Omikuji Web Service</h1>
	<h4>~ 半年前からの運勢結果割合 ~</h4>
	<br>
	<table>
		<tr>
			<td>birthday</td>
			<td>unseiname</td>
			<td>count</td>
		</tr>
		<% while(rs.next()){ %>
		<tr>
			<td><%= pform.getBirthday() %></td>
			<td><%= pform.getUnseiname() %></td>
			<td><%= pform.getCnt() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>