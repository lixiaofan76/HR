<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/6
  Time: 15:26
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

<%
    String errorInfo = (String)request.getAttribute("msg");         // 获取错误属性

    if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=errorInfo%>");                                            // 弹出错误信息

    window.location='index.jsp' ;                            // 跳转到登录界面
</script>
<%
    }
%>
<body>

<div class="container" style="width: 500px">
    <center><h3>添加工资信息页面</h3></center>
    <form action="action.do?method=addSalary" method="post">
        <div class="form-group">
            <label for="userId">员工ID：</label>
            <input type="text" name="userId" class="form-control" id="userId">
        </div>

        <div class="form-group">
            <label for="basic">基本工资:</label>
            <input type="text" name="basic" class="form-control" id="basic">
        </div>

        <div class="form-group">
            <label for="eat">饭补:</label>
            <input type="text" name="eat" class="form-control" id="eat">
        </div>

        <div class="form-group">
            <label for="house">住房补贴:</label>
            <input type="text" name="house" class="form-control" id="house">
        </div>

        <div class="form-group">
            <label for="duty">全勤奖:</label>
            <input type="text" name="duty" class="form-control" id="duty">
        </div>

        <div class="form-group">
            <label for="scot">扣税:</label>
            <input type="text" name="scot" class="form-control" id="scot">
        </div>

        <div class="form-group">
            <label for="punishment">罚金:</label>
            <input type="text" name="punishment" class="form-control" id="punishment">
        </div>

        <div class="form-group">
            <label for="other">其他:</label>
            <input type="text" name="other" class="form-control" id="other">
        </div>

        <div class="form-group">
            <label for="grantTime">发放时间:</label>
            <input type="date" name="grantTime" class="form-control" id="grantTime">
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
