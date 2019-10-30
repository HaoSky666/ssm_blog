<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>昊哥博客</title>
    <meta name="keywords" content="昊哥博客"/>
    <meta name="description" content="昊哥博客"/>
    <link rel="Shortcut Icon" href="./images/my.jpg">
    <link rel="stylesheet" href="./css/index.css"/>
    <link rel="stylesheet" href="./css/style.css"/>
    <!--jquery cdn-->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <%--各页面ajax--%>
    <script src="./js/index.js"></script>
</head>
<body>
<!--header start-->
<div id="header">
    <h1><p>昊哥博客</p>
        <c:choose>
            <c:when test="${sessionScope.user==null}">
                <a href="./user/login" id="login">登录</a>
                <a href="./user/register" id="register">注册</a>
            </c:when>
            <c:when test="${sessionScope.user!=null}">
                <img src="./images/my.jpg" id="icon"/>
                <div class="dropdown">
                    <a class="dropbtn">${sessionScope.user.user_name}</a>
                    <div class="dropdown-content">
                        <a href="javascript:void(0)" onclick="onclick_management()">文章管理</a>
                        <a href="javascript:void(0)" onclick="onclick_management()">个人中心</a>
                        <a href="./user/logout">注销</a>
                    </div>
                </div>
            </c:when>
        </c:choose>
    </h1>
    <p>个人博客。<br><br>用于记录学习笔记，发发牢骚，实现某个有趣的小功能，或是打发无聊的上班时间。<br>慢慢来，别急</p>
</div>
<!--header end-->
<!--nav-->
<div id="nav">
    <ul>
        <li><a href="javascript:void(0)" onclick="onclick_index()">首页</a></li>
        <li><a href="./chat">在线聊天室</a></li>
        <li><a href="javascript:void(0)">预留一</a></li>
        <li><a href="javascript:void(0)">预留二</a></li>
        <li><a href="javascript:void(0)">预留三</a></li>
        <li><a href="javascript:void(0)">预留四</a></li>
        <li><a href="javascript:void(0)">预留五</a></li>
        <div class="clear"></div>
    </ul>
</div>
<!--nav end-->
<!--content start-->
<div id="content">
    <!--left-->
    <div class="left" id="c_left"></div>
    <!--left end-->
    <!--right-->
    <div class="right" id="c_right">
        <c:choose>
            <c:when test="${sessionScope.user!=null}">
                <div class="s_about">
                    <h2>关于博主</h2>
                    <img src="./images/my.jpg" width="230" height="230" alt="博主"/>
                    <p><b>博主：</b>${sessionScope.user.user_name}</p>
                    <p><b>职业：</b>程序猿</p>
                    <p><b>简介：</b>小辣鸡一只</p>
                    <div class="clear"></div>
                </div>
            </c:when>
        </c:choose>
        <!--栏目分类-->
        <div class="lanmubox">
            <div class="hd">
                <ul>
                    <li>精心推荐</li>
                </ul>
            </div>
            <div class="bd">
                <ul>
                    <c:forEach items="${articles}" var="article">
                        <c:choose>
                            <c:when test="${fn:length(article.article_title)>15}">
                                <li><a href="javascript:void(0)" onclick="onclick_news('${article.article_id}')" title="${article.article_title}">${fn:substring(article.article_title,0,14)}...</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:void(0)" onclick="onclick_news('${article.article_id}')" title="${article.article_title}">${article.article_title}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--end-->
        <div class="link">
            <h2>友情链接</h2>
            <p><a href="http://139.196.163.240/" target="_blank">凡哥牛皮哄哄的博客</a></p>
            <p><a href="http://www.baidu.com" target="_blank">百度</a></p>
            <p><a href="http://www.bing.com" target="_blank">bing</a></p>
            <p><a href="http://www.51job.com" target="_blank">51job</a></p>
        </div>
    </div>
    <!--right end-->
    <div class="clear"></div>
</div>
<!--content end-->
<!--footer start-->
<div id="footer">
    <p>Design by:<a href="#" target="_blank">昊哥</a> 2019年7月31日19:17:30</p>
</div>
<!--footer end-->
</body>
</html>