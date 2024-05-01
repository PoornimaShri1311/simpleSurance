package com.selenium.demo.test.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class ScreenshotListener implements ITestListener {
    private TestBase testBase;

    public ScreenshotListener() {
    }

    public ScreenshotListener(TestBase testBase) {
        this.testBase = testBase;
    }

    public void setTestBase(TestBase testBase) {
        this.testBase = testBase;
    }

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        if (testBase != null) {
            testBase.captureScreenshot(result.getMethod().getMethodName());
        } else {
            System.out.println("TestBase is null. Cannot capture screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    @Override
    public void onStart(ITestContext context) {
        // not implemented
    }

    @Override
    public void onFinish(ITestContext context) {
        // not implemented
    }

}
