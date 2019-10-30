<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>昊哥博客</title>
    <meta name="keywords" content="昊哥博客"/>
    <meta name="description" content="昊哥博客"/>
    <link rel="Shortcut Icon" href="./images/my.jpg">
    <link rel="stylesheet" href="./css/index.css"/>
    <link rel="stylesheet" href="./css/style.css"/>
    <!-- chat css样式文件 -->
    <link rel="stylesheet" href="./css/chat.css">
    <!--jquery cdn-->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!--sockJS cdn-->
    <script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
    <!--stomp cdn-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <!-- chat js 文件-->
    <script src="./js/chat.js"></script>
    <%--各页面ajax--%>
</head>
<body>
<!--header start-->
<div id="header">
    <h1 id="header_up">昊哥博客
        <c:choose>
            <c:when test="${sessionScope.user==null}">
                <a href="./user/login" id="login">登录</a><a href="./user/register" id="register">注册</a>
            </c:when>
            <c:when test="${sessionScope.user!=null}">
                <%--<a href="#" id="login">${sessionScope.user.user_name}</a><a href="#" id="register">${sessionScope.user.user_name}</a></h1>--%>
                <img src="./images/my.jpg" id="icon"/>
                <%--<a href="#">${sessionScope.user.user_name}</a>--%>
                <div class="dropdown">
                    <a class="dropbtn">${sessionScope.user.user_name}</a>
                    <div class="dropdown-content">
                        <a href="#">个人中心</a>
                        <a href="./user/logout">注销</a>
                    </div>
                </div>
            </c:when>
        </c:choose>
    </h1>
    <p>---曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。</p>
</div>
<!--header end-->
<!--content start-->
<div id="content">
    <div class="left" id="c_left_chat">
        <a href="./home.jsp">返回主页</a>
    </div>
    <div class="wrapper">
        <div class="banner">
            <div id="activeUserWraper">
                <span class="label label-info" id="status"></span><span class="label">位用户当前在线</span>
            </div>
        </div>
        <div id="historyMsg">
        </div>
        <div class="controls">
            <div class="items">
                <form id="sendImageForm" enctype="multipart/form-data" method="post">
                    <input id="emoji" class="btn btn-primary" type="button" value="emoji" title="emoji"/>
                    <label for="sendImage" class="imageLable">
                        <input id="sendImageBtn" class="btn btn-success" type="button" value="发送图片"/>
                        <input id="sendImage" type="file" value="发送图片" name="image" accept="image/jpg,image/jpeg,image/png,image/gif"/>
                    </label>
                    <input id="clearBtn" class="btn btn-warning" type="button" value="清屏" title="清除屏幕消息"/>
                    <input id="myName" type="hidden" name="userName" value="${sessionScope.user.user_name}">
                </form>
            </div>
            <textarea class="form-control" id="messageInput" placeHolder="回车键发送"></textarea>
            <div id="emojiWrapper"></div>
        </div>
    </div>
</div>
<!--content end-->
<!--footer start-->
<div id="footer">
    <p>Design by:<a href="#" target="_blank">昊哥</a> 2019年7月31日19:17:30</p>
</div>
<!--footer end-->
</body>
</html>