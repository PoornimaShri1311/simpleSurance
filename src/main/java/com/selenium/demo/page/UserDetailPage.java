package com.selenium.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserDetailPage extends BasePage {
    @FindBy(id = "input-createCertificate_firstName")
    private WebElement firstName;

    @FindBy(id = "input-createCertificate_lastName")
    private WebElement lastname;

    @FindBy(id = "input-createCertificate_email")
    private WebElement email;

    @FindBy(id = "input-createCertificate_streetName")
    private WebElement streetName;

    @FindBy(id = "input-createCertificate_streetNumber")
    private WebElement streetNo;

    @FindBy(id = "input-createCertificate_zip")
    private WebElement Zipcode;

    @FindBy(id = "input-createCertificate_city")
    private WebElement city;

    @FindBy(id = "input-createCertificate_country")
    private WebElement country;

    public UserDetailPage(WebDriver driver) {
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

    public void setFirstName(String fname) {

        waitForElementToBeVisible(firstName);
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname) {

        waitForElementToBeVisible(lastname);
        lastname.sendKeys(lname);
    }

    public void setEmail(String emailAddress) {
        waitForElementToBeVisible(email);
        email.sendKeys(emailAddress);
    }

    public void setStreetName(String street) {

        waitForElementToBeVisible(streetName);
        streetName.sendKeys(street);
    }

    public void setStreetNumber(String number) {

        waitForElementToBeVisible(streetNo);
        streetNo.sendKeys(number);
    }

    public void setZipcode(String zipcode) {
        waitForElementToBeVisible(Zipcode);
        Zipcode.sendKeys(zipcode);
    }

    public void setCity(String cityName) {
        waitForElementToBeVisible(city);
        city.sendKeys(cityName);
    }

    public void setCountry(String countryName) {
        waitForElementToBeVisible(country);
        country.sendKeys(countryName);
    }
}

