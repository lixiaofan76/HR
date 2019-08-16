<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/4
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table align="center" width="500px" border="1px">
    <form action="action.do?method=modify&id=${Applicant.id}" method="post">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" value="${Applicant.name}"/>
            </td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <c:choose>
                    <c:when test="${Applicant.gender == false}">
                        <input type="radio" name="gender" value="0" checked/>男
                        <input type="radio" name="gender" value="1"/>女
                    </c:when>
                    <c:when test="${Applicant.gender == true}">
                        <input type="radio" name="gender" value="0"/>男
                        <input type="radio" name="gender" value="1" checked/>女
                    </c:when>
                </c:choose>

            </td>
        </tr>

        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" value="${Applicant.age}"/>
            </td>
        </tr>

        <tr>
            <td>岗位</td>
            <td>
                <input type="text" name="job" value="${Applicant.job}"/>
            </td>
        </tr>


        <tr>
            <td>专业</td>
            <td>
                <input type="text" name="specialty" value="${Applicant.specialty}"/>
            </td>
        </tr>

        <tr>
            <td>工作经验</td>
            <td>
                <input type="text" name="experience" value="${Applicant.experience}"/>
            </td>
        </tr>

        <tr>
            <td>学历</td>
            <td>
                <input type="text" name="studyEffort" value="${Applicant.studyEffort}"/>
            </td>
        </tr>


        <tr>
            <td>毕业学校</td>
            <td>
                <input type="text" name="school" value="${Applicant.school}"/>
            </td>
        </tr>


        <tr>
            <td>电话</td>
            <td>
                <input type="text" name="tel" value="${Applicant.tel}"/>
            </td>
        </tr>

        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" value="${Applicant.email}"/>
            </td>
        </tr>


        <tr>
            <td>登记时间</td>
            <td>
                <input type="text" name="createTime" value="${fn:substring(Applicant.createTime,0,19)}"/>
            </td>
        </tr>



        <tr>
            <td>详细经历</td>
            <td>
                <input type="text" name="content" value="${Applicant.content}"/>
            </td>
        </tr>
        <tr>
            <td>是否录用</td>
            <td>
                <c:if test="${Applicant.isHiring}">已通过</c:if>
                <c:if test="${!Applicant.isHiring}">待审核</c:if>
               <%-- <input type="text" name="isHiring" value="${Applicant.isHiring}"/>--%>
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
