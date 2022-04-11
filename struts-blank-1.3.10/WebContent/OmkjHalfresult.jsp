<%@ page import="omikuji.HalfResult" %>
<%@ page import="omikuji.HalfForm" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%=
	HalfForm halfform = (HalfForm) form;
	ResultSet rs = request.getAttribute("resultset");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
</head>
<body>
	<h1>Omikuji Web Service</h1>
	<h4>~ 半年前から今までの結果リスト ~</h4>
	<br>
	<table border = "1">
		<tr>
			<td>占い日</td>
			<td>誕生日</td>
			<td>おみくじのコード</td>
			<td>リニューアルの作成者</td>
			<td>リニューアルの日</td>
			<td>運勢の作成者</td>
			<td>運勢の作成日</td>
		</tr>
		<%
			while(rs.next()) {
		%>
		<tr>
			<td><%= halfform.getUranaidate() %></td>
			<td><%= halfform.getBirthday() %></td>
			<td><%= halfform.getOmikujicode() %></td>
			<td><%= halfform.getRenewalwriter() %></td>
			<td><%= halfform.getRenewaldate() %></td>
			<td><%= halfform.getUnseiwriter() %></td>
			<td><%= halfform.getUnseiwritedate() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>