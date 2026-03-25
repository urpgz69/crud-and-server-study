<%--
  Created by IntelliJ IDEA.
  User: sangjun
  Date: 2026-03-24
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<form action="user-login" method="post">

    <input type="text" placeholder="ID" name="id" id=""> <br>
    <input type="text" placeholder="PW" name="pw" id=""> <br>
    <button name="login-btn">login</button>
</form>
</body>
</html>
