<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/5
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<table class="table table-hover" width="1000px" border="1px">

    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>岗位</td>
        <td>专业</td>
        <td>工作经验</td>
        <td>学历</td>
        <td>毕业学校</td>
        <td>电话</td>
        <td>邮箱</td>
        <td>登记时间</td>
        <td>详细经历</td>
        <td>是否入职</td>
        <td>是否合格</td>
        <th>操作</th>
    </tr>

    <c:if test="${applicant != null}">
        <c:forEach items="${applicant}" var="applicants">
            <tr>
                <td>${applicants.id}</td>
                <td>${applicants.name}</td>
                <td>
                    <c:if test="${!applicants.gender}">男</c:if>
                    <c:if test="${applicants.gender}">女</c:if>
                </td>
                <td>${applicants.age}</td>
                <td>${applicants.job}</td>
                <td>${applicants.specialty}</td>
                <td>${applicants.experience}</td>
                <td>${applicants.studyEffort}</td>
                <td>${applicants.school}</td>
                <td>${applicants.tel}</td>
                <td>${applicants.email}</td>
                <td>${applicants.createTime}</td>
                <td>${applicants.content}</td>
                <td>${applicants.isHiring}</td>
                <td>
                    <c:if test="${applicants.isHiring}">已通过</c:if>
                    <c:if test="${!applicants.isHiring}">待审核</c:if>
                <td>
                    <a href="action.do?method=modifyById&id=${applicants.id}">达标</a>
                </td>
            </tr>


        </c:forEach>
    </c:if>

</table>


</body>
</html>
