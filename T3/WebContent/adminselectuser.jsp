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
<s:iterator value="#session.alluserList">
	<tr>
		<td><s:property value="username"/></td>
		<td><s:property value="nic"/></td>
		<td><s:property value="name"/></td>
		<td><a href="/T3/scan.action?id=${id}" target="main">�d�ݸԱ�</a></td>
		<td><a href="/T3/deleteuser.action?id=${id}" target="main">�R���Τ�</a></td>
		<td><a href="/T3/modifydispatch.action?id=${id}" target="main">�ק�Τ�</a></td><p/>
	
	</tr>
</s:iterator>
</body>
</html>