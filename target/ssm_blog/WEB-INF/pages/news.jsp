<%@ page import="hao.you.utils.ToolMethodUtil" %><%--
  Created by IntelliJ IDEA.
  User: 昊
  Date: 2019/7/31
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>
<!--content start-->
<div id="content">
    <!--left-->
    <div class="left" id="news">
        <div class="news_content">
            <div class="news_top">
                <h1>${article.article_title}</h1>
                <p>
                    <span class="left sj">时间:${article.article_time}</span><span class="left fl">分类:${article.article_class}</span>
                    <span class="left author">${article.article_author}</span>
                </p>
                <div class="clear"></div>
            </div>
            <div class="news_text">
                ${article.article_text}
            </div>
        </div>
    </div>
    <!--end left -->
    <div class="clear"></div>
</div>
<!--content end-->
</body>
</html>