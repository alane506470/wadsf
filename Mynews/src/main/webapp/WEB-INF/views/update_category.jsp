<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<h1>新增類別</h1>
        <form:form action="updateCategory" method="post" modelAttribute="category">
            <table>
                <tr>
                	 <td>
                        <form:hidden name="id"  value="%{category.id}" /> <br />
                    </td>
                    <td>Name</td>
                    <td>
                        <form:textfield name="name" value="%{category.id}" label="類別名稱"/> <br />
                    </td>
                    <td>
                        <form:hidden name="topId" value="%{category.topId}" /> <br />
                    </td>
                </tr>
                    <td colspan="2"><button type="submit">更新</button></td>
                </tr>
            </table>
        </form:form>
</body>
</html>