<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/9
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/repairNote.do">
        <table width="400px" align="center">
            <tr>
                <td>输入想要添加的备注信息：</td>
                <td><input type="text" name="note"/> </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</body>
</html>
