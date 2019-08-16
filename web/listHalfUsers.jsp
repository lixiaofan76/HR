<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/10
  Time: 14:45
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
    <link href="css/bootstrap.min.css" rel="stylesheet"><!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<h3 style="text-align: center">用户打卡列表</h3>
<div class="container">
    <%--<div style="float: right">
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选择</a>
    </div>--%>
    <form id="form" action="action.do?method=delSelectUser" method="post">
        <table border="1" class="table table-bordered table-hover" >
            <tr  class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                 <%-- <th>ID</th>--%>
                <th>姓名</th>
                <th>用户角色</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value="${user.id}"></th>
                    <td>${s.count}</td>
                        <%-- <td>${user.id}</td>--%>
                    <td>${user.userName}</td>
                    <td>${user.roleName}</td>
                    <td>

                        <a class="btn btn-default btn-sm" href="action.do?method=findOneAllSigns&userName=${user.userName}">查看</a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="5" align="center"></td>
            </tr>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <%--激活按钮--%>

                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="action.do?method=listHalfUsers&currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="action.do?method=listHalfUsers&currentPage=${i}&rows=5">${i}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
            </ul>
        </nav>
    </div>

</div>


</body>
</html>
