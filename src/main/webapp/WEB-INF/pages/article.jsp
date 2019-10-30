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
<div class="s_tuijian">
    <c:choose>
        <c:when test="${sessionScope.user==null}">
            <h2>文章<span>推荐</span></h2>
        </c:when>
        <c:otherwise>
            <h2>文章<span>推荐</span>
                <button onclick="onclick_blogging()" id="blogging">写文章</button>
            </h2>
        </c:otherwise>
    </c:choose>

</div>
<div class="content_text">
    <c:forEach items="${articles}" var="article">
        <!--wz-->
        <div class="wz">
            <h3><a href="javascript:void(0)" onclick="onclick_news('${article.article_id}')"
                   title="${article.article_title}">${article.article_title}</a></h3>
            <dl>
                    <%--<dt><img src="./images/s.jpg" width="200" height="123" alt=""></dt>--%>
                <dd>
                    <%--文章长度大于47则以...结尾--%>
                    <c:choose>
                        <c:when test="${fn:length(article.article_text)>47}">
                            <p class="dd_text_1">${fn:substring(article.article_text,0,47)}...</p>
                        </c:when>
                        <c:otherwise>
                            <p class="dd_text_1">${article.article_text}</p>
                        </c:otherwise>
                    </c:choose>
                    <p class="dd_text_2">
                        <span class="left author">${article.article_author}</span>
                        <span class="heart" id="like1" rel="like"></span>
                        <span class="likeCount" id="likeCount1">0</span>
                            <%--<span class="left sj">时间:${article.article_time}</span>--%>
                            <%--<span class="left fl">分类:<a href="#" title="${article.article_class}">${article.article_class}</a></span>--%>
                    </p>
                </dd>
                <div class="clear"></div>
            </dl>
            <HR width="700px">
        </div>
        <!--wz end-->
    </c:forEach>
    <div class="page">
        <a href="javascript:void(0)" onclick="onclick_page(0)">首页</a>
        <a href="javascript:void(0)" onclick="onclick_page(${page-1})">上一页</a>
        <a href="javascript:void(0)" onclick="onclick_page(${page+1})">下一页</a>
        <a href="javascript:void(0)" onclick="onclick_page(${allpage-1})">尾页</a>
        <i>页码&nbsp;${page+1}</i>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('body').on("click", '.heart', function () {
            var A = $(this).attr("id");
            var B = A.split("like");
            var messageID = B[1];
            var C = parseInt($("#likeCount" + messageID).html());
            $(this).css("background-position", "")
            var D = $(this).attr("rel");
            if (D === 'like') {
                $("#likeCount" + messageID).html(C + 1);
                $(this).addClass("heartAnimation").attr("rel", "unlike");
            }
            else {
                $("#likeCount" + messageID).html(C - 1);
                $(this).removeClass("heartAnimation").attr("rel", "like");
                $(this).css("background-position", "left");
            }
        });
    });
</script>
</body>
</html>
