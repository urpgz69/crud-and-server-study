<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sangjun
  Date: 2026-03-24
  Time: 오후 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<h2>edit page</h2>
<form action="user-edit" method="post">
<div class="info-wrap">
  <div class="info-row">
    <div>ID.</div>
    <div>${sessionScope.user.id}</div>
  </div>
  <div class="info-row">
    <div>PW.</div>
    <div><input type="text" name="pw" value="${sessionScope.user.pw}"></div>
  </div>
  <div class="info-row">
    <div>Name.</div>
    <div><input type="text" name="name" value="${sessionScope.user.name}"></div>
  </div>
  <div>
    <button class="info-btn" onclick="">edit</button>
    <button type="button" class="info-btn" onclick="history.back()">cancel</button>
  </div>
  </div>
  </form>




</body>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
</html>
