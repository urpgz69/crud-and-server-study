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
    <title>Review Detail</title>
</head>
<body>
<div class="review-detail-wrap">
    <div>
        <div>No. ${review2.reNo}</div>
    </div>
    <div>
        <div class="col-1">Title</div>
        <div class="col-2">
            <input name="reTitle" value="${review2.reTitle}" readonly/>
        </div>
    </div>
    <div>
        <div class="col-1">Content</div>
        <div class="col-2">
            <textarea name="reText" readonly>${review2.reText}</textarea>
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
    <button onclick="location.href='review-update?no=${review2.reNo}'">update</button>
    <button onclick="location.href='review-delete?no=${review2.reNo}'">delete</button>
    <button onclick="location.href='review'">back</button>
</div>
</body>
</html>
