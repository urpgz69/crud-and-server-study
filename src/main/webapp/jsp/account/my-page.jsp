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
<div class="info-wrap">
  <div class="info-row">
    <div>ID.</div>
    <div>${sessionScope.user.id}</div>
  </div>
  <div class="info-row">
    <div>PW.</div>
    <div>${sessionScope.user.pw}</div>
  </div>
  <div class="info-row">
    <div>Name.</div>
    <div>${sessionScope.user.name}</div>
  </div>
  <div>

    <button class="info-btn">edit</button>
    <button class="info-btn" onclick="AccountDelModal()">Account delete</button>
  </div>
</div>


<div id="AccountDelModal" style="display:none; position:fixed; top:0; left:0;
     width:100%; height:100%; background:rgba(0,0,0,0.5);
     justify-content:center; align-items:center;">
  <div style="background:white; padding:20px;">
    <form action="user-info" method="post" >
      <div class="mypage-reg">
        <input hidden value="${sessionScope.user.id}" name="id">

        <div><div>Password</div><div><input type="text" name="password"></div></div>
        <div><button class="account-del-modal-btn">delete</button></div>
        <button type="button" name="account-del-modal-btn" onclick="document.getElementById('AccountDelModal').style.display='none'">닫기</button>
      </div>
    </form>

  </div>
</div>
<c:if test="${not empty msg2}" >
  <div class="modal">
<div class="warning-msg2">${msg2}</div>
  <button class="info-btn" onclick="this.closest('.modal').style.display='none'">닫기</button>
  </div>
</c:if>


</body>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
</html>
