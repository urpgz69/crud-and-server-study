<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<header><h1>      review page        </h1></header>

<c:forEach items="${reviews}" var="r">

${r.rNo} / ${r.rTitle}



</c:forEach>


</body>
</html>
