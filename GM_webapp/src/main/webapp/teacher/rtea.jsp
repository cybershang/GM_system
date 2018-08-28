<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/14
  Time: 21:53
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
<table width="600px" align="center">
    <tr>
        <td>学生姓名</td>
        <td>学生信息</td>
    </tr>
    <c:forEach items="${grades}" var="grade">
        <tr>
            <td><c:out value="${grade.student.studentname}"/></td>
            <td><c:out value="${grade.student.note}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
