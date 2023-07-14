<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/14
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시판</title>
  <style>
    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
    }

    h1 {
      text-align: center;
    }

    ul {
      list-style-type: none;
      padding: 0;
    }

    li {
      border: 1px solid #ccc;
      padding: 10px;
      margin-bottom: 10px;
    }

    li h2 {
      margin: 0;
    }

    li p {
      margin-top: 5px;
    }

  </style>
</head>
<body>
<div class="container">
  <h1>게시판</h1>
  <ul id="post-list">
    <c:forEach var="board" items="${boards}">
      <c:if test="${!board.deleted}">
      <li>
        <h2><a href="/boards/${board.boardNo}" style="text-decoration: none">${board.boardTitle}</a></h2>
        <div style="display: flex; align-items: center; justify-content: flex-start">
          <p style="margin-right: 10px">작성자: ${board.userId}</p>
          <p>작성시간: ${board.createdAt}</p>
        </div>
      </li>
      </c:if>
    </c:forEach>
  </ul>
</div>

<div style="display: flex; align-items: center; justify-content: center">
  <a href="/boards/register">작성하러 가기</a>
</div>

</body>
</html>
