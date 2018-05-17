<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="/js/basic/index.js"></script>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui.js"></script>
</head>
<body>
<form id="form_login" action="">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="userPassword" name="password"></td>
        </tr>
        <tr>
            <td><input type="button" value="确定" onclick="login()"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<script>
    $(document).ready(function() {
        console.log("JS已引入")
    });
</script>
</body>
</html>
