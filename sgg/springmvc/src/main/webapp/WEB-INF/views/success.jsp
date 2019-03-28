<%--
  Created by IntelliJ IDEA.
  User: zhuwb
  Date: 2019/3/25
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h4>Success Page</h4>
    time:${requestScope.time}
    <br/>
    names:${requestScope.names}
    <br/>
    request user:${requestScope.user}
    <br/>
    session user:${sessionScope.user}
    <br/>
    request school:${requestScope.school}
    <br/>
    session school:${sessionScope.school}
</body>
</html>
