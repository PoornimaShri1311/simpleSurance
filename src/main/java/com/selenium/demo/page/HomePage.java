package com.selenium.demo.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[normalize-space()='Neu']")
    private WebElement newBtn;

    @FindBy(xpath = "//span[normalize-space()='Importieren']")
    private WebElement importBtn;

    @FindBy(xpath = "//span[normalize-space()='Liste']")
    private WebElement listBtn;

    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement labelElement;

    @FindBy(xpath = "//li[@role='option']//span[contains(text(),'E-Mail')]")
    private WebElement emailOptionElement;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputElement;

    @FindBy(xpath = "//th[contains(.,'email@abc.com')]")
    private WebElement emailDisplayedElement;

    @FindBy(xpath = "//div[@role='button']//*[name()='svg'][2]")
    private WebElement buttonElement;

    @FindBy(xpath = "//th[@data-sort='POLICY_NUMBER']//*[name()='svg']")
    private WebElement policyNumberSortElement;

    @FindBy(xpath = "//th[text()='sample@123.com']")
    private WebElement sampleEmailDisplayedElement;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnNewBtn() {
        waitForElementToBeVisible(newBtn);
        newBtn.click();
    }

    public void clickOnImportBtn() {
        waitForElementToBeVisible(importBtn);
        importBtn.click();
    }

    public void clickOnListBtn() {
        waitForElementToBeVisible(listBtn);
        listBtn.click();
    }

    public void setLabelElementClick() {
        waitForElementToBeVisible(labelElement);
        labelElement.click();
    }

    public void setEmailOptionElementClick() {
        waitForElementToBeVisible(emailOptionElement);
        emailOptionElement.click();
    }

    public void setInputElement(String text) {
        waitForElementToBeVisible(inputElement);
        inputElement.sendKeys(text);
        inputElement.sendKeys(Keys.ENTER);
    }

    public void setEmailDisplayedElement() {
        waitForElementToBeVisible(emailDisplayedElement);
        emailDisplayedElement.isDisplayed();
    }

    public void setButtonElementClick() {
        waitForElementToBeVisible(buttonElement);
        buttonElement.click();
    }

    public void setPolicyNumberSortElementClick() {
        waitForElementToBeVisible(policyNumberSortElement);
        policyNumberSortElement.click();
    }

    public void sampleEmailDisplayedElementDisplayed() {
        waitForElementToBeVisible(sampleEmailDisplayedElement);
        sampleEmailDisplayedElement.isDisplayed();
    }

}
