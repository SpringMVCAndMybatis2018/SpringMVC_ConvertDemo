<%--
  Created by IntelliJ IDEA.
  User: Anlu
  Date: 2018/3/3
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="user" method="post" action="" >
    <table>
        <tr>
            <td>日期类型:</td>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td>整数类型:</td>
            <td><form:input path="total"/></td>
        </tr>
        <tr>
            <td>百分数类型:</td>
            <td><form:input path="discount"/></td>
        </tr>
        <tr>
            <td>货币类型:</td>
            <td><form:input path="money"/></td>
        </tr>
    </table>
</form:form>

日期:${user.birthday}<br/>
整数:${user.total}<br/>
百分数:${user.discount}<br/>
货币:${user.money}<br/>
</body>
</html>
