<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/7
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addStudent.do" method="post">
    <table style="margin-top: 30px;" width="300px;" align="center">
        <tr>
            <td>输入学生姓名</td>
            <td><input type="text" name="studentname"></td>
        </tr>
        <tr>
            <td>输入学生登录密码</td>
            <td><input type="text" name="studentpassword"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
