<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/7
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台主页面</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style>
        @media ( min-width :768px ) {
            #left_tab {
                width: 250px;
                position: absolute;
                z-index: 1;
                height: 640px;
            }
            .mysearch {
                margin: 10px;
            }
            .page_main {
                margin-left: 255px;
            }
            .dv_content{
                width: 100%;
                height: 500px;
            }
        }
    </style>
</head>
<body>

<!--导航 -->
<div style="width: 100%;">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#left_tab,#top_right">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">网站后台管理</a>
        </div>
        <ul id="top_right" class="collapse navbar-collapse nav navbar-nav navbar-right"	style="margin-right: 20px;">
            <li>
                <a href="#">
                    欢迎 <span class="badge">${user.userName}</span>
                </a>
            </li>
            <li>
                <a href="action.do?method=userLogout">
                    <span class="glyphicon glyphicon-off"></span>注销
                </a>
            </li>
        </ul>
        <!--左侧边栏 -->
        <div id="left_tab" style="margin-top: 70px;" class="collapse navbar-default navbar-collapse">
            <ul class="nav panel-group" id="myPanel">
                <!--栏目-->
                <li class="panel">
                    <a href="#sub1" data-toggle="collapse" data-parent="#myPanel"> 用户管理
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub1" class="nav collapse panel-collapse">
                        <li>
                            <a href="action.do?method=pageLimit" target="myFrameName"  id="showUser">
                                <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<b>讲师</b>
                            </a>
                        </li>
                        <li>
                            <a href="action.do?method=listAllApplicant" target="myFrameName"  id="showUser2">
                                <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<b>应聘者</b>
                            </a>
                        </li>
                        <li>
                            <a href="add.jsp" id="addUserType" target="myFrameName" >
                                <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;添加讲师
                            </a>
                        </li>

                        <li>
                            <a href="action.do?method=listAllQingjia" id="findQingjia" target="myFrameName" >
                                <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;查看请假
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#sub2" data-toggle="collapse" data-parent="#myPanel"> 培训信息
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub2" class="nav panel-collapse collapse">
                        <li>
                            <a href="action.do?method=listAllTrainInfo" target="myFrameName"  id="showGoodsType">
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看培训详情
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#sub3" data-toggle="collapse" data-parent="#myPanel"> 工资管理
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub3" class="nav panel-collapse collapse">
                        <li>
                            <a href="action.do?method=listAllSalary" target="myFrameName"  id="showGoods" >
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看工资详情
                            </a>
                        </li>
                        <li>
                            <a href="addSalary.jsp" id="addGoods" target="myFrameName" >
                                <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;添加工资信息
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#sub4" data-toggle="collapse" data-parent="#myPanel"> 打卡管理
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub4" class="nav panel-collapse collapse">
                        <li>
                            <a href="action.do?method=listHalfUsers" target="myFrameName"  id="showSign" >
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看打卡详情
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

    </nav>
    <!--右侧部分-->
    <div class="page_main">
       <%-- <script type="text/javascript">
            $("#showUser").click(function(){


                $(".dv_content").attr("src","user.jsp");
            })
            $("#showUser2").click(function(){
                $(".dv_content").attr("src","user.jsp");
            })
            $("#showGoodsType").click(function(){
                $(".dv_content").attr("src","showGoodsType.html");
            })
            $("#addGoodsType").click(function(){
                $(".dv_content").attr("src","addGoodsType.html");
            })
            $("#showGoods").click(function(){
                $(".dv_content").attr("src","showGoods.html");
            })
            $("#addGoods").click(function(){
                $(".dv_content").attr("src","addGoods.html");
            })
            $("#showOrder").click(function(){
                $(".dv_content").attr("src","showAllOrder.html");
            })
            $("#addUserType").click(function(){
                $(".dv_content").attr("src","adduser.html");
            })
        </script>--%>

        <iframe  id="myFrameId" name="myFrameName" class="dv_content" frameborder="0" scrolling="auto">

        </iframe>
    </div>
</div>

</body>
</html>
