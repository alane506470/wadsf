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
	<s:textfield name="user.username" label="用戶名" size="20"/>
	<s:password name="user.password" label="密碼" size="20"/>
	<s:textfield name="user.realname" label="真實姓名" size="20"/>
	<s:textfield name="user.phone" label="電話" size="20"/>
	<s:textfield name="user.address" label="家庭地址" size="20"/>
	<s:submit value="註冊"/>
</s:form>
<s:fielderror/>
</body>
</html>