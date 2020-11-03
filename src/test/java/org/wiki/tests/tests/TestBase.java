package org.wiki.tests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.wiki.tests.fw.ApplicationManager;

import java.net.MalformedURLException;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setup() throws MalformedURLException {
        app.init();
    }

    @AfterClass(enabled = false)
    public void cleanAfterTests() {
        app.getArticleHelper().removeReadingList();
    }

    public void tearDown() {
        app.stop();
    }
}
