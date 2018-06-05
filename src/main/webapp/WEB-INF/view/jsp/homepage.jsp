<%-- 本页面将会包含包含JSP常用的知识点  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home page</title>
</head>
<body>
<jsp:include page="basic.jsp" />
Login Success，欢迎${sessionScope.user.name}访问<br>
</body>
</html>
