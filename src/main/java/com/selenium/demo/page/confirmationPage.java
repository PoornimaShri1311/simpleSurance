package com.selenium.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'Alle Informationen ')]")
    private WebElement correctInformationMessage;

    @FindBy(xpath = "//span[contains(text(),' Kunde erklärt sich einverst')]")
    private WebElement personalDataMessage;

    @FindBy(xpath = "//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1yr5ci3']")
    private WebElement customerInformedMessage;

    @FindBy(xpath = "//span[contains(text(),'rsichernde Produkt ist nicht älter al')]")
    private WebElement productAgeMessage;

    @FindBy(xpath = "//span[normalize-space()='Versicherung erstellen']")
    private WebElement createInsurance;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement paymentProceed;

    @FindBy(xpath = "//span[normalize-space()='Kostenpflichtig bestellen']")
    private WebElement orderClick;


    public confirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAllMessages() {
        click(correctInformationMessage);
        click(personalDataMessage);
        click(customerInformedMessage);
        click(productAgeMessage);
        click(createInsurance);
        click(paymentProceed);
    }

    private void click(WebElement element) {

        waitForElementToBeVisible(element);
        element.click();
    }

    private void setOrderClick() {

        waitForElementToBeVisible(orderClick);
        orderClick.click();
    }

}

