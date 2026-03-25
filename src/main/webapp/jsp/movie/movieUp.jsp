<%--
  Created by IntelliJ IDEA.
  User: sangjun
  Date: 2026-03-23
  Time: 오전 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: flex; justify-content: center;">

    <form action="update" method="post" enctype="multipart/form-data">
    <div class="movie-update">
        <div>
            <div class="col-1">No.</div>
            <div class="col-2"><input type="text" name="" id="" value="${movie.num}"></div>
        </div>
        <div>
            <div><img src="${pageContext.request.contextPath}/movieFile/${movie.img}" alt=""></div>
        </div>
        <div>
            <div class="col-1">Title.</div>
            <div class="col-2"><input type="text" name="title" id="" value="${movie.title}"></div>

        </div>
        <div>
            <div class="col-1">Actor.</div>
            <div class="col-2"><input type="text" name="actor" id="" value="${movie.actor}"></div>
        </div>

        <div>
            <div class="col-1">Story.</div>
            <div class="col-2"><textarea rows="5" cols="40" name="story" id="" value="${movie.story}"></textarea></div>
        </div>
            <button ></button>
    </div>
    </form>
</div>
</body>
</html>
