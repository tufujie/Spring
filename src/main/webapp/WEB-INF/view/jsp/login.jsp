<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- 动态include指令引入页面 --%>
<jsp:include page="basic.jsp" />
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
            <td><input type="button" value="确定" onclick="login()"></td>
            <td><input type="reset" value="重置"></td>
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
</body>
</html>
