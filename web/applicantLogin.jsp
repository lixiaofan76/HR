<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/4
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Applicant Login</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">应聘者登录</h3>
    <form action="action.do?method=applicantLogin" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="tel">电话：</label>
            <input type="password" name="tel" class="form-control" id="tel" placeholder="请输入密码"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
<%--<form action="action.do?method=applicantLogin" method="post">
<input type="text" name="name" placeholder="请输入你的姓名"/><br>
<input type="text" name="tel" placeholder="请输入你的电话"/><br>
<input type="reset" value="重置"/>
<input type="submit" value="提交"/>
</form>--%>
<a href="registerApplicant.jsp">还没有账号？</a>

</body>
</html>
