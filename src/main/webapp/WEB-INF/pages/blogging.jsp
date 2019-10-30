<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写文章</title>
</head>
<body>
    <!--content start-->
    <div id="content">
        <!--left-->
        <div class="left" id="blogging">
            <c:choose>
                <c:when test="${article==null}">
                    <form action="./article/addArticle?author=${sessionScope.user.user_name}" method="post">
                        标题：<input type="text" name="article_title"><br/>
                        <textarea name="article_text" cols="85" rows="35"></textarea><br>
                        <input type="submit" value="提交">
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="./article/update?id=${article.article_id}" method="post">
                        标题：<input type="text" name="article_title" value="${article.article_title}"><br/>
                        <textarea name="article_text" cols="85" rows="35">${article.article_text}</textarea><br>
                        <input type="submit" value="修改">
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <!--end left -->
    </div>
    <!--content end-->
</body>
</html>
