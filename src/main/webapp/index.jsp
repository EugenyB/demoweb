<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= new Date() %>
</h1>
<br/>
<a href="hello-servlet.html">Hello Servlet</a>
<form action="say-hello.html" method="post">
    <label for="username">User</label>
    <input id="username" type="text" name="username"><br/>
    <label for="userage">age</label>
    <input id="userage" type="number" name="age">
    <button type="submit" value="from First button" name="btn">First</button>
    <button type="submit" value="from second button" name="btn">Second</button>
</form>
</body>
</html>