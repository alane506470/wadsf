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
		<td align=center width=80> 帳號</td>
		<td align=center width=80> 姓名暱稱</td>
		<td align=center width=80> 暱稱</td>
		<td align=center width=80> 查看詳情</td>
	</tr>
<s:iterator value="#session.alluserList">
	<p>
		<tr>
			<td align=center width=80> ${username}</td>
			<td align=center width=80> ${name}</td>
			<td align=center width=80> ${nic}</td>
			<td align=center width=80> <a href="<s:url value="common/scan"/>"> 查看詳情</a></td>
		</tr>
	</p>
</s:iterator>
</body>
</html>