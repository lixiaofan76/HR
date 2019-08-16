<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/4
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"><!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        function validateform(){
            var time = document.myform.createTime.value;
            var birthday = document.myform.birthday.value;
            if (time==null || time=="") {
                alert("创建时间不能为空！");
                return false;
            } else if (birthday == null || birthday=="") {
                alert("生日不能为空！");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container" style="width: 500px">
    <center><h3>个人信息</h3></center>
    <form name="myform" action="myFileUploadServlet.do?id=${users.id}" method="post" enctype="multipart/form-data" onsubmit="return validateform()">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" name="userName" class="form-control" id="name" value="${users.userName}">
        </div>

        <div class="form-group">
            <label>性别:</label>
            <c:choose>
                <c:when test="${users.gender == false}">
                    <input type="radio" name="gender" value="0" checked/>男
                    <input type="radio" name="gender" value="1"/>女
                </c:when>
                <c:when test="${users.gender == true}">
                    <input type="radio" name="gender" value="0"/>男
                    <input type="radio" name="gender" value="1" checked/>女
                </c:when>
            </c:choose>
        </div>

        <div class="form-group">
            <label for="birthday">生日:</label>
            <input type="date" name="birthday" class="form-control" id="birthday" value="${fn:substring(users.birthday,0,19)}">
        </div>

        <div class="form-group">
            <label for="createTime">创建时间:</label>
            <input type="date" name="createTime" class="form-control" id="createTime" value="${fn:substring(users.createTime,0,19)}">
        </div>

        <div class="form-group">
            <label for="content">描述信息:</label>
<%--            <textarea class="form-control" rows="3" id="content" name="content" value="${users.content}"></textarea>--%>
            <input type="text" class="form-control" name="content" value="${users.content}" id="content">
        </div>

        <div class="form-group">
            <label>头像:</label>
            <input type="file" name="imgPath"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="homePage2.jsp"> <input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>
</body>
</html>
