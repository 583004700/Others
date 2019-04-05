<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>input</title>
</head>
<body>
    <!--modelAttribute代表请求域中的变量-->
    <form:form action="emp" method="post" modelAttribute="employee">
        LastName：<form:input path="lastName"/>
        <br/>
        Email:<form:input path="email"/>
        <br/>
        <%
            Map<String,String> genders = new HashMap<String,String>();
            genders.put("1","Male");
            genders.put("0","Female");
            request.setAttribute("genders",genders);
        %>
        Gender:<form:radiobuttons path="gender" items="${genders}"/>
        <br/>
        Department：<form:select path="department.id" items="${departments}" itemLabel="departmentName"
        itemValue="id"></form:select>
        <br/>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
