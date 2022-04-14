<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="WEB-INF/TLD/struts-html.tld" prefix="html" %>
<%@ taglib uri="WEB-INF/TLD/struts-bean.tld" prefix="bean" %>
<%@ page import = "omikuji.InputForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
<style>
	#input-form input {
		padding : 5px 10px;
		text-align : center;
	}
	#noneDiv {
		display : none;
	}
	p {
		color : red;
	}
</style>
</head>
<body>	
	<h1>Omikuji Web Service</h1> 
	<form id = "input-form">
		<span>お誕生日を入力してください！</span>
		<input type = "text" name = "birthday" placeholder = "yyyyMMddの形式" />
		<input type = "submit"
				name = "btn"
				value = "確認"
				formaction = "<%= request.getContextPath()%>/ActionInput.do"
				formmethod = "POST" />
		<p>
			<html:messages id="msg" message = "true" property = "errmsg.1">
				<bean:write name="msg" />
			</html:messages>
		</p>		
				
		<br><br>
		上にお誕生日を入力してクリックしてください！
		<input type = "submit"
				name = "btn"
				value = "click1"
				formaction = "<%= request.getContextPath()%>/HalfResult.do"
				formmethod = "POST" />
		<input type = "submit"
				name = "btn"
				value = "click2"
				formaction = "<%= request.getContextPath()%>/PercentResult.do"
				formmethod = "POST" />
		
	</form>
</body>
</html>
