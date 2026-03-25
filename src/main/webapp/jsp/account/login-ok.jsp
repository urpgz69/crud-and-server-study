<%--
  Created by IntelliJ IDEA.
  User: sangjun
  Date: 2026-03-24
  Time: 오전 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
${sessionScope.user.id}(${sessionScope.user.name}) 님 환영합니다. <br>
<button onclick="location.href='user-info'">myPage</button>
<button onclick="logout()">logout</button>
</body>
</html>
