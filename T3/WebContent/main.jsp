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

	<tr>
		<td align=center width=80> �b��</td>
		<td align=center width=80> �m�W�ʺ�</td>
		<td align=center width=80> �ʺ�</td>
		<td align=center width=80> �d�ݸԱ�</td>
	</tr>
<s:iterator value="#session.alluserList">
	<p>
		<tr>
			<td align=center width=80> ${username}</td>
			<td align=center width=80> ${name}</td>
			<td align=center width=80> ${nic}</td>
			<td align=center width=80> <a href="<s:url value="common/scan"/>"> �d�ݸԱ�</a></td>
		</tr>
	</p>
</s:iterator>
</body>
</html>