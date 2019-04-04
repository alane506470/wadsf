<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:form action="adduser" method="post">
	<tr>
		<td>登錄帳號</td>
		<td><s:textfield name="user.username"/>
	</tr>
	<tr>
		<td>登陸密碼</td>
		<td><s:textfield name="user.password"/></td>
	</tr>
	<tr>
		<td>真實姓名</td>
		<td><s:textfield name="user.name"/></td>
	</tr>
	<tr>
		<td>暱稱</td>
		<td><s:textfield name="user.nic"/></td>
	</tr>
	<tr>
		<td>性別<s:radio list="#{'1':'男','0':'女'}" name="user.sex" value="user.sex"/></td>
	</tr>
	<tr>
		<td>年齡</td>
		<td><s:textfield name="user.age"/></td>
	</tr>
	<tr>
		<td>郵箱地址</td>
		<td><s:textfield name="user.email"/></td>
	</tr>
	<tr>
		<td>連絡電話</td>
		<td><s:textfield name="user.phone"/></td>
	</tr>
	<tr>
		<td>個人說明</td>
		<td><s:textfield name="user.selfshow"/></td>
	</tr>
	<s:submit value="添加"/>
</s:form>
	
</body>
</html>