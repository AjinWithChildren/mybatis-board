<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/14
  Time: 9:13 AM
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
    <h1>게시판</h1>
    <form action="/boards/register" method="post" enctype="multipart/form-data" id="post-form">
        <input type="hidden" name="userNo" value="${userDetails.userNo}">
        <input type="hidden" name="userId" value="${userDetails.userId}">
        <input type="text" id="post-title" name="boardTitle" placeholder="제목">
        <textarea id="post-content" name="boardContent" placeholder="내용"></textarea>
        <input type="file" multiple name="uploadFiles">
        <button type="submit">글 작성</button>
    </form>
    <ul id="post-list"></ul>
</div>
</body>
</html>