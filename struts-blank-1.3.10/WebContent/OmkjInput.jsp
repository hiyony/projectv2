<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean" %>
<%@ page import = "omikuji.InputForm" %>
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
	#input-form input {
		padding : 5px 10px;
		text-align : center;
	}
	div {
		color : red;
	}
</style>
</head>
<body>	
	<h1>Omikuji Web Service</h1> 
	
	<html:form action = "/ActionInput.do">
		<span>お誕生日を入力してください！</span>
		<!-- <input type = "text" name = "birthday" placeholder = "yyyyMMddの形式" /> -->
		<html:text property = "birthday" /> (yyyyMMddの形式)
		<html:errors property = "birthday" />
		<input type = "submit"
				name = "btn"
				value = "確認"
				formaction = "<%= request.getContextPath()%>/ActionInput.do"
				formmethod = "POST" />
		<div>
			<%-- <html:messages id="msg" message = "true" property = "errmsg.1">
				<bean:write name="msg" />
			</html:messages> --%>
 			<html:errors />
		</div>		
		<br>	
		<br>
		上にお誕生日を入力してクリックしてください！
		<br>
		<input type = "submit"
				name = "btn"
				value = "過去半年の結果リスト"
				formaction = "<%= request.getContextPath()%>/HalfResult.do"
				formmethod = "POST" />
		<input type = "submit"
				name = "btn"
				value = "過去半年のおみくじ割合"
				formaction = "<%= request.getContextPath()%>/PercentResult.do"
				formmethod = "POST" />
		
	</html:form>
</body>
</html>
