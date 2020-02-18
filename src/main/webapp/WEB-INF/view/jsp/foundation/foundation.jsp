<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>基金</title>
    <jsp:include page="../basic.jsp" />
    <script type="text/javascript" src="/js/foundation/foundation.js"></script>
</head>
<body>
<form style="text-align: center" id="objectPost" action="" method="post">
    <table>
        <tr>
        <th>基金编码</th>
        <th>基金名称</th>
        </tr>
        <tr>
            <td><input id="code" name="code" value=""></td>
            <td><input id="name" name="name" value=""></td>
            <td><input type="button" value="添加基金" onclick="addInfo(1)"></td>
        </tr>
    </table>
</form>
<h1 align="center">基金列表</h1>
<table align="center" bgcolor="#faebd7" border="1" width="300px">
    <th>基金编码</th>
    <th>基金名称</th>
    <th>操作</th>
    <c:forEach var="item" items="${foundationList}">
        <tr>
            <td>${item.code}</td>
            <td>${item.name}</td>
            <td style="color: yellow; cursor: pointer;"><a href="/foundation/getFoundationDetail?code=${item.code}" target="_blank">查看详情</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
