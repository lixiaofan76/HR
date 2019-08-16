<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/9
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 500px">
    <center><h3>打卡记录表</h3></center>
    <form action="action.do?method=add" method="post">
        <div class="form-group">
            <label>姓名：</label>
           <td>${user.userName}</td>
        </div>


        <div class="form-group">
            <label for="createTime">创建时间:</label>
            <input type="date" name="signTime" class="form-control" id="createTime">
        </div>

        <div class="form-group">
            <label for="content">今日心情:</label>
            <textarea class="form-control" rows="3" id="content" name="content"></textarea>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="adminManage.jsp"> <input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>


</body>
</html>
