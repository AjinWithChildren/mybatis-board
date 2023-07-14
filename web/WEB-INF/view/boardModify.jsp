<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/14
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판 상세보기</title>
    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        #post-form {
            margin-bottom: 20px;
        }

        #post-title,
        #post-content {
            display: block;
            width: 100%;
            margin-bottom: 10px;
            padding: 5px;
        }

        button {
            display: block;
            margin: 10px 0;
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
    <h1>게시판 수정하기</h1>

    <form action="/boards/modify" method="post" id="post-form">
        <input type="hidden" name="boardNo" value="${board.boardNo}">
        <input type="text" id="post-title" name="boardTitle" value="${board.boardTitle}">
        <textarea id="post-content" name="boardContent" placeholder="내용">
            ${board.boardContent}
        </textarea>
        <button type="submit">수정하기</button>
    </form>
</div>

</body>
</html>