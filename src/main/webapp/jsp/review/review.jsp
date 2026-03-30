<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/review.css">
    <script src="${pageContext.request.contextPath}/js/Review.js"></script>
</head>
<body>
<header><h1>      review page        </h1></header>


    <div class="review-container">
        <div>
            <div class="review-title">
                Review Page <a onclick="reviewAddModal()">[write]</a>
            </div>
            <c:forEach var="r" items="${review}">
                <div class="review-row">
                    <div>
                        <span onclick="location.href='review-detail?no=${r.reNo}'">${r.reTitle }</span>
                    </div>
                    <div>${r.reDate }</div>
                </div>
            </c:forEach>
        </div>
    </div>
<div>
    <a href="review?p=1"> first</a>
    <c:forEach begin="1" end="${totalPage}" var="i">
        <a href="review?p=${i}" class="page-btn">[${i}]</a>
    </c:forEach>
    <a href="review?p=${totalPage}">end</a>
</div>

<div id="reviewAddModal" style="display:none; position:fixed; top:0; left:0;
     width:100%; height:100%; background:rgba(0,0,0,0.5);
     justify-content:center; align-items:center;">
    <div style="background:white; padding:20px;">
        <form action="${pageContext.request.contextPath}/review-add" method="post" >
            <div class="review-reg">
                <div><div>Title </div><div><input name="title" id="title"></div></div>
                <div><div>Text </div><div><textarea rows="5" cols="40" name="story" id="text"></textarea></div></div>
                <div><button class="update-btn">update</button></div>
                <button name="reviewAdd-modal-btn" onclick="document.getElementById('reviewAddModal').style.display='none'">닫기</button>
            </div>
        </form>

    </div>
</div>





</body>
</html>
