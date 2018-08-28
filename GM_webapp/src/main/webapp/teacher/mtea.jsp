<%@ page import="com.nsfocus.vo.GradesVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nsfocus.bean.Grade" %><%--
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
<table width="580px" align="center">
    <tr>
        <td>学生姓名</td>
        <td>学生分数</td>
    </tr>
    <c:forEach items="${grades}" var="grade">
        <tr>
            <td><c:out value="${grade.student.studentname}"/></td>
            <td><c:out value="${grade.score}"/></td>
        </tr>
    </c:forEach>
</table>
<hr>
<%List<Grade> gradeList=(List<Grade>) request.getAttribute("grades");%>
<a href="/sortGrade.do">增长排序</a>   <!--这个地方还是有问题的，买本书看看吧-->
</body>
</html>
