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
	<s:iterator value="#session.alladminList">
	<tr>
		<td><s:property value="username"/></td>
		<td><s:property value="nic"/></td>
		<td><s:property value="name"/></td>
		<td><a href="/T3/scan?id=${id}" target="main">查看詳情</a></td><p/>
	</tr>
</s:iterator>
</body>
</html>