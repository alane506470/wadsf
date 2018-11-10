<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<a href="/Mynews/inputCategory">添加類別</a>

<s:if test="#request.clist.size()!=0">
	<table>
		<tr>
			<td>
				<div align="center">
				類別名稱
				</div>
			</td>
			<td>
				<div align="center">
				基本操作
				</div>
			</td>
		</tr>
		<s:iterator value="#request.clist" var="category">
			<tr>
				<td>
					<s:property value="#category.name"/>
				</td>
				
				<td>
					<a href="/Mynews/updateInput?category.id=<s:property value="#category.id"/>"><img src="images/edt.gif"/>編輯
					<a href="/Mynews/updateInput?id=<s:property value="#category.id"/>"><img src="images/edt.gif"/>編輯
					<img src="images/edt.gif"/>刪除
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
暫無數據
</s:else>
</body>
</html>