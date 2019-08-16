<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/10
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title> <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<table class="table table-hover">
    <tr>
        <th>id</th>
        <th>打卡时间</th>
        <th>打卡详情</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${allSign}" var="as">
        <tr>
            <td>${as.id}</td>
            <td>${fn:substring(as.signTime,0,19)}</td>
            <td>
               已打卡
            </td>
            <td><a href="javascript:if(window.confirm('是否删除?')){window.location.href='action.do?method=deleteOneSignById&id=${as.id}&userName=${as.userName}'}">删除</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
