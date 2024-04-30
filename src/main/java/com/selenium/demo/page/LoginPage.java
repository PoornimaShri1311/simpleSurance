package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "login_username")
    private WebElement emailTextBox;
    @FindBy(how = How.ID, using = "login_password")
    private WebElement passwordTextBox;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        waitForElementToBeVisible(emailTextBox);
        emailTextBox.sendKeys(email);
    }

    public void setPassword(String password) {
        waitForElementToBeVisible(passwordTextBox);
        passwordTextBox.sendKeys(password);
    }

    public void clickOnSignInButton() {
        waitForElementToBeVisible(signInButton);
        signInButton.click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickOnSignInButton();
    }

}
