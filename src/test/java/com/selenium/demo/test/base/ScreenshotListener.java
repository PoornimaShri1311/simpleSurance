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
        // Default constructor
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
        testBase.captureScreenshot(result.getMethod().getMethodName());
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
