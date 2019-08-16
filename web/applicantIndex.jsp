<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/5
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>欢迎"${applicants.name}"登录</div>
<a href="action.do?method=findOne3&id=${applicants.id}">点击修改个人信息</a><br>
<a href="addTrain.jsp">点击添加培训信息</a>


</body>
</html>
