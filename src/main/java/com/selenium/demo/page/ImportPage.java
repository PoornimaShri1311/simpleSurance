package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'CSV Datei auswählen oder löschen')]")
    private WebElement selectCSV;

    @FindBy(xpath = "//span[contains(text(),'Versicherung erstellen')]")
    private WebElement createInsuranceButton;

    @FindBy(xpath = "//li[contains(.,'Fehler bei  errors message:')]")
    private WebElement importError;

    @FindBy(xpath = "//button[@aria-label='Close']//*[name()='svg']")
    private WebElement closeButton;

    @FindBy(xpath = "//th[contains(text(),'test@test.com')]")
    private WebElement dataVerification;

    @FindBy(xpath = "//div[@role='presentation']//input[@type='file']")
    private WebElement fileInput;

    public ImportPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectCSVFile(String filePath) {
        fileInput.sendKeys(filePath);
    }

    public void clickCreateInsuranceButton() {
        waitForElementToBeVisible(createInsuranceButton);
        createInsuranceButton.click();
    }

    public boolean isImportErrorDisplayed() {
        return importError.isDisplayed();
    }

    public void clickCloseButton() {
        waitForElementToBeVisible(closeButton);
        closeButton.click();
    }

    public boolean isDataVerificationDisplayed() {
        return dataVerification.isDisplayed();
    }
}

