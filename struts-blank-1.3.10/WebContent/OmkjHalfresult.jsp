<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="WEB-INF/TLD/struts-html.tld" prefix="html" %>
<%@ taglib uri="WEB-INF/TLD/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*" %>
<%@ page import="omikuji.*" %>
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
	table {
		margin-left : auto;
		margin-right : auto;
	}
</style>
</head>
<body>
	<% String bday = request.getParameter("birthday"); %>
	<h1>Omikuji Web Service</h1>
	<h4>~ 「<%= bday %>」の半年前から今までの結果リスト ~</h4>
	<input type = "button" value = "戻る" onclick = "location.href = '/struts/OmkjInput.jsp'">
	<br><br>
	<table border = "1">
		<tr>
			<th>占い日</th>
			<th>誕生日</th>
			<th>おみくじのコード</th>
			<th>リニューアルの作成者</th>
			<th>リニューアルの日</th>
			<th>運勢の作成者</th>
			<th>運勢の作成日</th>
		</tr>
		
		<logic:iterate id = "HalfDTO" name = "list">
		<tr>
			<fmt:parseDate value = "${HalfDTO.uranaidate}" pattern = "yyyy/MM/dd" />
			<td><bean:write name = "HalfDTO" property = "uranaidate" /></td>
			<td><bean:write name = "HalfDTO" property = "birthday" /></td>
			<td><bean:write name = "HalfDTO" property = "omikujicode" /></td>
			<td><bean:write name = "HalfDTO" property = "renewalwriter" /></td>
			<td><bean:write name = "HalfDTO" property = "renewaldate" /></td>
			<td><bean:write name = "HalfDTO" property = "unseiwriter" /></td>
			<td><bean:write name = "HalfDTO" property = "unseiwritedate" /></td>
		</tr>
		</logic:iterate>
	</table>
</body>
</html>










