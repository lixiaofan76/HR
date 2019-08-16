<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        window.onload=function () {
            //    给删除选择按钮添加点击时间
            document.getElementById("delSelected").onclick = function () {
                if (confirm("确定删除吗?")) {
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0;i < cbs.length;i++) {
                        if (cbs[i].checked) {
                            //    有一个条目被选中
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        //    表单提交
                        document.getElementById("form").submit();
                    }

                }
            }

            //    获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //    获取下边列表中的cb
                var cbs = document.getElementsByName("uid");
                //    遍历
                for (var i = 0;i < cbs.length;i++) {
                    //    设置这些cbs[i]的check状态与firstCb的状态一致
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>

</head>
<body>

<h3 style="text-align: center">用户信息列表</h3>

<div class="container">

     <div style="float: left">
         <form class="form-inline" action="${pageContext.request.contextPath}/action.do?method=pageLimit" method="post">
             <div class="form-group">
                 <label for="exampleInputName2">姓名</label>
                 <input name="userName" type="text" class="form-control" id="exampleInputName2" value="${condition.userName[0]}">
             </div>
             <button type="submit" class="btn btn-default">查询</button>
         </form>
     </div>

    <div style="float: right">
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选择</a>
    </div>
    <form id="form" action="action.do?method=delSelectUser" method="post">
        <table border="1" class="table table-bordered table-hover" >
            <tr  class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <%--  <th>ID</th>--%>
                <th>姓名</th>
                <th>性别</th>
                <th>生日</th>
                <th>创建时间</th>
                <th>描述</th>
                <th>用户角色</th>
                <th>操作</th>
            </tr>

                <c:forEach items="${pb.list}" var="user" varStatus="s">
                    <tr>
                        <th><input type="checkbox" name="uid" value="${user.id}"></th>
                        <td>${s.count}</td>
                            <%-- <td>${user.id}</td>--%>
                        <td>${user.userName}</td>
                        <td>
                            <c:if test="${!user.gender}">男</c:if>
                            <c:if test="${user.gender}">女</c:if>
                        </td>
                        <td>${user.birthday}</td>
                        <td>${user.createTime}</td>
                        <td>${user.content}</td>
                        <td>${user.roleName}</td>
                        <td>
<%--                            <a class="btn btn-default btn-sm" href="action.do?method=delete&id=${user.id}">删除</a>--%>
                            <a class="btn btn-default btn-sm" href="action.do?method=findOne&id=${user.id}">修改</a>
                        </td>
                    </tr>
                </c:forEach>

              <tr>
                  <td colspan="10" align="center"></td>
              </tr>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">

                </c:if>
                    <c:if test="${pb.currentPage != 1}">
                    <li>
                    </c:if>

                    <a href="action.do?method=pageLimit&currentPage=${pb.currentPage - 1}&rows=5&userName=${condition.userName[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <%--激活按钮--%>

                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="action.do?method=pageLimit&currentPage=${i}&rows=5&userName=${condition.userName[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="action.do?method=pageLimit&currentPage=${i}&rows=5&userName=${condition.userName[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                        <li>
                        </c:if>

                    <a href="action.do?method=pageLimit&currentPage=${pb.currentPage + 1}&rows=5&userName=${condition.userName[0]}" aria-label="Next">
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
