package org.wiki.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.wiki.tests.model.Article;

public class ArticleHelper extends HelperBase {
    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void searchArticle(Article article) {
        String articleNameCheck = driver.findElementById("view_page_title_text").getText();
        String searchResult = article.getArticleName();
        tap(By.id("search_container"));
        waitAndType(By.id("search_src_text"), article.getArticleName());
        closeKeyboard();
        tap(By.id("fragment_feed_header"));

        Assert.assertEquals(searchResult, articleNameCheck);
    }

    public void addToFavorites(Article article) {
        tap(By.xpath("[@content-desc='Add this article to a reading list']"));
        tap(By.id("create_button"));
        waitClickable(By.id("button1"));
        tap(By.id("snackbar_action"));
        String checkTitle = driver.findElement(By.id("reading_list_contents")).getText();

        Assert.assertTrue(checkTitle.contains(article.getArticleName()));

        tap(By.xpath("(//android.widget.ImageView[@content-desc='More options'])[2]"));
        tap(By.id("reading_list_item_remove_text"));
    }

    public void removeReadingList() {
        waitForElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]")).click();
    }
}
