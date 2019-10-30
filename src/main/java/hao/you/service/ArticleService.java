package hao.you.service;

import hao.you.domain.Article;

import java.util.List;

public interface ArticleService {
    public int addArticle(Article article);
    public int deleteArticleById(int id);
    public int update(Article article);
    public Article getArticleById(Integer id);
    public List<Article> getAllArticle();
    public List<Article> getPageArticle(Integer page);
    public List<Article> getArticleByUser(String user);
    public List<Article> getPageArticleByUser(String user,Integer page);
}
