<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/8
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table align="center" width="500px" border="1px">
    <form action="action.do?method=modifyOneQjById&id=${qj.id}" method="post">
        <tr>
            <td>姓名</td>
            <td>
                ${qj.userName}
               <%-- <input type="text" name="userName" value="${qj.userName}"/>--%>
            </td>
        </tr>

        <tr>
            <td>请假天数</td>
            <td>
                ${qj.totalDay}
<%--                <input type="text" name="totalDay" value="${qj.totalDay}"/>--%>
            </td>
        </tr>

        <tr>
            <td>请假内容</td>
            <td>
                ${qj.content}
<%--                <input type="text" name="content" value="${qj.content}"/>--%>
            </td>
        </tr>

        <tr>
            <td>审批意见</td>
            <td>
                <input type="text" name="approval" value="${qj.approval}"/>
            </td>
        </tr>



        <tr>
            <td>是否注销</td>
            <td>
                <input type="radio" name="cancel" value="1" />已注销
                <input type="radio" name="cancel" value="0" checked/>未注销

            </td>
        </tr>



        <tr>
            <td>创建时间</td>
            <td>
                ${qj.createTime}
<%--                <input type="text" name="createTime" value="${fn:substring(qj.createTime,0,19)}"/>--%>
            </td>
        </tr>


        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </form>
</table>


</body>
</html>
