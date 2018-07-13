<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>testPost</title>
    <%-- 动态include指令引入页面 --%>
    <jsp:include page="../basic.jsp" />
    <script type="text/javascript" src="/js/post/post.js"></script>
</head>
<body>
<form id="" action="" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" id="userPassword" name="password"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input id="phone" name="phone"></td>
        </tr>

        <tr>
            <td><input type="button" value="Post1" onclick="Post(1)"></td>
            <td><input type="button" value="Post2" onclick="Post(2)"></td>
            <td><input type="button" value="Post3" onclick="Post(3)"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
