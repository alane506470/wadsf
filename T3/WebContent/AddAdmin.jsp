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
		<td>�n���b��</td>
		<td><s:textfield name="admin.username"/>
	</tr>
	<tr>
		<td>�n���K�X</td>
		<td><s:textfield name="admin.password"/></td>
	</tr>
	<tr>
		<td>�u��m�W</td>
		<td><s:textfield name="admin.name"/></td>
	</tr>
	<tr>
		<td>�ʺ�</td>
		<td><s:textfield name="admin.nic"/></td>
	</tr>
	<tr>
		<td>�ʧO<s:radio list="#{'1':'�k','0':'�k'}" name="admin.sex" value="admin.sex"/></td>
	</tr>
	<tr>
		<td>�~��</td>
		<td><s:textfield name="admin.age"/></td>
	</tr>
	<tr>
		<td>�l�c�a�}</td>
		<td><s:textfield name="admin.email"/></td>
	</tr>
	<tr>
		<td>�s���q��</td>
		<td><s:textfield name="admin.phone"/></td>
	</tr>
	<tr>
		<td>�ӤH����</td>
		<td><s:textfield name="admin.selfshow"/></td>
	</tr>
	<tr>
		<td>����</td>
		<td><s:select list="#{0:'���q�Τ�',1:'�޲z��'}" name="admin.roleid" listKey="key" listValue="value" value="1"/></td>
	</tr>
	<s:submit value="�K�["/>
	
</s:form>
	
</body>
</html>