<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/6
  Time: 15:03
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
        <th>编号</th>
        <th>员工ID</th>
        <th>基本薪资</th>
        <th>饭补</th>
        <th>住房补贴</th>
        <th>全勤奖</th>
        <th>扣税</th>
        <th>罚款</th>
        <th>其他补助</th>
        <th>发放时间</th>
        <th>总计</th>
        <th>操作</th>
    </tr>
<c:forEach items="${salary}" var="salary">
    <tr>
        <td>${salary.id}</td>
        <td>${salary.userId}</td>
        <td>${salary.basic}</td>
        <td>${salary.eat}</td>
        <td>${salary.house}</td>
        <td>${salary.duty}</td>
        <td>${salary.scot}</td>
        <td>${salary.punishment}</td>
        <td>${salary.other}</td>
        <td>${fn:substring(salary.grantTime,0,19)}</td>
        <td>${salary.totalize}</td>

        <td><button><a href="action.do?method=findOneSalary&id=${salary.id}">修改</a></button></td>
        <td> <button><a id="deleteSalary" href="action.do?method=deleteSalaryById&id=${salary.id}">删除</a></button></td>
    </tr>
</c:forEach>
</table>


</body>
</html>
