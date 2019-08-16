<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/3
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table align="center" width="500px" border="1px">
    <form action="action.do?method=modify&id=${users.id}" method="post">
       <%-- <tr>
            <td>ID</td>
            <td>
        ${users.id}
            </td>
        </tr>--%>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="userName" value="${users.userName}"/>
            </td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <c:choose>
                    <c:when test="${users.gender == false}">
                        <input type="radio" name="gender" value="0" checked/>男
                        <input type="radio" name="gender" value="1"/>女
                    </c:when>
                    <c:when test="${users.gender == true}">
                        <input type="radio" name="gender" value="0"/>男
                        <input type="radio" name="gender" value="1" checked/>女
                    </c:when>
                </c:choose>

            </td>
        </tr>

        <tr>
            <td>生日</td>
            <td>
                <input type="text" name="birthday" value="${fn:substring(users.birthday,0,19)}"/>
            </td>
        </tr>

        <tr>
            <td>创建时间</td>
            <td>
                <input type="text" name="createTime" value="${fn:substring(users.createTime,0,19)}"/>
            </td>
        </tr>

        <tr>
            <td>描述</td>
            <td>
                <input type="text" name="content" value="${users.content}"/>
            </td>
        </tr>

        <tr>
            <td>用户角色</td>
            <td>
                <input type="text" name="roleId" value="${users.roleId}"/>
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
