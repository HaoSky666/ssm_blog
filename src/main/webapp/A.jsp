<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/test/style.css"/>
</head>
<body>
<article class="htmleaf-container">
    <div class="heart" id="like1" rel="like"></div>
    <div class="likeCount" id="likeCount1">14</div>
</article>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
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