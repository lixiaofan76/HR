<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/7
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Title</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style>
        .round_icon{
            width: 30px;
            height: 30px;
            display: flex;
            border-radius: 50%;
            align-items: center;
            justify-content: center;
            overflow: hidden;
        }

        .navbar {
            border-radius: 0px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">主页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <c:if test="${sign.mark}">
                        <a href="#">已打卡</a>
                    </c:if>
                    <c:if test="${!sign.mark}">
                        <a href="action.do?method=userSign&userName=${user.userName}">未打卡</a>
                    </c:if>
                </li>

                <li class="dropdown ">
<%--                    <img class="round_icon" src="${user.imgPath}"/>--%>
                    <a href="action.do?method=findOne2&id=${user.id}"><img class="round_icon" src="${user.imgPath}" alt="上传头像"/> </a>
                </li>
                <li class="dropdow">
                   <a href="#"  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 欢迎${user.userName}登录<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="qingjia.jsp">请假</a></li>
                        <li><a href="action.do?method=findOneQingjia&userName=${user.userName}">请假信息</a></li>
                        <li><a href="action.do?method=userLogout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>

<div style="color: #1b6d85;text-align: center;font-size: 25px">
    欢迎来到海为人力资源部
</div>

<div id="carousel-example-generic" class="carousel slide " data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="img/01.jpg" >

        </div>
        <div class="item">
            <img src="img/02.jpg" >
        </div>
        <div class="item">
            <img src="img/03.jpg" >
        </div>

    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>




</body>
</html>
