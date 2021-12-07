package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jay Vaghani
 */
public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(name = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;


    public void verifyWelcomeText(String text) {
       verifyThatTextIsDisplayed(welcomeText,text);
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
       CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
       CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
       CustomListeners.test.log(Status.PASS, "Get errorMessage: ");
        return message;
    }
}
