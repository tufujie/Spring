<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- 引入别的页面的静态文件，这样重复代码少，代码整洁 --%>
<%-- 上面是JSP的注释方式，JSP注释 --%>
<html>
<head>
    <title>login page</title>
</head>
<body>
<jsp:include page="basic.jsp" />
<h1>Welcome to Jef's small world</h1>
<%--<a href="/user/gotoLogin" target="_blank">登录</a>，--%><span>没有账号<a href="/user/gotoRegister" target="_blank">点击注册</a></span><br>
<form id="form_login_two" action="/login/loginTwo" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="name" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <input type="hidden" id="pwd" name="pwd">
            <td><input type="password" id="password" name="password" onblur="md5Encode()"></td>
        </tr>
        <tr>
            <td><input type="button" value="登录" onclick="login()"></td>
            <td><input type="reset" value="重置"></td>
            <td><input type="button" value="一键登录" onclick="oneKeyLogin()"></td>
        </tr>
    </table>
    <font color="red">${requestScope.message}</font>
</form>
<%--<form id="form_login_one" action="/login/loginOne" method="post">
    <table>
        <tr>
            <td><label>登录名</label></td>
            <td><input type="text" id="loginName" name="name"></td>
        </tr>
        <tr>
            <td><label>密码</label></td>
            <td><input type="password" id="loginPassword" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录" /></td>
        </tr>
    </table>
    <font color="red">${requestScope.message}</font>
</form>--%>
<script>
    $(document).ready(function() {
        console.log("JS已引入")
    });
</script>
</body>
</html>
