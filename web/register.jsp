<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/3
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<form action="action.do?method=register&roleId=0" method="post">
    <input type="text" name="userName" placeholder="请输入姓名"/><br>
    <input type="password" name="password" placeholder="请输入密码"/><br>
   <%-- <input type="password" name="repassword" placeholder="请再次输入密码"/><br>--%>
    <input type="radio" name="gender" checked="checked">男
    <input type="radio" name="gender">女<br>
    出生日期 <input type="date" name="birthday"/><br>
    创建时间<input type="date" name="createTime"/><br>
    <input type="text" name="content" placeholder="请输入描述"/><br>
    <input type="reset" value="重置"/>
    <input type="submit" value="提交"/>


</form>

</body>
</html>
