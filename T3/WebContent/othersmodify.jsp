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
<s:form action="modifyuser" method="post">
<tr>
	<td>ID</td>
	<td><s:textfield name="userinfo.id" readonl="true"/></td>
</tr>
<tr>
	<td>�n���b��</td>
	<td><s:textfield name="userinfo.username"/>
</tr>
<tr>
	<td>�n���K�X</td>
	<td><s:textfield name="userinfo.password"/></td>
</tr>
<tr>
	<td>�u��m�W</td>
	<td><s:textfield name="userinfo.name"/></td>
</tr>
<tr>
	<td>�ʺ�</td>
	<td><s:textfield name="userinfo.nic"/></td>
</tr>
<tr>
	<td>�ʧO<s:radio list="#{'1':'�k','0':'�k'}" name="userinfo.sex" value="userinfo.sex"/></td>
</tr>
<tr>
	<td>�~��</td>
	<td><s:textfield name="userinfo.age"/></td>
</tr>
<tr>
	<td>�l�c�a�}</td>
	<td><s:textfield name="userinfo.email"/></td>
</tr>
<tr>
	<td>�s���q��</td>
	<td><s:textfield name="userinfo.phone"/></td>
</tr>
<tr>
	<td>�ӤH����</td>
	<td><s:textfield name="userinfo.selfshow"/></td>
</tr>
<tr>
	<td>�v��</td>
	<td><s:textfield name="userinfo.roleId" readonl="true"/></td>
</tr>
<tr>
	<td><s:submit value="�ק�"/></td>
</tr>
</s:form>
	
</body>
</html>