package org.otsoi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.otsoi.utils.ConfigReader;

import java.time.Duration;

public class BasePage
{
    private static final int TIMEOUT_IN_SEC = 5;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofMillis(100);

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader configReader;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        configReader = new ConfigReader();
        wait = new WebDriverWait(driver, configReader.getTimeout(), configReader.getPolling());
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, (int)configReader.getTimeout().toSeconds()), this);
    }
}
