<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>学生新增<%=System.currentTimeMillis()%></h1>
    <form action="/ssm/stu/add" method="get">
    <table border="2px" align="center" style="width: 300px ;height: 200px;">
        <tr>
            <td>username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>salt</td>
            <td><input type="text" name="salt"></td>
        </tr>
        <tr>
            <td>locked</td>
            <td><input type="text" name="locked"></td>
        </tr>

        <tr  align="center">
            <td colspan="2"><input type="submit" value="确定"> <input type="button" onclick="history.go(-1)" value="取消"></td>
        </tr>
    </table>
    </form>


</body>
</html>
