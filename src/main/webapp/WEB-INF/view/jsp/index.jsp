<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- 引入别的页面的静态文件，这样重复代码少，代码整洁 --%>
<%-- 上面是JSP的注释方式 --%>
<html>
<head>
    <title>index</title>
</head>
<body>
<jsp:include page="basic.jsp" />
<h1>欢迎来到Jef的小世界</h1>
<a href="/user/gotoLogin">登录</a>，没有账号<a href="/user/gotoRegister">点击注册</a><br>
<a href="/jsp/introduce">JSP demo</a>
<script>
    $(document).ready(function() {
        console.log("JS已引入")
    });
</script>
</body>
</html>
