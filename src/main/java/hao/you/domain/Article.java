package hao.you.domain;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer article_id;
    private String article_title;
    private String article_text;
    private String article_author;
    private String article_time;
    private String article_class;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public String getArticle_time() {
        return article_time;
    }

    public void setArticle_time(String article_time) {
        this.article_time = article_time;
    }

    public String getArticle_class() {
        return article_class;
    }

    public void setArticle_class(String article_class) {
        this.article_class = article_class;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id='" + article_id + '\'' +
                ", article_title='" + article_title + '\'' +
                ", article_text='" + article_text + '\'' +
                ", article_author='" + article_author + '\'' +
                ", article_time=" + article_time +
                ", article_class='" + article_class + '\'' +
                '}';
    }
}
