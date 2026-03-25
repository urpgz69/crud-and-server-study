<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Movie page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Movie.css">
</head>
<body>
<div id="movie-container">
    <c:forEach items="${movies}" var="movie">
        <div class="movie-card"
             data-num="${movie.num}"
             data-title="${movie.title}"
             data-actor="${movie.actor}"
             data-img="${movie.img}"
             data-story="${movie.story}">
            <div class="m-img" onclick="detailModal(this.closest('.movie-card'))">                <img src="${pageContext.request.contextPath}/movieFile/${movie.img}" alt="">            </div>
            <div class="m-title">${movie.title}</div>
            <div class="m-actor">${movie.actor}</div>
            <div hidden class="m-story">${movie.story}</div>
            <button onclick="updateModal(this.closest('.movie-card'))">update</button> <button onclick="deleteAl(${movie.num})">delete</button>
            <button class="movie-btn" onclick= location.href="update?num=${movie.num}" >update(jsp)</button>
        </div>
    </c:forEach>
    <div>
        <c:if test="${curPage > 1}">
            <button class="movie-btn pn" onclick="location.href='movie?p=${curPage - 1}'">prev</button>
        </c:if>
        <c:if test="${curPage < totalPage}">
            <button class="movie-btn pn" onclick="location.href='movie?p=${curPage + 1}'">next</button>
        </c:if>
    </div>

</div>
<button onclick="addModal()">add</button>

<div id="addModal" style="display:none; position:fixed; top:0; left:0;
     width:100%; height:100%; background:rgba(0,0,0,0.5);
     justify-content:center; align-items:center;">
    <div style="background:white; padding:20px;">
        <form action="${pageContext.request.contextPath}/movie" method="post" enctype="multipart/form-data">
            <div class="movie-reg">
                <input type="hidden" name="crud" value="c">
                <div><div>Title</div><div><input name="title"></div></div>
                <div><div>Actor</div><div><input name="actor"></div></div>
                <div><div>File</div><div><input type="file" name="file"></div></div>
                <div><div>Story</div><div><textarea rows="5" cols="40" name="story"></textarea></div></div>
                <div><button class="movie-btn">Add</button></div>
                <button type="button" name="add-modal-btn" onclick="document.getElementById('addModal').style.display='none'">닫기</button>
            </div>
        </form>

    </div>
</div>
<div id="updateModal" style="display:none; position:fixed; top:0; left:0;
     width:100%; height:100%; background:rgba(0,0,0,0.5);
     justify-content:center; align-items:center;">
    <div style="background:white; padding:20px;">
        <form action="${pageContext.request.contextPath}/movie" method="post" enctype="multipart/form-data">
            <div class="movie-reg">
                <input type="hidden" name="crud" value="u">
                <div><div>Title </div><div><input name="title" id="updateTitle"></div></div>
                <div><div>Actor </div><div><input name="actor" id="updateActor"></div></div>
                <div><div>File </div><div><input type="file" name="file" ></div></div>
                <div><div>Story </div><div><textarea rows="5" cols="40" name="story" id="updateStory"></textarea></div></div>
                <div><input type="hidden" name="num" id="updateNum"></div>
                <div><button class="movie-btn">update</button></div>
                <button name="update-modal-btn" onclick="document.getElementById('updateModal').style.display='none'">닫기</button>
            </div>
        </form>

    </div>
</div>
<div id="detailModal" style="display:none; position:fixed; top:0; left:0;
     width:100%; height:100%; background:rgba(0,0,0,0.5);
     justify-content:center; align-items:center;">
    <div style="background:white; padding:20px;">
        <div class="movie-detail">
            <div><div class="detailImg"><img id="detailImg" src="" alt=""></div></div>

            <div><div class="col-1">Title.</div><div class="col-2" id="detailTitle"></div></div>
            <div><div class="col-1">Actor.</div><div class="col-2" id="detailActor"></div></div>
            <div><div class="col-1">Story.</div><div class="col-2" id="detailStory"></div></div>
        </div>
        <button type="button" onclick="document.getElementById('detailModal').style.display='none'">닫기</button>
    </div>
</div>
<hr>

<div>
    <a href="movie?p=1"> first</a>
    <c:forEach begin="1" end="${totalPage}" var="i">
        <a href="movie?p=${i}" class="page-btn">[${i}]</a>
    </c:forEach>
    <a href="movie?p=${totalPage}">end</a>
</div>


</body>
<script src="${pageContext.request.contextPath}/jsp/movie/Moviejs.js"></script>
</html>