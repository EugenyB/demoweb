<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 21.09.2021
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <jsp:useBean id="ui" type="com.example.demoweb.UserInfo" scope="request"/>
    <h1>Hello, ${ui.userName}!</h1>
    <h2>${ui.description}</h2>
</body>
</html>
