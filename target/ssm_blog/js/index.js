$(document).ready(function(){
    onclick_index();
});
//主页
function onclick_index() {
    htmlobj=$.ajax({url:"./article/getPageArticle",async:false});
    $("#c_left").html(htmlobj.responseText);
}
//分页查询某用户所有文章
function onclick_management(){
    htmlobj=$.ajax({url:"./article/getPageArticleByUser",async:false});
    $("#c_left").html(htmlobj.responseText);
}
//在线聊天室
function onclick_chat() {
    htmlobj=$.ajax({url:"./user/chat",async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_shuo() {
    htmlobj=$.ajax({url:"./shuo.jsp",async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_riji() {
    htmlobj=$.ajax({url:"./riji.jsp",async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_learn() {
    htmlobj=$.ajax({url:"./learn.jsp",async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_guestbook() {
    htmlobj=$.ajax({url:"./guestbook.jsp",async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_news(id) {
    htmlobj=$.ajax({url:"./article/getArticleById?id="+id,async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_blogging() {
    htmlobj=$.ajax({url:"./article/checkLogin?username=${sessionScope.user.user_name}",async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_page(page) {
    htmlobj=$.ajax({url:"./article/getPageArticle?id="+page,async:false});
    $("#c_left").html(htmlobj.responseText);
}
function onclick_management_page(page) {
    htmlobj=$.ajax({url:"./article/getPageArticleByUser?id="+page,async:false});
    $("#c_left").html(htmlobj.responseText);
}
//删除文章
function deleteArticle(articleId) {
    htmlobj=$.ajax({url:"./article/deleteArticle?id="+articleId,async:false});
    $("#c_left").html(htmlobj.responseText);
}
//修改文章
function updateArticle(articleId){
    htmlobj=$.ajax({url:"./article/updateArticle?id="+articleId,async:false});
    $("#c_left").html(htmlobj.responseText);
}