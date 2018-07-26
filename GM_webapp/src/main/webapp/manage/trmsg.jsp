<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/7/27
  Time: 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addTeacher.do" method="post">
    <table style="margin-top: 30px;" width="300px;" align="center">
        <tr>
            <td>输入教师姓名</td>
            <td><input type="text" name="teachername"></td>
        </tr>
        <tr>
            <td>输入教师登录密码</td>
            <td><input type="text" name="teacherpassword"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
