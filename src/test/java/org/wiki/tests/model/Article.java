package org.wiki.tests.model;

public class Article {
    private String articleName;

    public Article setArticleName (String articleName) {
        this.articleName = articleName;
        return this;
    }

    public String getArticleName() {
        return articleName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleName='" + articleName + '\'' +
                '}';
    }
}
