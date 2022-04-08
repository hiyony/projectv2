<%@ page import = "omikuji.DBUtil" %>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! //변수선언
	Connection conn = null;
	String select_sql = "SELECT * from public.unseiresult u "
			+ "WHERE (SELECT CAST(u.uranaidate AS date) AS uradate) " 
			+ "BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' "
			+ "AND CURRENT_TIMESTAMP "
			+ "AND birthday = '19971005' "
			+ "ORDER BY u.uranaidate ASC";
	PreparedStatement pstmt = null;
	ResultSet rs = null; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
</head>
<body>
	<%
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
	%>
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
			<td><%= rs.getString("uranaidate") %></td>
			<td><%= rs.getString("birthday") %></td>
			<td><%= rs.getString("omikujicode") %></td>
			<td><%= rs.getString("renewalwriter") %></td>
			<td><%= rs.getString("renewaldate") %></td>
			<td><%= rs.getString("unseiwriter") %></td>
			<td><%= rs.getString("unseiwritedate") %></td>
		</tr>
		<%
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</table>
</body>
</html>