<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="WEB-INF/TLD/struts-html.tld" prefix="html" %>
<%@ taglib uri="WEB-INF/TLD/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.*" %>
<%@ page import="omikuji.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="halfresult" class="omikuji.HalfResult" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="omikuji.HalfDTO" scope="page"></jsp:useBean>
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
		<%-- <%
			String birthday = InputForm.getBirthday();
			List<HalfDTO> list = halfresult.rslist(birthday);
			for(int i=0; i<list.size(); i++){
				dto = list.get(i);
		%>
		<tr>
			<td><%= dto.getUranaidate() %></td>
			<td><%= dto.getBirthday() %></td>
			<td><%= dto.getOmikujicode() %></td>
			<td><%= dto.getRenewalwriter() %></td>
			<td><%= dto.getRenewaldate() %></td>
			<td><%= dto.getUnseiwriter() %></td>
			<td><%= dto.getUnseiwritedate() %></td>
		</tr>
		<%
			}
		%> --%>
		<logic:iterate id = "HalfDTO" name = "HalfDTO" property = "Halflist">
		<tr>
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










