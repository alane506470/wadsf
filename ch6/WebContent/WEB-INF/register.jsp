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
<s:form action="register!register" method="post">
	<s:textfield name="user.username" label="�Τ�W" size="20"/>
	<s:password name="user.password" label="�K�X" size="20"/>
	<s:textfield name="user.realname" label="�u��m�W" size="20"/>
	<s:textfield name="user.phone" label="�q��" size="20"/>
	<s:textfield name="user.address" label="�a�x�a�}" size="20"/>
	<s:submit value="���U"/>
</s:form>
<s:fielderror/>
</body>
</html>