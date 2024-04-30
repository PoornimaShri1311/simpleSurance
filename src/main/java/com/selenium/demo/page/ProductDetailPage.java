package com.selenium.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage extends BasePage {

    @FindBy(id = "country-select")
    private WebElement countrySelect;

    @FindBy(id = "product-name-select")
    private WebElement productSelect;

    @FindBy(id = "tariff-name-select")
    private WebElement ratesSelect;

    @FindBy(id = "category-name-select")
    private WebElement categorySelect;

    @FindBy(id = "duration-select")
    private WebElement durationSelect;

    @FindBy(id = "frequency-select")
    private WebElement paymentSelect;

    @FindBy(id = "class-name-select")
    private WebElement classSelect;

    @FindBy(how = How.ID, using = "input-createCertificate_serialNumber")
    private WebElement serialNoEntry;
    @FindBy(how = How.ID, using = "input-createCertificate_deviceName")
    private WebElement deviceEntry;

    @FindBy(how = How.ID, using = "input-createCertificate_invoiceNumber")
    private WebElement invoiceEntry;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Weiter']")
    private WebElement FurtherClick;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFromDropdown(WebElement dropdown, int optionIndex) {
        waitForElementToBeVisible(dropdown);
        dropdown.click();
        WebElement option = driver.findElement(By.xpath("//li[" + optionIndex + "]"));
        waitForElementToBeVisible(option);
        option.click();
    }

    public void selectFromCustomDropdownCountry(int optionIndex) {
        waitForElementToBeVisible(countrySelect);
        selectFromDropdown(countrySelect, optionIndex);
    }

    public void selectFromCustomDropdownProduct(int optionIndex) {
        waitForElementToBeVisible(productSelect);
        selectFromDropdown(productSelect, optionIndex);
    }

    public void selectFromCustomDropdownRates(int optionIndex) {
        waitForElementToBeVisible(ratesSelect);
        selectFromDropdown(ratesSelect, optionIndex);
    }

    public void selectFromCustomDropdownCategory(int optionIndex) {
        waitForElementToBeVisible(categorySelect);
        selectFromDropdown(categorySelect, optionIndex);
    }

    public void selectFromCustomDropdownDuration(int optionIndex) {
        waitForElementToBeVisible(durationSelect);
        selectFromDropdown(durationSelect, optionIndex);
    }

    public void selectFromCustomDropdownPayment(int optionIndex) {
        waitForElementToBeVisible(paymentSelect);
        selectFromDropdown(paymentSelect, optionIndex);
    }

    public void selectFromCustomDropdownClass(int optionIndex) {
        waitForElementToBeVisible(classSelect);
        selectFromDropdown(classSelect, optionIndex);
    }

    public void setSerialNoEntry(String serialNo) {
        waitForElementToBeVisible(serialNoEntry);
        serialNoEntry.sendKeys(serialNo);
    }

    public void setDeviceEntry(String deviceName) {
        waitForElementToBeVisible(deviceEntry);
        deviceEntry.sendKeys(deviceName);
    }

    public void setInvoiceEntry(String invoiceNumber) {
        waitForElementToBeVisible(invoiceEntry);
        invoiceEntry.sendKeys(invoiceNumber);
    }

    public void setFurtherClick() {
        waitForElementToBeVisible(FurtherClick);
        FurtherClick.click();
    }
}

