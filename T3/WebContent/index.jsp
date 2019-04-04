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

<s:if test="#session.user.roleId==0">
	<FRAME name=main src="main.jsp" scrolling=yes>
</s:if>
<s:else>
	<FRAME name=main src="adminselectuser.jsp" scrolling=yes>
</s:else>

<s:iterator value="#session.user">
	<td align=center width=80> <s:property value="password"/></td>
</s:iterator>

		歡迎:<s:property value="user.username"/>
		
		<s:form action="scan" method="post" >
			<s:submit value="查看個人信息"/>
		</s:form>
		<s:form action="modifydispatch" method="post" >
			<s:submit value="修改個人信息"/>
		</s:form>
		<s:form action="getallusers" method="post" >
			<s:submit value="查看所有用戶信息"/>
		</s:form>
		<s:form action="ifcanadd" method="post" >
			<s:submit value="添加新用戶"/>
		</s:form>
		<s:form action="selectnewuser" method="post" >
			<s:submit value="查看新增用戶"/>
		</s:form>
		<s:form action="scan" method="post" >
			<s:submit value="添加管理員"/>
		</s:form>
		<s:form action="selectalladmin" method="post" >
			<s:submit value="查看所有管理員"/>
		</s:form>
		<s:form action="scan" method="post" >
			<s:submit value="用戶退出"/>
		</s:form>
		
		
</html>