package org.otsoi.steps;

import org.openqa.selenium.WebDriver;
import org.otsoi.context.TestContext;
import org.otsoi.utils.ConfigReader;

public class BaseTestSteps {
    TestContext testContext;
    ConfigReader configReader;
    private WebDriver driver;

    public BaseTestSteps(TestContext testContext, ConfigReader configReader){
        this.testContext = testContext;
        this.configReader = configReader;
    }

    public void beforeEach() {
        driver =  this.testContext.getWebDriverManager().getDriver();
    }

    public void afterEach() {
        if(null != driver) {
            this.testContext.getWebDriverManager().closeDriver();
        }
    }

    public WebDriver getDriver() {
        return this.testContext.getWebDriverManager().getDriver();
    }
}
