package hao.you.service.impl;

import hao.you.dao.ArticleDao;
import hao.you.domain.Article;
import hao.you.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public int addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public int deleteArticleById(int id) {
        return articleDao.deleteArticleById(id);
    }

    @Override
    public int update(Article article) {
        return articleDao.update(article);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleDao.getAllArticle();
    }

    @Override
    public List<Article> getPageArticle(Integer page) {
        return articleDao.getPageArticle(page);
    }

    @Override
    public List<Article> getArticleByUser(String user) {
        return articleDao.getArticleByUser(user);
    }

    @Override
    public List<Article> getPageArticleByUser(String user, Integer page) {
        return articleDao.getPageArticleByUser(user,page);
    }
}
