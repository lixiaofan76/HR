<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/8
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" width="500px" border="1px">
    <form action="action.do?method=midifySalaryById&id=${salary.id}" method="post">
        <tr>
            <td>基本薪资</td>
            <td>
                <input type="text" name="basic" value="${salary.basic}"/>
            </td>
        </tr>



        <tr>
            <td>饭补</td>
            <td>
                <input type="text" name="eat" value="${salary.eat}"/>
            </td>
        </tr>


        <tr>
            <td>住房补贴</td>
            <td>
                <input type="text" name="house" value="${salary.house}"/>
            </td>
        </tr>


        <tr>
            <td>全勤奖</td>
            <td>
                <input type="text" name="duty" value="${salary.duty}"/>
            </td>
        </tr>


        <tr>
            <td>扣税</td>
            <td>
                <input type="text" name="scot" value="${salary.scot}"/>
            </td>
        </tr>


        <tr>
            <td>罚款</td>
            <td>
                <input type="text" name="punishment" value="${salary.punishment}"/>
            </td>
        </tr>


        <tr>
            <td>其他补助</td>
            <td>
                <input type="text" name="other" value="${salary.other}"/>
            </td>
        </tr>



        <tr>
            <td>发放时间</td>
            <td>
                <input type="date" name="grantTime" value="${fn:substring(salary.grantTime,0,19)}"/>
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
