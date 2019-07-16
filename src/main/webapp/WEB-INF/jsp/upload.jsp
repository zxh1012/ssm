<%--
  Created by IntelliJ IDEA.
  User: 20190328
  Date: 2019/6/13
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/ctx.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>上传文件${msg}</h1>
    <form action="${ctx}/file/Upload" method="post" enctype="multipart/form-data">
        <input type="file" name="imgs"><br>
        <input type="file" name="imgs"><br>
        <input type="submit" value="ok">
    </form>
</body>
</html>
