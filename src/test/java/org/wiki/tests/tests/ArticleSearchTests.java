package org.wiki.tests.tests;

import org.testng.annotations.Test;
import org.wiki.tests.model.Article;

public class ArticleSearchTests extends TestBase{
    @Test
    public void searchArticle(Article article) {
        app.getArticleHelper().searchArticle(article.setArticleName("Vladimir Lenin"));
        app.getArticleHelper().addToFavorites(article.setArticleName("Vladimir Lenin"));
        cleanAfterTests();
    }
}
