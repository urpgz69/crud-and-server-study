<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>sj-board</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<div class="login-area">
    <div class="login-box">
<jsp:include page="${loginPage}"></jsp:include><br>
</div>
</div>


<div class="container">
    <div class="title">
        <a href="hello-servlet" ><h2>sj-board</h2></a>
    </div>
    <div class="menu">
        <div><a href="menu1" id="menu1"></a></div>
        <div><a href="movie" id="movie"></a></div>
        <div><a href="review" id="review"></a></div>
    </div>

    <div class="content">
        <jsp:include page="${content}" />
    </div>
</div>

<c:if test="${not empty msg}" >
    <div class="i-modal">
        <div class="warning-msg">${msg}</div>
        <button class="index-btn" onclick="this.closest('.i-modal').style.display='none'">닫기</button>
    </div>
</c:if>



</body>
</html>
