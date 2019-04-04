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
<s:form action="addadmin" method="post">
	
	<tr>
		<td>登錄帳號</td>
		<td><s:textfield name="admin.username"/>
	</tr>
	<tr>
		<td>登陸密碼</td>
		<td><s:textfield name="admin.password"/></td>
	</tr>
	<tr>
		<td>真實姓名</td>
		<td><s:textfield name="admin.name"/></td>
	</tr>
	<tr>
		<td>暱稱</td>
		<td><s:textfield name="admin.nic"/></td>
	</tr>
	<tr>
		<td>性別<s:radio list="#{'1':'男','0':'女'}" name="admin.sex" value="admin.sex"/></td>
	</tr>
	<tr>
		<td>年齡</td>
		<td><s:textfield name="admin.age"/></td>
	</tr>
	<tr>
		<td>郵箱地址</td>
		<td><s:textfield name="admin.email"/></td>
	</tr>
	<tr>
		<td>連絡電話</td>
		<td><s:textfield name="admin.phone"/></td>
	</tr>
	<tr>
		<td>個人說明</td>
		<td><s:textfield name="admin.selfshow"/></td>
	</tr>
	<tr>
		<td>角色</td>
		<td><s:select list="#{0:'普通用戶',1:'管理員'}" name="admin.roleid" listKey="key" listValue="value" value="1"/></td>
	</tr>
	<s:submit value="添加"/>
	
</s:form>
	
</body>
</html>