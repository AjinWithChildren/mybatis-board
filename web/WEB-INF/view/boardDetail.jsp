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

        .post-details {
            border: 1px solid #ccc;
            padding: 20px;
        }

        .post-details h2 {
            margin: 0;
        }

        .post-details p {
            margin: 5px 0;
        }

        .post-content {
            margin-top: 10px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"],
        textarea {
            display: block;
            width: 100%;
            margin-bottom: 10px;
            padding: 5px;
        }

        button {
            display: block;
            margin: 10px 0;
        }

        .comment {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
        }

        .comment p {
            margin: 5px 0;
        }

        .comment-author {
            font-weight: bold;
        }

        .comment-date {
            font-size: 12px;
            color: #888;
        }
        .comment_change_box {
            display: flex;
            align-items: center;
            justify-content: center;
            flex-wrap: wrap;
        }

        .comment_change_box a {
            text-decoration: none;
            color: red;
            margin-right: 10px;
        }

        .commentModify {
            display: none;
            width: 100%;
        }

        .commentModify button {
            margin-right: 10px;
        }

        form {
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시판 상세보기</h1>
    <div class="post-details">
        <h2>${board.boardTitle}</h2>
        <p>작성자: ${board.userId}</p>
        <p>작성일: ${board.createdAt}</p>
        <div class="post-content">
            <p>
                ${board.boardContent}
            </p>
        </div>
    </div>

    <div style="display: flex; align-items: center; justify-content: space-between">
        <div>
            <a href="/boards">목록으로</a>
        </div>

        <c:if test="${userDetails.userNo == board.userNo}">
            <div style="margin-top: 10px">
                <a href="/boards/${boardNo}/modify" style="margin-right: 10px">수정</a>
                <a href="/boards/${boardNo}/delete">삭제</a>
            </div>
        </c:if>
    </div>



    <div class="container">
        <h1>댓글</h1>
        <form action="/comments/register" method="post" id="comment-form">
            <input type="hidden" name="boardNo" value="${board.boardNo}">
            <input type="hidden" name="userNo" value="${userDetails.userNo}">
            <input type="hidden" name="userId" id="comment-author" value="${userDetails.userId}">
            <textarea id="comment-content" name="commentContent" placeholder="댓글 내용"></textarea>
            <button type="submit">댓글 작성</button>
        </form>
        <div id="comment-list">
            <c:forEach var="comment" items="${comments}">
            <div class="comment">
                <p class="comment-author">${comment.userId}</p>
                <p class="comment-date">${comment.commentWriteTime}</p>
                <p class="comment-content">${comment.commentContent}</p>

                <c:if test="${comment.userNo == userDetails.userNo}">
                    <div class="comment_change_box">
                        <div class="commentModify">
                            <form action="/comments/modify" method="post">
                                <input type="hidden" name="boardNo" value="${board.boardNo}">
                                <input type="hidden" name="commentNo" value="${comment.commentNo}">
                                <input type="text" name="commentContent" value="${comment.commentContent}">
                                <div style="display: flex; align-content: center; justify-content: center">
                                    <button type="submit">수정하기</button>
                                    <button type="button" onclick="commentModifyFormCancel(this)">취소</button>
                                </div>
                            </form>
                        </div>
                        <button type="button" onclick="commentModifyFormDisplayFunc(this)" style="margin-right: 10px">수정</button>

                        <div class="commentDeleteBox">
                            <form action="/comments/delete">
                                <input type="hidden" name="boardNo" value="${board.boardNo}">
                                <input type="hidden" name="commentNo" value="${comment.commentNo}">
                                <button type="submit">삭제</button>
                            </form>
                        </div>
                    </div>
                </c:if>
            </div>

            </c:forEach>
        </div>
    </div>
</div>

<script>

    function commentModifyFormDisplayFunc(element) {
        element.parentNode.childNodes[1].style.display = "block";
    }

    function commentModifyFormCancel(element){
        element.parentNode.parentNode.parentNode.style.display = "none";
    }


</script>

</body>
</html>