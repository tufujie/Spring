<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>查看所有用户信息</title>
</head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");
    // 这里的配置信息同 jdbc.properties，配置信息可以配置在web.xml中，然后通过application.getInitParameter("param_name配置的值")进行获取
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/all_test", "root", "root");
    Statement statement = connection.createStatement();
    String sql = "select * from user";
    ResultSet rs = statement.executeQuery(sql);
%>
<table bgcolor="#faebd7" border="1" width="300px">
    <th>用户名</th>
    <th>年龄</th>
    <th>订单信息</th>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("age") %></td>
        <td><a href='/orderInfo/getOrderInfoByUserId/<%= rs.getLong("id")%>' target='_blank'>查看购买物品</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
