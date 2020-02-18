<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>福彩批量插入</title>
    <jsp:include page="../basic.jsp" />
    <script type="text/javascript" src="/js/foundation/foundation.js"></script>
    <script>
        var code = '${foundation.code}';
    </script>
</head>
<body>
<td style="color: yellow; cursor: pointer;"><a href="/foundation/getFoundationDetail?code=${item.code}" target="_blank">${foundation.name}</a></td>
<form id="objectPost" action="" method="post">
    <%-- 变化部分开始，table--%>




    <%-- 变化部分结束，table--%>
</form>
<input type="button" value="添加基金净值" onclick="batchAddInfo(1)">
</body>
</html>
