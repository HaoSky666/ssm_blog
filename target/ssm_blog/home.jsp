<%--
  Created by IntelliJ IDEA.
  User: 昊
  Date: 2019/8/2
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <%
        request.getRequestDispatcher("./article/index").forward(request, response);
    %>
</body>
</html>
