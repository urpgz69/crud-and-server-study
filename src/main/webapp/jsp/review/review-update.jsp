<%--
  Created by IntelliJ IDEA.
  User: sangjun
  Date: 2026-03-30
  Time: 오전 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review Update</title>
    <script src="${pageContext.request.contextPath}/js/Review.js"></script>
</head>
<body>
<form action="review-update" method="post">
    <input type="hidden" name="reNo" value="${review2.reNo}">
    <div class="review-detail-wrap">
        <div>
            <div>No. ${review2.reNo}</div>
        </div>
        <div>
            <div class="col-1">Title</div>
            <div class="col-2">
                <input name="reTitle" id="updateTitle" value="${review2.reTitle}" />
            </div>
        </div>
        <div>
            <div class="col-1">Content</div>
            <div class="col-2">
                <textarea name="reText" id="updateText" oninput="countText()">${review2.reText}</textarea>
            </div>
        </div>
        <div>
            <div class="col-1">Text Length</div>
            <div class="col-2">
                <span class="cntSpan">${review2.reText.length()}</span> characters
            </div>
        </div>
        <div>
            <div>Posted at ${review2.reDate}</div>
        </div>
    </div>
    <div>
        <button type="submit">update</button>
        <button type="button" onclick="history.back();">cancel</button>
        <button type="button" onclick="history.go(-2)">list</button>
    </div>
</form>
</body>
</html>
