<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/6
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>

<table class="table table-hover">
    <tr>
        <th>课程id</th>
        <th>课程名称</th>
        <th>培训目的</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>培训材料</th>
        <th>讲师</th>
        <th>培训人ID</th>
        <th>创建时间</th>
        <th>是否完成</th>
        <th>培训效果</th>
        <th>培训总体感觉</th>
    </tr>

    <c:forEach items="${train}" var="trains">
        <td>
            <td>${trains.id}</td>
            <td>${trains.name}</td>
            <td>${trains.purpose}</td>
            <td> <fmt:formatDate value="${trains.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<%--            <td>${fn:substring(trains.beginTime,0,19)}</td>--%>
            <td>${fn:substring(trains.endTime,0,19)}</td>
            <td>${trains.datum}</td>
            <td>${trains.teacher}</td>
            <td>${trains.studentId}</td>
            <td>${fn:substring(trains.createTime,0,19)}</td>
            <td>${trains.educate}</td>
            <td>${trains.effect}</td>
            <td>${trains.summarize}</td>

            <td> <button><a href="action.do?method=deleteByTrainId&id=${trains.id}">删除</a></button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
