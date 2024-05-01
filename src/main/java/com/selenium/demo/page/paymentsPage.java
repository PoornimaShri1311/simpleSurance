package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentsPage extends BasePage {
    @FindBy(xpath = "//iframe[@title='Sicherer Eingaberahmen für Kartenzahlungen']")
    private WebElement paymentFrame;

    @FindBy(name = "cardnumber")
    private WebElement cardNumberInput;

    @FindBy(name = "exp-date")
    private WebElement expiryDateInput;

    @FindBy(name = "cvc")
    private WebElement cvcInput;

    @FindBy(xpath = "//span[text()='Kostenpflichtig bestellen']")
    private WebElement confirmOrder;

    @FindBy(xpath = "//td//div//span[contains(text(),'Erstellt')]")
    private WebElement orderCreation;

    public paymentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToPaymentFrame() {
        driver.switchTo().frame(paymentFrame);
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvc) {
        waitForElementToBeVisible(cardNumberInput);
        waitForElementToBeVisible(expiryDateInput);
        waitForElementToBeVisible(cvcInput);
        cardNumberInput.sendKeys(cardNumber);
        expiryDateInput.sendKeys(expiryDate);
        cvcInput.sendKeys(cvc);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void setConfirmOrder() {
        waitForElementToBeVisible(confirmOrder);
        confirmOrder.click();
    }

    public boolean isOrderCreationDisplayed() {
        waitForElementToBeVisible(orderCreation);
        return orderCreation.isDisplayed();
    }

}

