<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/5
  Time: 20:48
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
</head>
<body>
<div><span>${msg}</span></div>

<div class="container" style="width: 500px">
    <center><h3>请完善培训信息</h3></center>
    <form action="action.do?method=addTrain" method="post">
        <div class="form-group">
            <label for="name">课程名称：</label>
            <input type="text" name="name" class="form-control" id="name">
        </div>

        <div class="form-group">
            <label for="purpose">培训目的：</label>
            <input type="text" name="purpose" class="form-control" id="purpose">
        </div>

        <div class="form-group">
            <label for="beginTime">开始时间：</label>
            <input type="date" name="beginTime" class="form-control" id="beginTime">
        </div>

        <div class="form-group">
            <label for="endTime">结束时间：</label>
            <input type="date" name="endTime" class="form-control" id="endTime">
        </div>

        <div class="form-group">
            <label for="datum">培训材料：</label>
            <input type="text" name="datum" class="form-control" id="datum">
        </div>

        <div class="form-group">
            <label for="teacher">讲师姓名：</label>
            <input type="text" name="teacher" class="form-control" id="teacher">
        </div>

        <div class="form-group">
            <label for="studentId">培训人id：</label>
            <input type="text" name="studentId" class="form-control" id="studentId">
        </div>


        <div class="form-group">
            <label for="createTime">创建时间：</label>
            <input type="date" name="createTime" class="form-control" id="createTime">
        </div>


        <div class="form-group">
            <label>完成情况:</label>
            <input type="radio" name="educate" checked="checked"/>已完成
            <input type="radio" name="educate"  />未完成
        </div>

        <div class="form-group">
            <label for="effect">培训效果:</label>
            <input type="date" name="effect" class="form-control" id="effect">
        </div>

        <div class="form-group">
            <label for="summarize">总体感觉:</label>
            <input type="date" name="summarize" class="form-control" id="summarize">
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="applicantIndex.jsp"> <input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>


<button><a href="applicantIndex2.jsp">主页</a></button>


</body>
</html>
