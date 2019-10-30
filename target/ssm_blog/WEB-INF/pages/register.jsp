<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="Shortcut Icon" href="../images/my.jpg">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<div class="login-block">
    <div class="login-animate">
        <div class="left-ear"></div>
        <div class="right-ear"></div>
        <div class="head">
            <div class="left-eye"></div>
            <div class="right-eye"></div>
            <div class="face">
                <div class="nose"></div>
                <div class="mouth"></div>
            </div>
        </div>
        <div class="body"></div>
        <div class="left-arm"></div>
        <div class="right-arm"></div>
    </div>
    <p id="msg">${msg}</p>
    <div class="login-form">
        <form action="./addUser" method="post">
            <div class="username">
                <input type="text" name="user_name" placeholder="会员名/邮箱/手机号">
            </div>
            <div class="password">
                <input type="password" name="user_password" placeholder="密码">
                <div class="pwd-eye" data-flag="hide"></div>
            </div>
            <div class="login-button">
                <input type="submit" value="注  册">
            </div>
            <div class="register">
                <a href="./login" id="login_register">返回登录</a>
                <a href="../home.jsp" id="login_lost">返回主页</a>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".pwd-eye").hide();
        $(".pwd-eye").click(function () {
            var flag = $(this).attr('data-flag');
            $(this).css('background-image', 'url("../images/bear/password-'+flag+'.png")');
            $(this).attr('data-flag', flag == 'show' ? 'hide' : 'show');
            $('input[name="user_password"]').attr('type', flag == 'show'?'password':'text');
            if (flag != 'show' && $('input[name="user_password"]').val() != '') {
                $('.left-arm').addClass('show');
                $('.mouth').addClass('show');
                $('.right-arm').addClass('show');
            } else {
                $('.left-arm').removeClass('show');
                $('.mouth').removeClass('show');
                $('.right-arm').removeClass('show');
            }
        });
        //当通过鼠标点击选中元素或通过 tab 键定位到密码栏时
        $('input[name="user_password"]').focus(function () {
            $(".pwd-eye").hide();
            $(".login-animate").removeClass('username-animate');
            $(".login-animate").addClass('password-animate');
        });
        //当密码域失去焦点时
        $('input[name="user_password"]').blur(function () {
            if ($(this).val() == '') {
                $(".pwd-eye").hide();
                $(".login-animate").removeClass('username-animate');
                $(".login-animate").removeClass('password-animate');
            }
        });

        $('input[name="user_name"]').focus(function () {
            $(".login-animate").addClass('username-animate');
            $(".login-animate").removeClass('password-animate');
            var length = $(this).val().length;
            getposition(length);
        });
        $('input[name="user_name"]').bind('input', function () {
            var length = $(this).val().length;
            getposition(length);
        });

        function getposition(length) {
            var face = parseFloat(1.5 / 36 * length);
            var nose = parseFloat(1 / 36 * length);
            var left_eye = parseFloat(1.5 / 36 * length);
            var right_eye = parseFloat(2 / 36 * length);
            var left_ear = parseFloat(1 / 36 * length);
            var right_ear = parseFloat(1 / 36 * length);
            $('.face').css('left', 1 + (face > 1.5 ? 1.5 : face) + 'em');
            $('.nose').css('left', 0.9 + (nose > 1 ? 1 : nose) + 'em');
            $('.left-eye').css('left', 0.5 + (left_eye > 1.5 ? 1.5 : left_eye) + 'em');
            $('.right-eye').css('left', 4 + (right_eye > 2 ? 2 : right_eye) + 'em');
            $('.left-ear').css('left', 1.5 - (left_ear > 1 ? 1 : left_ear) + 'em');
            $('.right-ear').css('left', 7.5 - (right_ear > 1 ? 1 : right_ear) + 'em');
            if (length >= 6) {
                $('.left-eye').addClass('doe');
                $('.right-eye').addClass('doe');
                $('.mouth').addClass('doe');
            } else {
                $('.left-eye').removeClass('doe');
                $('.right-eye').removeClass('doe');
                $('.mouth').removeClass('doe');
            }
        }

        $('input[name="user_name"]').blur(function () {
            $(".login-animate").removeClass('username-animate');
            $(".login-animate").removeClass('password-animate');
            $('.face').attr('style', '');
            $('.nose').attr('style', '');
            $('.left-eye').attr('style', '');
            $('.right-eye').attr('style', '');
            $('.left-ear').attr('style', '');
            $('.right-ear').attr('style', '');
        });
    });
</script>
</body>
</html>