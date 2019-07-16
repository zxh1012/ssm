<%--
  Created by IntelliJ IDEA.
  User: 20190328
  Date: 2019/6/10
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/ssm/cu/doedit" method="get">
    <table border="2px" align="center" style="width: 300px ;height: 200px;">
        <tr>
            <td>客户ID</td>
            <td><input type="text" name="customerId" value="${customer.customerId}"></td>
        </tr>
        <tr>
            <td>客户姓名</td>
            <td><input type="text" name="customerName" value="${customer.customerName}"></td>
        </tr>
        <tr  align="center">
            <td colspan="2"><input type="submit" value="确定"> <input type="button" onclick="history.go(-1)" value="取消"></td>
        </tr>
    </table>
    </form>
</body>
</html>
