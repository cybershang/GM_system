<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/14
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/resetPassword.do">
    <table width="400px" align="center">
        <tr>
            <td>请输入新密码：</td>
            <td><input type="text" name="newPassword"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
