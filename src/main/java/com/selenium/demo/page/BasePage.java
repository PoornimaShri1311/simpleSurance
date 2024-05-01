package com.selenium.demo.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasePage {

    public final WebDriver driver;
    private final WebDriverWait wait;
    private final Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.logger = Logger.getLogger(BasePage.class.getName());
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element is visible.");
            highlightElement(element);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred while waiting for element visibility: " + e.getMessage(), e);
            throw e;
        }
    }

    private void highlightElement(WebElement element) {
        // JavaScript to highlight the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    public String getBrowserTabTitle() {
        return driver.getTitle();
    }
}
