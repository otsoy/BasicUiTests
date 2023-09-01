package org.otsoi.context;

import org.otsoi.webdriver.WebDriverManager;

public class TestContext {
    private final WebDriverManager webDriverManager;
    public TestContext(){
        webDriverManager = new WebDriverManager();
    }
    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
}
