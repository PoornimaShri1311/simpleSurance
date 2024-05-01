package com.selenium.demo.test.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.demo.page.BasePage;
import com.selenium.demo.page.HomePage;
import com.selenium.demo.page.LoginPage;
import com.selenium.demo.util.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setUpExtentReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://insurance-manager.sb-qa-candidatetask.sisu.sh/login");
        test = extent.createTest(getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "Test case failed: " + result.getName());
                test.log(Status.FAIL, "Test case failed reason: " + result.getThrowable());
                captureScreenshot(result.getMethod().getMethodName());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, "Test case passed: " + result.getName());
                captureScreenshot(result.getMethod().getMethodName());
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.log(Status.SKIP, "Test case skipped: " + result.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }

    public void captureScreenshot(String testName) {
        try {
            if (driver instanceof TakesScreenshot) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotName = "screenshots/" + testName + ".png";
                File destFile = new File(screenshotName);
                destFile.getParentFile().mkdirs();
                destFile.createNewFile();
                // Copy the file to the destination
                org.apache.commons.io.FileUtils.copyFile(screenshot, destFile);
                // Add screenshot to the Extent report
                test.addScreenCaptureFromPath(destFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void verifyValidUserLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        try {
            Assert.assertEquals(basePage.getBrowserTabTitle(), "Insurance Manager");
            loginPage.login(email, password);
            Assert.assertEquals(basePage.getBrowserTabTitle(), "Insurance Manager");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Login failed: " + e.getMessage());
            throw e; // Rethrow the assertion error to mark the test as failed
        }
    }
}
