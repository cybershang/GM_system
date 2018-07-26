<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/7/27
  Time: 3:17
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
<c:forEach items="${teacherList}" var="teachers">
    <tr>
        <td><c:out value="${teachers.username}"/></td>
        <td><c:out value="${teachers.password}"/></td>
        <td><a href="">更新</a></td>
        <td><a href="/deleteTeacher.do?id=${teachers.id}&&teachername=${teachers.username}">删除</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
