package hao.you.dao;

import hao.you.domain.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {
    @Insert("insert into article(article_title,article_text,article_author,article_time,article_class) " +
            "values(#{article_title},#{article_text},#{article_author},#{article_time},#{article_class})")
    public int addArticle(Article article);

    //删除文章
    @Delete("delete from article where article_id = #{article_id}")
    public int deleteArticleById(int id);

    //修改文章
    @Update("update article set article_title = #{article_title}, article_text = #{article_text}" +
            ", article_time = #{article_time}, article_class = #{article_class} where article_id = #{article_id}")
    public int update(Article article);

    @Select("select * from article where article_id = #{article_id}")
    public Article getArticleById(Integer id);

    // 查询当前用户所写的文章
    @Select("select * from article where article_author = #{article_author} order by article_time desc")
    public List<Article> getArticleByUser(String article_author);

    // 分页查询当前用户所写的文章
    @Select("select t.* from (select * from article where article_author = #{article_author} order by article_time desc) as t limit #{page},6")
    public List<Article> getPageArticleByUser(@Param("article_author") String article_author, @Param("page") Integer page);

    @Select("select * from article order by article_time desc")
    public List<Article> getAllArticle();

    @Select("select t.* from (select * from article order by article_time DESC) as t limit #{page},5")
    public List<Article> getPageArticle(Integer page);
}
