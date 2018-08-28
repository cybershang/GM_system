<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/14
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${msg}"></c:out>
<form action="/uploadImg.do" method="post" enctype="multipart/form-data">
    <table width="400px" align="center">
        <tr>
            <td><input type="file" name="file"/>
            </td>
            <td>
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
