package hao.you.controller;

import hao.you.domain.Article;
import hao.you.domain.User;
import hao.you.service.ArticleService;
import hao.you.utils.EditorUtil;
import hao.you.utils.ToolMethodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //查询所有文章
//    @RequestMapping("article/getAllArticle")
//    public String getAllArticle(Model model) {
//        List<Article> articleList = articleService.getAllArticle();
//        model.addAttribute("articles",articleList);
//        return "index";
//    }

    //主页的跳板
    @RequestMapping("index")
    public String index(Model model) {
        List<Article> allArticle = articleService.getAllArticle();
        model.addAttribute("articles", allArticle);
        return "index";
    }

    //分页查询文章
    @RequestMapping("article/getPageArticle")
    public String getPageArticle(Integer id, Model model) {
        Integer page = 0;//当前页
        Integer allpage = 0;//总页数

        List<Article> allArticle = articleService.getAllArticle();
        //如果未查询到文章，直接返回空的文章页
        if (allArticle.size() != 0) {
            if (allArticle.size() % 5 == 0) {
                allpage = allArticle.size() / 5;
            } else {
                allpage = allArticle.size() / 5 + 1;
            }
        } else {
            return "article";
        }
        if (ToolMethodUtil.notNull(id)) {
            page = id;
            if (page < 0 || page >= allpage) {
                return "redirect:/article/getPageArticle";
            }
        }
        List<Article> articles = articleService.getPageArticle(page * 5);
        model.addAttribute("articles", articles);
        model.addAttribute("page", page);
        model.addAttribute("allpage", allpage);
        return "article";
    }

    //分页查询某用户文章
    @RequestMapping("article/getPageArticleByUser")
    public String getPageArticleByUser(Integer id, Model model, HttpServletRequest request) {
        Integer page = 0;//当前页
        Integer allpage = 0;//总页数

        User user = (User) request.getSession().getAttribute("user");
        List<Article> allArticle = articleService.getArticleByUser(user.getUser_name());
        //如果未查询到文章，直接返回空的文章页
        if (allArticle.size() != 0) {
            if (allArticle.size() % 6 == 0) {
                allpage = allArticle.size() / 6;
            } else {
                allpage = allArticle.size() / 6 + 1;
            }
        } else {
            return "management";
        }
        if (ToolMethodUtil.notNull(id)) {
            page = id;
            if (page < 0 || page >= allpage) {
                return "redirect:/article/getPageArticleByUser";
            }
        }
        List<Article> articles = articleService.getPageArticleByUser(user.getUser_name(), page * 6);
        model.addAttribute("articles01", articles);
        model.addAttribute("page01", page);
        model.addAttribute("allpage01", allpage);
        return "management";
    }

    //通过id查找文章
    @RequestMapping("article/getArticleById")
    public String getArticleById(Integer id, Model model) {
        Article article = articleService.getArticleById(id);
        //将数据库返回的字符串转为美化的样式
        article.setArticle_text(EditorUtil.toEditor(article.getArticle_text()));
        model.addAttribute("article", article);
        return "news";
    }

    //添加文章
    @RequestMapping("article/addArticle")
    public String addArticle(Article article, HttpServletRequest request) {
        article.setArticle_author(request.getParameter("author"));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setArticle_time(sf.format(new Date()));
        articleService.addArticle(article);
        return "redirect:../index";
    }

    //删除文章
    @RequestMapping("article/deleteArticle")
    public String deleteArticle(Integer id) {
        articleService.deleteArticleById(id);
        return "redirect:/article/getPageArticleByUser";
    }

    //修改文章
    @RequestMapping("article/updateArticle")
    public String updateArticle(Integer id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "blogging";
    }

    @RequestMapping("article/update")
    public String update(Article article, Integer id) {
        article.setArticle_id(id);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setArticle_time(sf.format(new Date()));
        articleService.update(article);
        return "redirect:../index";
    }

    //写文章时判断是登录，如果未登录，则跳转到登录界面
    @RequestMapping("article/checkLogin")
    public String checkLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        if (ToolMethodUtil.notNull(username)) {
            return "blogging";
        }
        return "login";
    }
}
