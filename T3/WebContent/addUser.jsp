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
		<td>�n���b��</td>
		<td><s:textfield name="user.username"/>
	</tr>
	<tr>
		<td>�n���K�X</td>
		<td><s:textfield name="user.password"/></td>
	</tr>
	<tr>
		<td>�u��m�W</td>
		<td><s:textfield name="user.name"/></td>
	</tr>
	<tr>
		<td>�ʺ�</td>
		<td><s:textfield name="user.nic"/></td>
	</tr>
	<tr>
		<td>�ʧO<s:radio list="#{'1':'�k','0':'�k'}" name="user.sex" value="user.sex"/></td>
	</tr>
	<tr>
		<td>�~��</td>
		<td><s:textfield name="user.age"/></td>
	</tr>
	<tr>
		<td>�l�c�a�}</td>
		<td><s:textfield name="user.email"/></td>
	</tr>
	<tr>
		<td>�s���q��</td>
		<td><s:textfield name="user.phone"/></td>
	</tr>
	<tr>
		<td>�ӤH����</td>
		<td><s:textfield name="user.selfshow"/></td>
	</tr>
	<s:submit value="�K�["/>
</s:form>
	
</body>
</html>