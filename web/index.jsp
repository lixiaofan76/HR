<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/4
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>

<h1>欢迎"${user.userName}"来到海为科技园</h1>&nbsp;&nbsp;&nbsp;&nbsp;<a href="action.do?method=userLogout">登出</a>

<a href="action.do?method=listAll">点击查看用户信息</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="action.do?method=listAllApplicant">点击查看应聘者信息</a>
<a href="action.do?method=listAllTrainInfo">点击查看培训信息</a>&nbsp;&nbsp;&nbsp;
<a href="action.do?method=listAllSalary">点击查看员工工资信息</a>

</body>
</html>
