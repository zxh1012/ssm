<%--
  Created by IntelliJ IDEA.
  User: 20190328
  Date: 2019/6/10
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="z" uri="/zking" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="2px" align="center" height="20%" width="100%">
        <tr>
            <th>客户ID</th>
            <th>客户姓名</th>
            <th>操作</th>
        </tr>
            <c:forEach var="b" items="${list}">
        <tr>
        <th>${b.customerId}</th>
            <td align="center">${b.customerName}</td>
            <td align="center"><a href="/ssm/cu/add">添加</a>
                <a href="/ssm/cu/del?customerId=${b.customerId}">删除</a>
                <a href="/ssm/cu/edit?customerId=${b.customerId}">修改</a>
            </td>
        </tr>

            </c:forEach>
        <tr><td colspan="3"  align="center">
            <z:page pageBean="${pageBean}"/>
        </td></tr>
    </table>
        <a href="/ssm/user/toupdatepassword">修改密码</a>

</body>
</html>
