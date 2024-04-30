package com.selenium.demo.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    private static final String BROWSER = System.getenv("browser");
    private static final String WINDOW_WIDTH = System.getenv("window_width");
    private static final String WINDOW_HEIGHT = System.getenv("window_height");
    private static final String HEADLESS = "--headless";
    private static final String CHROME = "chrome";
    private static final String HEADLESS_CHROME = "headless-chrome";
    private static final String EDGE = "edge";
    private static final String WINDOW_SIZE = "--window-size=" + WINDOW_WIDTH + "x" + WINDOW_HEIGHT;

    public static WebDriver getDriver() {
        if (BROWSER == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        switch (BROWSER.toLowerCase()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case HEADLESS_CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments(HEADLESS);
                chromeOptions.addArguments(WINDOW_SIZE);
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }

}
