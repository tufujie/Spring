<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>modelTest page</title>
</head>
<body>
<jsp:include page="basic.jsp" />
<c:if test="${!empty testTest}">对象有值</c:if>
<c:if test="${empty testTest}">对象没有值</c:if><br>
<c:if test="${!empty testTest.name}">对象中属性有值</c:if>
<c:if test="${empty testTest.name}">对象中属性没有值</c:if><br>
<c:choose>
    <c:when test="${!empty testTest}">
        对象有值2
    </c:when>
    <c:otherwise>
        对象没有值2
    </c:otherwise>
</c:choose>
</body>
</html>
