<%--
  Created by IntelliJ IDEA.
  User: zhuwb
  Date: 2019/3/25
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <a href="/testPathVariable/1">testPathVariable</a>
    <br/>
    <a href="/testAntPath/sdfsf/abc">testAntPath</a>
    <br/>
    <a href="helloworld">Hello World</a>
    <form action="/testMethod" method="post">
        <input type="submit"/>
    </form>

    <a href="/testParamsAndHeaders?username=atguigu&age=20">testParamsAndHeaders</a>
</body>
</html>
