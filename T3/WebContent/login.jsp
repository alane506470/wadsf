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
	<s:form action="login" method="post" >
		�b��:<s:textfield name="user.username"/>
		�K�X:<s:password name="user.password"/>
		<s:submit value="�n��"/>
	</s:form>
</body>
</html>

