<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<s:if test="#request.clist.size()!=0">
	<table>
		<tr>
			<td>
				<div align="center">
				���O�W��
				</div>
			</td>
			<td>
				<div align="center">
				�򥻾ާ@
				</div>
			</td>
		</tr>
		<s:iterator value="#request.clist" var="category">
			<tr>
				<td>
					<s:property value="#category.name"/>
				</td>
				
				<td>
					<img src="images/edt.gif"/>�s��
					<img src="images/edt.gif"/>�R��
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
�ȵL�ƾ�
</s:else>
</body>
</html>