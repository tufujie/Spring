<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<%-- if表达式 --%>
<c:if test="${admin == true}">
    admin存在
</c:if>
<br>
<%-- choose表达式 --%>
<c:choose>
    <c:when test="${status == '1'}">
        when status == '1'
    </c:when>
    <c:when test="${status == '2'}">
        when status == '2'
    </c:when>
    <c:otherwise>
        otherwise status == '3'
    </c:otherwise>
</c:choose>
<%-- forEach表达式 --%>
<table bgcolor="#faebd7" border="1" width="300px">
    <th>用户名</th>
    <th>年龄</th>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>
<br>
<%-- 设置值，前端设值 --%>
<c:set var="salary" scope="session" value="${2000*2}"/>
<%-- 获取值展示，类似于JSP输出表达式 --%>
<c:out value="${salary}"/><br>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /><br>
<fmt:formatNumber value="${money}" type="number" maxFractionDigits="4" />
</body>
</html>
