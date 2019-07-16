<%--
  Created by IntelliJ IDEA.
  User: 20190328
  Date: 2019/6/20
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/ssm/user/updatepassword" method="get">
        原始密码:<input type="text" name="password"><br>
        新密码： <input type="text" name="newpassword"><br>
        <input type="submit" value="修改" >
        <input type="reset" value="重新填写" >
    </form>
</body>
</html>
