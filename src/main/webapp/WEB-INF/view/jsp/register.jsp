<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<jsp:include page="basic.jsp" />
<form id="form_register" action="/user/register1" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="userPassword" name="password" onblur="md5Encode()"></td>
        </tr>
        <tr>
            <td>重复密码</td>
            <td><input id="repeatUserPassword" name="repeatUserPassword" onblur="md5Encode()"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input id="phone" name="phone"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input id="age" name="age"></td>
        </tr>
        <tr>
            <td><input type="button" value="注册" onclick="register()"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
    <font color="red">${requestScope.registerErrorMessage}</font>
</form>
</body>
</html>
