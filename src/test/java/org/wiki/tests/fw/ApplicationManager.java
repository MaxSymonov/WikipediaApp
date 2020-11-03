package org.wiki.tests.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public AppiumDriver driver;
    DesiredCapabilities capabilities;

    ArticleHelper articleHelper;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:/Users/Aharon/Downloads/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        articleHelper = new ArticleHelper(driver);

    }

    public void stop() {
        driver.quit();
    }

    public ArticleHelper getArticleHelper() {
        return articleHelper;
    }
}
