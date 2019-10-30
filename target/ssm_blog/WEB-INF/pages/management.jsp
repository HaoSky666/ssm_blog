<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 昊
  Date: 2019/8/3
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <div class="content_text">
        <c:forEach items="${articles01}" var="article">
            <!--wz-->
            <div class="wz">
                <h3><a href="javascript:void(0)" onclick="onclick_news('${article.article_id}')" title="${article.article_title}">${article.article_title}</a></h3>
                <dl>
                    <dd>
                        <p class="dd_text_1">${fn:substring(article.article_text,0,47)}...</p>
                        <button onclick="deleteArticle(${article.article_id})">删除</button>
                        <button onclick="updateArticle(${article.article_id})">修改</button>
                    </dd>
                    <div class="clear"></div>
                </dl>
                <HR width="700px">
            </div>
            <!--wz end-->
        </c:forEach>
        <div class="page">
            <a href="javascript:void(0)" onclick="onclick_management_page(0)">首页</a>
            <a href="javascript:void(0)" onclick="onclick_management_page(${page01-1})">上一页</a>
            <a href="javascript:void(0)" onclick="onclick_management_page(${page01+1})">下一页</a>
            <a href="javascript:void(0)" onclick="onclick_management_page(${allpage01-1})">尾页</a>
            <i>页码&nbsp;${page01+1}</i>
        </div>
    </div>
</body>
</html>
