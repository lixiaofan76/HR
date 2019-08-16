<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/4
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Applicant register</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <script src="js/jquery-3.3.1.min.js"></script>

    <script>
        //在页面加载完成
        $(function () {
            //给name绑定blur事件
            $("#name").blur(function () {
                //获取name输入框的值
                var name = $(this).val();
                //发送ajax请求
                //期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"}
                //                         {"userExsit":false,"msg":"用户名可用"}
                $.get("findUserServlet",{name:name},function (data) {
                    //判断userExsit键的值是否是true
                    var span = $("#s_name");
                    if (data.userExsit) {
                        //用户名存在
                        span.css("color","red");
                        span.html(data.msg);
                    } else {
                        //用户名保存在
                        span.css("color","green");
                        span.html(data.msg);

                    }
                });
            });
        });
    </script>
</head>
<body>

<div class="container" style="width: 500px">
    <center><h3>应聘注册页面</h3></center>
    <form action="action.do?method=addApplicant" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" name="name" class="form-control" id="name"><span id="s_name"></span>
        </div>

        <div class="form-group">
            <label>性别:</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女" />女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" name="age" class="form-control" id="age">
        </div>

        <div class="form-group">
            <label for="job">岗位：</label>
            <input type="text" name="job" class="form-control" id="job">
        </div>

        <div class="form-group">
            <label for="specialty">专业：</label>
            <input type="text" name="specialty" class="form-control" id="specialty">
        </div>

        <div class="form-group">
            <label for="experience">工作经验：</label>
            <input type="text" name="experience" class="form-control" id="experience">
        </div>


        <div class="form-group">
            <label for="studyEffort">学历：</label>
            <input type="text" name="studyEffort" class="form-control" id="studyEffort">
        </div>


        <div class="form-group">
            <label for="school">学校：</label>
            <input type="text" name="school" class="form-control" id="school">
        </div>

        <div class="form-group">
            <label for="tel">电话：</label>
            <input type="text" name="tel" class="form-control" id="tel">
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" name="email" class="form-control" id="email">
        </div>


        <div class="form-group">
            <label for="createTime">登记时间:</label>
            <input type="date" name="createTime" class="form-control" id="createTime">
        </div>

        <div class="form-group">
            <label for="content">描述信息:</label>
            <textarea class="form-control" rows="3" id="content" name="content"></textarea>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="homePage.jsp"> <input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>

</body>
</html>
