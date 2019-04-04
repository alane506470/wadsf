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
		<td>登錄帳號</td>
		<td><s:property value="userinfo.username"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>真實姓名</td>
		
		<td><s:property value="userinfo.name"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>暱稱</td>
		<td><s:property value="userinfo.nic"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>性別</td>
		<td><s:if test="userinfo.sex==0">女</s:if><s:else>男</s:else></td>
	</tr>
</p>
<p>
	<tr>
		<td>年齡</td>
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
		<td>連絡電話</td>
		<td><s:property value="userinfo.phone"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>個人說明</td>
		<td><s:property value="userinfo.selfshow"/></td>
	</tr>
</p>
<p>
	<tr>
		<td>用戶權限</td>
		<td><s:if test="userinfo.roleId==0">普通用戶</s:if>
			<s:elseif test="userinfo.roleId==1">管理員</s:elseif>
			<s:else>超級管理員</s:else>
		</td>
	</tr>
</p>
</body>
</html>