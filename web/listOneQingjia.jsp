<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/8
  Time: 20:07
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
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<table class="table table-hover">
    <tr>
        <th>用户名</th>
        <th>请假天数</th>
        <th>请假内容</th>
        <th>审批意见</th>
        <th>是否注销</th>
        <th>创建时间</th>
    </tr>
    <c:forEach items="${qj}" var="qingjias">
        <tr>
            <td>${qingjias.userName}</td>
            <td>${qingjias.totalDay}</td>
            <td>${qingjias.content}</td>
            <td>${qingjias.approval}</td>
            <td>
                <c:if test="${!qingjias.cancel}">未注销</c:if>
                <c:if test="${qingjias.cancel}">已注销</c:if>
            </td>
            <td>${fn:substring(qingjias.createTime,0,19)}</td>
        </tr>
    </c:forEach>

</table>
<div class="form-group" style="text-align: center">
<a href="homePage2.jsp"> <input style="background-color: #2b669a" class="btn btn-default " type="button" value="返回" /></a>
</div>

</body>
</html>
