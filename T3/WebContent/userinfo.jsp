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
<p>
	<tr>
		<td>�n���b��</td>
		<td><s:property value="userinfo.username"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>�u��m�W</td>
		
		<td><s:property value="userinfo.name"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>�ʺ�</td>
		<td><s:property value="userinfo.nic"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>�ʧO</td>
		<td><s:if test="userinfo.sex==0">�k</s:if><s:else>�k</s:else></td>
	</tr>
</p>
<p>
	<tr>
		<td>�~��</td>
		<td><s:property value="userinfo.age"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>Email</td>
		<td><s:property value="userinfo.email"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>�s���q��</td>
		<td><s:property value="userinfo.phone"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>�ӤH����</td>
		<td><s:property value="userinfo.selfshow"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>�Τ��v��</td>
		<td><s:if test="userinfo.roleId==0">���q�Τ�</s:if>
			<s:elseif test="userinfo.roleId==1">�޲z��</s:elseif>
			<s:else>�W�ź޲z��</s:else>
		</td>
	</tr>
</p>
</body>
</html>