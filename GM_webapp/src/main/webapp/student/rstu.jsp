<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/9
  Time: 16:12
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
        <td>课程分数</td>
        <td>老师名称</td>
    </tr>
<c:forEach items="${grades}" var="grade">
    <tr>
        <td><c:out value="${grade.score}"/></td>
        <td><c:out value="${grade.teacher.teachername}"/></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
