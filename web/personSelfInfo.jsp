<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/4
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎"${user.userName}"来到海为科技园</h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="action.do?method=userLogout">登出</a>
<a href="action.do?method=findOne2&id=${user.id}">点击修改个人信息</a>

</body>
</html>
