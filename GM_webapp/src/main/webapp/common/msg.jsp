<%@ page import="com.nsfocus.bo.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/8/8
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息返回页</title>
</head>
<body>
<% ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");%>
<%=resultSet.getMsg()%>
</body>
</html>
