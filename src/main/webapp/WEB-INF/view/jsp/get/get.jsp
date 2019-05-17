<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic JSP</title>
    <jsp:include page="../basic.jsp" />
</head>
<body>
<a href="/getAll/getUserList" target="_blank">getUserList</a><br>
<button onclick="hrefToAnother()">跳转到一个页面，查看请求参数，encode</button>
<button onclick="hrefToAnother2()">跳转到一个页面，查看请求参数，未加encode，会产生错误</button>
<script>
    console.log("JS已引入");
    function hrefToAnother() {
        var searchParams = {
            "cityID": "test1",
            "areaID": "test2"
        };
        location.href = '/getAll/getParams?searchParams=' + encodeURIComponent(JSON.stringify(searchParams))
    }
    function hrefToAnother2() {
        var searchParams = {
            "cityID": "test1",
            "areaID": "test2"
        };
        location.href = '/getAll/getParams?searchParams=' + JSON.stringify(searchParams)
    }
</script>
</body>
</html>
