<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="WEB-INF/TLD/struts-html.tld" prefix="html" %>
<%@ taglib uri="WEB-INF/TLD/struts-bean.tld" prefix="bean" %>
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
	<h4>~ 「<%= bday %>」の半年前からの運勢結果割合 ~</h4>
	<input type = "button" value = "戻る" onclick = "location.href = '/struts/OmkjInput.jsp'">
	<br><br>
	<table border = "1">
		<tr>
			<th>運勢名</th>
			<th>運勢数</th>
			<th>運勢の割合</th>
		</tr>
		
		<logic:iterate id = "PercentDTO" name = "list">
		<tr>
			<td><bean:write name = "PercentDTO" property = "unseiname" /></td>
			<td><bean:write name = "PercentDTO" property = "cnt" /></td>
			<td><bean:write name = "PercentDTO" property = "per" />%</td>
		</tr>
		</logic:iterate>
	</table>
</body>
</html>





