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

		�w��:<s:property value="user.username"/>
		
		<s:form action="scan" method="post" >
			<s:submit value="�d�ݭӤH�H��"/>
		</s:form>
		<s:form action="modifydispatch" method="post" >
			<s:submit value="�ק�ӤH�H��"/>
		</s:form>
		<s:form action="getallusers" method="post" >
			<s:submit value="�d�ݩҦ��Τ�H��"/>
		</s:form>
		<s:form action="ifcanadd" method="post" >
			<s:submit value="�K�[�s�Τ�"/>
		</s:form>
		<s:form action="selectnewuser" method="post" >
			<s:submit value="�d�ݷs�W�Τ�"/>
		</s:form>
		<s:form action="scan" method="post" >
			<s:submit value="�K�[�޲z��"/>
		</s:form>
		<s:form action="selectalladmin" method="post" >
			<s:submit value="�d�ݩҦ��޲z��"/>
		</s:form>
		<s:form action="scan" method="post" >
			<s:submit value="�Τ�h�X"/>
		</s:form>
		
		
</html>