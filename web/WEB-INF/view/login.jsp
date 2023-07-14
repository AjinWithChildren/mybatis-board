<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/14
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
    <style>
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            margin-bottom: 10px;
            padding: 10px;
        }

        button {
            width: 100%;
            padding: 10px;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>로그인</h1>
    <form action="/login" method="post" id="login-form">
        <input type="text" id="userId" name="userId" placeholder="사용자 이름">
        <input type="password" id="userPwd" name="userPwd" placeholder="비밀번호">
        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>