<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/7
  Time: 10:17
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
<table style="margin-top: 30px" width="400px" align="center">
    <tr>
        <td>教师姓名</td>
        <td>教师密码</td>
        <td>更改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${studentList}" var="students">
        <tr>
            <td><c:out value="${students.username}"/></td>
            <td><c:out value="${students.password}"/></td>
            <td><a href="#">更新</a></td>
            <td><a href="/deleteStudent.do?id=${students.id}&&studentname=${students.username}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
