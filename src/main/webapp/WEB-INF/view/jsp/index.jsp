<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="/js/basic/index.js"></script>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/js/jquery.md5.js"></script>
</head>
<body>
<form id="form_login" action="">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="name" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <input type="hidden" id="pwd" name="pwd">
            <td><input id="password" name="password" onblur="md5Encode()"></td>
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
