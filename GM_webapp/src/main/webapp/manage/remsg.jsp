<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/7
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/rePassword.do">
        <table width="500px" align="center">
            <tr>
                <td>请输入待修改用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>请输入旧密码</td>
                <td><input type="text" name="oldpassword"></td>
            </tr>
            <tr>
                <td>请输入新密码</td>
                <td><input type="text" name="newpassword"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
